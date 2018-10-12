package indi.princelo.concise.helper;

import java.util.Collection;
import static indi.princelo.concise.helper.Coll.*;

public class Sql {

    public static StringBuffer in(Collection<String> values, Str col) {
        Collection<String> filtered = filter(values, Str::blank);
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

}
