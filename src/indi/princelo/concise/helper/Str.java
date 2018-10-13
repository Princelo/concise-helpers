package indi.princelo.concise.helper;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import static indi.princelo.concise.helper.Coll.empty;

public class Str {
    /**
     * Get the portion of a string before a given value.
     *
     * @param subject the string to get a substring from, may be nul
     * @param search  the string to search for, may be null
     * @return the substring before the first occurrence of the separator, null if null string input
     */
    public static String before(String subject, String search) {
        return blank(search) ? subject : subject.split(search)[0];
    }

    /**
     * Determine if a given string is blank
     *
     * @param str the string to check, may be null
     * @return true if the string is null, empty or whitespace only
     */
    public static boolean blank(String str) {
        return null == str || "".equals(str) || "".equals(str.trim());
    }

    /**
     * Return the remainder of a string after a given value.
     *
     * @param subject the string to get a substring from, may be null
     * @param search  the string to search for, may be null
     * @return the substring after the first occurrence of the separator, null if null string input
     */
    public static String after(String subject, String search) {
        if (blank(search)) {
            return subject;
        }
        String[] arr = subject.split(search, 2);
        return arr[arr.length - 1];
    }

    /**
     * Cap a string with a single instance of a given value.
     *
     * @param value the string.
     * @param cap   The suffix to append to the end of the string.
     * @return A new string if suffix was appended, the same string otherwise.
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
     * Begin a string with a single instance of a given value.
     *
     * @param value  the string.
     * @param prefix The prefix to prepend to the start of the string.
     * @return A new string if prefix was prepended, the same string otherwise.
     */
    public static String start(String value, String prefix) {
        if (blank(value)) {
            return prefix;
        }
        if (value.startsWith(prefix)) {
            return value;
        }
        return prefix + value;
    }

    /**
     * Limit the number of characters in a string.
     *
     * @param value the string to limit
     * @return limited string, null if null string input
     */
    public static String limit(String value) {
        int limit = 100;
        String end = "...";
        return limit(value, limit, end);
    }

    /**
     * Limit the number of characters in a string.
     *
     * @param value the string to limit
     * @param limit maximum length of the result main string
     * @param end   suffix of the limited result
     * @return limited string, null if null string input
     */
    public static String limit(String value, int limit, String end) {
        if (blank(value)) {
            return value;
        }
        return value.substring(0, limit) + end;
    }

    /**
     * Limit the number of characters in a string.
     *
     * @param value the string to limit
     * @param limit maximum length of the result main string
     * @return limited string, null if null string input
     */
    public static String limit(String value, int limit) {
        String end = "...";
        return limit(value, limit, end);
    }

    /**
     * Limit the number of characters in a string.
     *
     * @param value the string to limit
     * @param end   suffix of the limited result
     * @return limited string, null if null string input
     */
    public static String limit(String value, String end) {
        int limit = 100;
        return limit(value, limit, end);
    }

    /**
     * Generate a random alpha-numeric string.
     *
     * @return the random alpha-numeric string
     */
    public static String random() {
        return random(16);
    }

    /**
     * Generate a random alpha-numeric string.
     *
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
     * Replace the last occurrence of a given value in the string.
     *
     * @param search  the regular expression to which this string is to be matched
     * @param replace the string to be substituted
     * @param subject text to search and replace in, may be null
     * @return the text with the last replacement processed, null if null string input.
     */
    public static String replaceLast(String search, String replace, String subject) {
        if (blank(subject) || blank(replace) || blank(search)) {
            return subject;
        }
        return reverse(reverse(subject).replaceFirst(search, replace));
    }

    /**
     * Reverses a string as per StringBuilder.reverse().
     *
     * @param str the string to reverse, may be null
     * @return the reversed string, null if null string input
     */
    public static String reverse(String str) {
        if (blank(str)) {
            return str;
        }
        return new StringBuffer(str).reverse().toString();
    }

    /**
     * Joins the elements of the provided array into a single String containing the provided list of elements.
     *
     * @param arr       the values to join together, may be null
     * @param delimiter the separator to use
     * @return the joined string, null if empty array input
     */
    public static String join(String[] arr, String delimiter) {
        return join(Arrays.asList(arr), delimiter);
    }

    /**
     * Joins the elements of the provided array into a single String containing the provided list of elements.
     *
     * @param collection the values to join together, may be null
     * @param delimiter  the separator to use
     * @return the joined string, null if empty collection input
     */
    public static String join(Collection<String> collection, String delimiter) {
        if (empty(collection)) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        String delimiter_ = "";
        for (String element : collection) {
            result.append(delimiter_).append(element);
            delimiter_ = delimiter;
        }
        return result.toString();
    }
}
