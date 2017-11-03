import java.util.*;
import java.util.stream.Stream;

/**
 * Problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=12778
 */
public class WolfDelaymaster {

    public String check(String str) {
        for (String wolf : extractSingleWolfs(str))
            if (!hasSameNumber(wolf) || !hasValidOrder(wolf))
                return "INVALID";

        return "VALID";
    }

    private String[] extractSingleWolfs(String str) {
        String s = str.replaceAll("fw", "f#w");
        return s.split("#");
    }

    private boolean hasSameNumber(String wolf) {
        String s = wolf
            .replaceAll("wo", "w#o")
            .replaceAll("ol", "o#l")
            .replaceAll("lf", "l#f");

        String[] split = s.split("#");

        return split.length == 4 && Stream.of(split)
            .mapToInt(String::length)
            .distinct()
            .count() == 1;
    }

    private boolean hasValidOrder(String wolf) {
        int wLast = wolf.lastIndexOf('w');
        int oFirst = wolf.indexOf('o');
        int oLast = wolf.lastIndexOf('o');
        int lFirst = wolf.indexOf('l');
        int lLast = wolf.lastIndexOf('l');
        int fFirst = wolf.indexOf('f');

        return (wLast < oFirst) &&
            (oFirst < lFirst && oLast < lFirst) &&
            (lFirst < fFirst && lLast < fFirst);
    }
}
