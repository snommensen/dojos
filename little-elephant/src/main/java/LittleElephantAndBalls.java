import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=12758&rd=15704
 */
public class LittleElephantAndBalls {

    public int getNumber(String S) {
        int points = 0;
        ArrayList<Character> colors = new ArrayList<>(S.length());

        for (char c : S.toCharArray()) {
            if (colors.isEmpty()) {
                colors.add(c);
            } else {
                Map.Entry<Integer, Long> indexWithPoints =
                    findMaxEntry(performBruteForceAnalysis(colors));
                points += indexWithPoints.getValue();
                colors.add(indexWithPoints.getKey(), c);
            }
        }

        return points;
    }

    HashMap<Integer, Long> performBruteForceAnalysis(List<Character> currentList) {
        HashMap<Integer, Long> indexToPointsMap = new HashMap<>();

        for (int i = 0; i < currentList.size(); i++) {
            long points = 0;
            points += numberOfDifferentColors(currentList.subList(0, i + 1));
            if (i + 1 <= currentList.size() - 1) {
                points += numberOfDifferentColors(
                    currentList.subList(i + 1, currentList.size())
                );
            }
            indexToPointsMap.put(i + 1, points);
        }

        return indexToPointsMap;
    }

    Map.Entry<Integer, Long> findMaxEntry(
        HashMap<Integer, Long> indexToPointsMap) {
        return indexToPointsMap.entrySet().stream()
            .max(Comparator.comparingLong(Map.Entry::getValue))
            .orElseThrow(RuntimeException::new);
    }

    long numberOfDifferentColors(List<Character> colorList) {
        return colorList.stream()
            .distinct()
            .count();
    }
}

