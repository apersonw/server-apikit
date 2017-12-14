package cn.happy.server.app;

public class ErrorThread extends Thread {
    private Throwable throwable;

    public ErrorThread(Runnable runnable) {
        super(runnable);
        setUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    public Throwable getThrowable() {
        return throwable;
    }


    private static final UncaughtExceptionHandler uncaughtExceptionHandler = (Thread t, Throwable throwable) -> {
        ((ErrorThread) t).throwable = throwable;
    };
}
