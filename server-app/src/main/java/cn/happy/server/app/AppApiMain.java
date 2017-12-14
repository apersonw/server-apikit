package cn.happy.server.app;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class AppApiMain {

    public static void main(String... args) {
        try {
            File dir = new File("lib");
            URLClassLoader cl = (URLClassLoader) ClassLoader.getSystemClassLoader();
            if (dir.exists()) {
                File[] fileArray = dir.listFiles();

                Method addURL = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
                addURL.setAccessible(true);
                assert fileArray != null;
                for (File file : fileArray) {
                    addURL.invoke(cl, file.toURI().toURL());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        AppApplication.main(args);
    }
}
