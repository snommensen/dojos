/**
 * Problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=12778
 */
public class WolfDelaymaster {

    private static final String VALID = "VALID";
    private static final String INVALID = "INVALID";

    public String check(String str) {
        if (hasInvalidLetterCombinations(str)) return INVALID;


        for (String wolf : extractSingleWolfs(str))
            if (!hasValidOrder(wolf)) return INVALID;

        return VALID;
    }

    private boolean hasInvalidLetterCombinations(String str) {
        return str.contains("fo") || str.contains("fl");
    }

    private String[] extractSingleWolfs(String str) {
        String s = str.replaceAll("fw", "f#w");
        return s.split("#");
    }

    private boolean hasValidOrder(String wolf) {
        int w = wolf.indexOf('w');
        int o = wolf.indexOf('o');
        int l = wolf.indexOf('l');
        int f = wolf.indexOf('f');

        return w < o && o < l && l < f;
    }
}
