package com.jiyehoo.res;

/**
 * TODO feature
 *
 * @author aobing
 * @since 2022/2/26 11:33 下午
 */
public class URLUtils {

    private static String host = "http://14.116.191.135:18899";

    private static String loginPath = "/user/logIn";
    private static String verification = "/user/getVerification";


    public static String getLoginUrl() {
        return host + loginPath;
    }

}
