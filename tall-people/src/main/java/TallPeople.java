import java.util.*;
import java.util.stream.IntStream;

/**
 * Problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=2923&rd=5854
 */
public class TallPeople {

    public int[] getPeople(String[] people) {
        RowsAndCols rowsAndCols = parse(people);
        return new int[]{
            tallestOfTheShortest(rowsAndCols.getRows()),
            shortestOfTheTallest(rowsAndCols.getCols())
        };
    }

    private int tallestOfTheShortest(IntStream[] rows) {
        IntStream.Builder builder = IntStream.builder();
        Arrays.stream(rows)
            .forEach(row -> row
                .min()
                .ifPresent(builder));
        IntStream shortestPerRow = builder.build();
        return shortestPerRow
            .max()
            .orElseThrow(RuntimeException::new);
    }

    private int shortestOfTheTallest(IntStream[] cols) {
        IntStream.Builder builder = IntStream.builder();
        Arrays.stream(cols)
            .forEach(col -> col
                .max()
                .ifPresent(builder));
        IntStream tallestPerColumn = builder.build();
        return tallestPerColumn
            .min()
            .orElseThrow(RuntimeException::new);
    }

    private RowsAndCols parse(String[] people) {
        final int noOfRows = people.length;
        final int noOfCols = people[0].split(" ").length;

        int[][] rows = new int[noOfRows][noOfCols];
        IntStream.range(0, noOfRows)
            .forEach(i -> rows[i] = parseRow(people[i]).toArray());

        int[][] cols = new int[noOfCols][noOfRows];
        IntStream.range(0, noOfCols)
            .forEach(j -> IntStream.range(0, noOfRows)
                .forEach(k -> cols[j][k] = rows[k][j]));

        return new RowsAndCols(rows, cols);
    }

    private IntStream parseRow(String row) {
        return Arrays.stream(row.split(" "))
            .mapToInt(Integer::valueOf);
    }

    private static class RowsAndCols {
        private int[][] rows;
        private int[][] cols;

        RowsAndCols(int[][] rows, int[][] cols) {
            this.rows = rows;
            this.cols = cols;
        }

        IntStream[] getRows() {
            return getIntStreams(rows);
        }

        IntStream[] getCols() {
            return getIntStreams(cols);
        }

        private IntStream[] getIntStreams(int[][] ints) {
            IntStream[] result = new IntStream[ints.length];
            IntStream.range(0, ints.length)
                .forEach(i -> result[i] = Arrays.stream(ints[i]));
            return result;
        }
    }
}
