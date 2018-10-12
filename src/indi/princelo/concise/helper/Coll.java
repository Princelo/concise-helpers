package indi.princelo.concise.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Coll {

    public static boolean empty(Collection<?> collection) {
        return null == collection || collection.isEmpty();
    }

    public static <T> Collection<T> filter(Collection<T> collection, Predicate<T> predicate) {
        Collection<T> filtered = new ArrayList<T>();
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

}
