package indi.princelo.concise.helper;

import java.util.Random;

public class Str {
    /**
     * Determine if a given string is blank
     * @param str
     * @return
     */
    public static boolean blank(String str) {
        return null == str || "".equals(str);
    }

    /**
     * Get the portion of a string before a given value.
     * @param subject the string to get a substring from, may be nul
     * @param search the string to search for, may be null
     * @return
     */
    public static String before(String subject, String search) {
        return blank(search) ? subject : subject.split(search)[0];
    }

    /**
     * Cap a string with a single instance of a given value.
     * @param value
     * @param cap
     * @return
     */
    public static String finish(String value, String cap) {
        if (blank(value)) {
            return cap;
        }
        if (value.endsWith(cap)) {
            return value;
        }
        return value + cap;
    }

    /**
     * Limit the number of characters in a string.
     * @param value
     * @return
     */
    public static String limit(String value) {
        int limit = 100;
        String end = "...";
        return limit(value, limit, end);
    }

    /**
     * Limit the number of characters in a string.
     * @param value
     * @param limit
     * @return
     */
    public static String limit(String value, int limit) {
        String end = "...";
        return limit(value, limit, end);
    }

    /**
     * Limit the number of characters in a string.
     * @param value
     * @param end
     * @return
     */
    public static String limit(String value, String end) {
        int limit = 100;
        return limit(value, limit, end);
    }

    /**
     * Limit the number of characters in a string.
     * @param value
     * @param limit
     * @param end
     * @return
     */
    public static String limit(String value, int limit, String end) {
        if (blank(value)) {
            return value;
        }
        return value.substring(0, limit) + end;
    }

    /**
     * Generate a random alpha-numeric string.
     * @return the random alpha-numeric string
     */
    public static String random() {
        int length = 16;
        return random(16);
    }

    /**
     * Generate a random alpha-numeric string.
     * @param length the length of the generated random string
     * @return the random alpha-numeric string
     */
    public static String random(int length) {
        String alphaNumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int n = alphaNumeric.length();
        StringBuffer result = new StringBuffer();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            result.append(alphaNumeric.charAt(r.nextInt(n)));
        }
        return result.toString();
    }

    /**
     * Reverses a string as per StringBuilder.reverse().
     * @param str the string to reverse, may be null
     * @return the reversed string, null if null string input
     */
    public static String reverse(String str) {
        if (blank(str)) {
            return str;
        }
        return new StringBuffer(str).reverse().toString();
    }

    public static String replaceLast(String search, String replace, String subject) {
        if (blank(subject) || blank(replace) || blank(search)) {
            return subject;
        }
        return reverse(reverse(subject).replaceFirst(search, replace));
    }
}
