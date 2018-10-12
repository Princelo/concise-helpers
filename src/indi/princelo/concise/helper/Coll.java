package indi.princelo.concise.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Coll {

    /**
     * Determine if a given collection is empty
     *
     * @param collection the collection to check
     * @return true if the collection is null or empty
     */
    public static boolean empty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * Filter the collection by applying a Predicate to each element. If the
     * predicate returns true, keep the element
     *
     * @param collection the collection to get the input from, may be null
     * @param predicate the predicate to use as a filter, may be null
     * @param <T> the type of object
     * @return the collection filtered
     */
    public static <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate) {
        Collection<T> filtered = new ArrayList<>();
        if (empty(collection)) {
            return filtered;
        }
        for (T element : collection) {
            if (!predicate.test(element)) {
                continue;
            }
            filtered.add(element);
        }
        return filtered;
    }

    /**
     * Filter the collection by applying a Predicate to each element. If the
     * predicate returns true, remove the element
     *
     * @param collection the collection to get the input from, may be null
     * @param predicate the predicate to use as a filter, may be null
     * @param <T> the type of object
     * @return the collection filtered
     */
    public static <T> Collection<T> except(Collection<T> collection, Predicate<T> predicate) {
        return filter(collection, predicate.negate());
    }

}
