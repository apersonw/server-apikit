package cn.happy;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] decode = Base64.getUrlDecoder().decode("iVBORw0KGgoAAAANSUhEUgAAACwAAAAsCAYAAAAehFoBAAAAAXNSR0IArs4c6QAAAPtJREFUWAnV2FsKwjAQBdCmuKN0Dy7LujyhXYwrSBsxojbRNpnHnfsTCAycGUI+ppvneewMpQ8hXCyh+zhcS+gH2BL6BbaC/gBbQG/A6OgsGBldBKOic+B7xKagfXk58HnFwqI34GEYbisYFr0Bx6eAjM6CkdFFMCr6JxgR/ReMht4FRkLvBqOgD4ER0IfB2ugqsCa6GqyFbgJroJvB0mgSsCSaDCyFJgVLoMnB3GgWMCeaDcyFZgVzoNnB1GgRMCVaDEyFFgVToMXBrWgVcAtaDVyLVgXXoN00TSEWosY5d/Xej8mnPuEEKZ3f+2l4cGzkHX0qdYZ2/0R3Cw54Yf7sgDmEAAAAAElFTkSuQmCC");
        System.out.println(new String(decode,"utf8"));
    }
}
