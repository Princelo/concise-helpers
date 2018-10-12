package indi.princelo.concise.helper;

import java.util.Arrays;
import java.util.Collection;

import static indi.princelo.concise.helper.Coll.empty;
import static indi.princelo.concise.helper.Coll.except;

public class Sql {

    /**
     * Return the sql in operation predication StringBuffer
     *
     * @param values the values of in operator
     * @param col    the column name
     * @return the sql predication StringBuffer, a safe predication if invalid values input
     */
    public static StringBuffer in(String[] values, String col) {
        return in(Arrays.asList(values), col);
    }

    /**
     * Return the sql in operation predication StringBuffer
     *
     * @param values the values of in operator
     * @param col    the column name
     * @return the sql predication StringBuffer, a safe predication if invalid values input
     */
    public static StringBuffer in(Collection<String> values, String col) {
        Collection<String> filtered = except(values, Str::blank);
        if (empty(filtered)) {
            return new StringBuffer(" (" + col + " in ('impossibleValue')) ");
        }
        StringBuffer predicate = new StringBuffer(" (" + col + " in (");
        String comma = "";
        int index = 0;
        for (String value : filtered) {
            if (++index > 500) {
                comma = "";
                index = 0;
                predicate.append(") or ").append(col).append(" in (");
            }
            predicate.append(comma).append("'").append(value).append("'");
            comma = ", ";
        }
        predicate.append(")) ");
        return predicate;
    }

    /**
     * Return the sql not-in operation predication StringBuffer
     *
     * @param values the values of not-in operator
     * @param col    the column name
     * @return the sql predication StringBuffer, a safe predication if invalid values input
     */
    public static StringBuffer notIn(String[] values, String col) {
        return notIn(Arrays.asList(values), col);
    }

    /**
     * Return the sql not-in operation predication StringBuffer
     *
     * @param values the values of not-in operator
     * @param col    the column name
     * @return the sql predication StringBuffer, a safe predication if invalid values input
     */
    public static StringBuffer notIn(Collection<String> values, String col) {
        Collection<String> filtered = except(values, Str::blank);
        if (empty(filtered)) {
            return new StringBuffer(" (" + col + " not in ('impossibleValue')) ");
        }
        StringBuffer predicate = new StringBuffer(" (" + col + " not in (");
        String comma = "";
        int index = 0;
        for (String value : filtered) {
            if (++index > 500) {
                comma = "";
                index = 0;
                predicate.append(") and ").append(col).append(" not in (");
            }
            predicate.append(comma).append("'").append(value).append("'");
            comma = ", ";
        }
        predicate.append(")) ");
        return predicate;
    }

}
