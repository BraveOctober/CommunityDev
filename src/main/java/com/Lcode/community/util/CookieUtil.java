package com.Lcode.community.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;


public class CookieUtil {
    public static String getCookie(HttpServletRequest request, String code)
    {
        if (request == null || code == null) {
            throw new IllegalArgumentException("参数为空!");
        }

        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie : cookies){
                if (cookie.getName().equals(code)){
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
