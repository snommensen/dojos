import com.google.common.base.Predicates;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=12778
 */
public class WolfDelaymaster {

    private static final String VALID = "VALID";
    private static final String INVALID = "INVALID";

    public String check(String str) {
        for (String wolf : extractSingleWolfs(str))
            if (!containsAllWolfLetters(wolf) || !hasValidOrder(wolf))
                return INVALID;

        return VALID;
    }

    private String[] extractSingleWolfs(String str) {
        String s = str.replaceAll("fw", "f#w");
        return s.split("#");
    }

    private boolean containsAllWolfLetters(String wolf) {
        return !(wolf.indexOf('w') < 0 ||
                wolf.indexOf('o') < 0 ||
                wolf.indexOf('l') < 0 ||
                wolf.indexOf('f') < 0);
    }

    private boolean hasValidOrder(String wolf) {
        int wFirst = wolf.indexOf('w');
        int wLast = wolf.lastIndexOf('w');

        int oFirst = wolf.indexOf('o');
        int oLast = wolf.lastIndexOf('o');

        int lFirst = wolf.indexOf('l');
        int lLast = wolf.lastIndexOf('l');

        int f = wolf.indexOf('f');

        return (wFirst < oFirst && wLast < oFirst) &&
                (oFirst < lFirst && oLast < lFirst) &&
                (lFirst < f && lLast < f);
    }
}
