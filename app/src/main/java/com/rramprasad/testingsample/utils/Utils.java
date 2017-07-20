package com.rramprasad.testingsample.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ramprasad on 7/18/17.
 */

public class Utils {

    /**
     * Check given email is valid.
     *
     * @param email
     * @return
     */
    public static boolean isValidUserName(String email) {
        Pattern pattern;
        Matcher matcher;

        boolean validEmail = (email.length() > 4) && email.contains("@") && email.contains(".") && !email.startsWith("@")
                && !email.startsWith("_") && !email.startsWith(".")
                && !email.endsWith("@") && !email.endsWith("_")
                && !email.endsWith(".") && !email.contains(" ")
                && email.substring((email.indexOf('@')), (email.length() - 1)).contains(".");
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches()&&validEmail;
    }

    /**
     * Check given password is valid.
     *
     * @param password
     * @return
     */
    public static boolean isValidPassword(String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN ="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^!_&+()/*:;'\"?<>.,~`=-]).{6,16})";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
