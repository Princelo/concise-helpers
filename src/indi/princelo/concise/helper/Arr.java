package indi.princelo.concise.helper;

import java.util.Arrays;
import java.util.function.Predicate;

public class Arr {

    /**
     * Copies the given array and adds the given element at the end of the new array.
     *
     * @param arr  the array to copy and add the element to, may be null
     * @param element the object to add at the last index of the new array
     * @param <T> the type of object
     * @return A new array containing the existing elements plus the new element
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] append(T[] arr, T element) {
        if (empty(arr)) {
            return (T[]) new Object[] { element };
        }
        int length = arr.length;
        arr = Arrays.copyOf(arr, length + 1);
        arr[length] = element;
        return arr;
    }

    /**
     * Determine if a given array is empty
     *
     * @param arr the array to check
     * @param <T> the type of object
     * @return true if the array is null or empty
     */
    public static <T> boolean empty(T[] arr) {
        return null == arr || arr.length == 0;
    }

    /**
     * Filter the array by applying a Predicate to each element. If the
     * predicate returns true, keep the element
     *
     * @param arr the array to get the input from, may be null
     * @param predicate the predicate to use as a filter, may be null
     * @param <T> the type of object
     * @return the array filtered
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] arr, Predicate<T> predicate) {
        Object[] filtered = Coll.filter(Arrays.asList(arr), predicate).toArray(new Object[0]);
        return (T[]) filtered;
    }

    /**
     * Filter the array by applying a Predicate to each element. If the
     * predicate returns true, remove the element
     *
     * @param arr the array to get the input from, may be null
     * @param predicate the predicate to use as a filter, may be null
     * @param <T> the type of object
     * @return the array filtered
     */
    public static <T> T[] except(T[] arr, Predicate<T> predicate) {
        return filter(arr, predicate.negate());
    }

    /**
     * Copies the given array and adds the given element at the begin of the new array.
     *
     * @param arr  the array to copy and add the element to, may be null
     * @param element the object to add at the begin of the new array
     * @param <T> the type of object
     * @return A new array containing the existing elements plus the new element
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] prepend(T[] arr, T element) {
        if (empty(arr)) {
            return (T[]) new Object[] { element };
        }
        T[] ret = (T[]) new Object[arr.length+1];
        ret[0] = element;
        System.arraycopy(arr, 0, ret, 1, arr.length);
        return ret;
    }

}
