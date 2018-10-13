package indi.princelo.concise.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;

public class Coll {

    /**
     * Filter the collection by applying a Predicate to each element. If the
     * predicate returns true, remove the element
     *
     * @param collection the collection to get the input from, may be null
     * @param predicate  the predicate to use as a filter, may be null
     * @param <T>        the type of object
     * @return the collection filtered
     */
    public static <T> Collection<T> except(Collection<T> collection, Predicate<T> predicate) {
        return filter(collection, predicate.negate());
    }

    /**
     * Filter the collection by applying a Predicate to each element. If the
     * predicate returns true, keep the element
     *
     * @param collection the collection to get the input from, may be null
     * @param predicate  the predicate to use as a filter, may be null
     * @param <T>        the type of object
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
     * Determine if a given collection is empty
     *
     * @param collection the collection to check
     * @return true if the collection is null or empty
     */
    public static boolean empty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    /**
     * Run a map over each of the items.
     *
     * @param items     the collection of items to process
     * @param processor the processor to process each item
     * @param <T>       the type of given object
     * @param <U>       the type of object processed
     * @return the collection with the items processed
     */
    public static <T, U> Collection<U> map(Collection<T> items, Function<T, U> processor) {
        Collection<U> processed = new ArrayList<>();
        for (T item : items) {
            processed.add(processor.apply(item));
        }
        return processed;
    }

}
