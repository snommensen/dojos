import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=2923&rd=5854
 */
public class TallPeople {

    public int[] getPeople(String[] people) {
        return new int[]{
            tallestOfTheShortest(people),
            shortestOfTheTallest(people)
        };
    }

    int tallestOfTheShortest(String[] people) {
        HashSet<Integer> shortestPerRow = new HashSet<>();
        for (String row : people) {
            LinkedList<Integer> heights = parseRow(row);
            shortestPerRow.add(Collections.min(heights));
        }
        return Collections.max(shortestPerRow);
    }

    int shortestOfTheTallest(String[] people) {
        HashSet<Integer> tallestPerColumn = new HashSet<>();
        for (HashSet<Integer> column : extractColumns(people)) {
            tallestPerColumn.add(Collections.max(column));
        }
        return Collections.min(tallestPerColumn);
    }

    private HashSet<Integer>[] extractColumns(String[] people) {
        final int noOfColumns = people[0].split(" ").length;
        HashSet<Integer>[] columns = new HashSet[noOfColumns];
        for (String row : people) {
            LinkedList<Integer> heights = parseRow(row);
            for (int i = 0; i < noOfColumns; i++) {
                if (columns[i] == null) columns[i] = new HashSet<>();
                columns[i].add(heights.get(i));
            }
        }
        return columns;
    }

    private LinkedList<Integer> parseRow(String row) {
        LinkedList<Integer> heightsAsIntegers = new LinkedList<>();
        for (String height : row.split(" ")) {
            heightsAsIntegers.add(Integer.valueOf(height));
        }
        return heightsAsIntegers;
    }
}

