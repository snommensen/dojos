import java.util.stream.Stream;

/**
 * Problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=12778
 */
public class WolfDelaymaster {

    public String check(String str) {
        for (String wolf : extractSingleWolfs(str))
            if (!isValid(wolf))
                return "INVALID";

        return "VALID";
    }

    private String[] extractSingleWolfs(String str) {
        String s = str.replaceAll("fw", "f#w");
        return s.split("#");
    }

    private boolean isValid(String wolf) {
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
}
