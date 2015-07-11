import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=12778
 */
public class WolfDelaymaster {

  private static final String VALID = "VALID";
  private static final String INVALID = "INVALID";

  public String check(String str) {
    for (String wolf : extractSingleWolfs(str))
      if (!hasSameNumber(wolf) || !hasValidOrder(wolf))
        return INVALID;

    return VALID;
  }

  private String[] extractSingleWolfs(String str) {
    String s = str.replaceAll("fw", "f#w");
    return s.split("#");
  }

  private boolean hasSameNumber(String wolf) {
    List<Character> characters = new ArrayList<>(wolf.length());
    for (Character c : wolf.toCharArray()) characters.add(c);
    int wCount = Collections.frequency(characters, 'w');
    int oCount = Collections.frequency(characters, 'o');
    int lCount = Collections.frequency(characters, 'l');
    int fCount = Collections.frequency(characters, 'f');
    return wCount == oCount && oCount == lCount && lCount == fCount;
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
