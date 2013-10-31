import java.util.*;

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
                Map.Entry<Integer, Integer> indexWithPoints =
                        findMaxEntry(performBruteForceAnalysis(colors));
                points += indexWithPoints.getValue();
                colors.add(indexWithPoints.getKey(), c);
            }
        }

        return points;
    }

    HashMap<Integer, Integer> performBruteForceAnalysis(List<Character> currentList) {
        HashMap<Integer, Integer> indexToPointsMap = new HashMap<>();

        for (int i = 0; i < currentList.size(); i++) {
            int points = 0;
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

    Map.Entry<Integer, Integer> findMaxEntry(
            HashMap<Integer, Integer> indexToPointsMap) {
        Map.Entry<Integer, Integer> maxEntry = null;

        for (Map.Entry<Integer, Integer> entry : indexToPointsMap.entrySet()) {
            if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        return maxEntry;
    }

    int numberOfDifferentColors(List<Character> colorList) {
        if (colorList.size() <= 1) {
            return colorList.size();
        }

        HashSet<Character> colorSet = new HashSet<>();
        colorSet.addAll(colorList);

        return colorSet.size();
    }
}

