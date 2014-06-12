public class ATaleOfThreeCities {

    public static ATaleOfThreeCities make() {
        return new ATaleOfThreeCities();
    }

    public double connect(int[] ax, int[] ay,
                          int[] bx, int[] by,
                          int[] cx, int[] cy) {
        double ab = minDistanceBetweenTwoCities(ax, ay, bx, by);
        double ac = minDistanceBetweenTwoCities(ax, ay, cx, cy);
        double bc = minDistanceBetweenTwoCities(bx, by, cx, cy);

        return addedCostsOfTwoTunnels(ab, ac, bc);
    }

    private double minDistanceBetweenTwoCities(int[] firstX, int[] firstY,
                                               int[] secondX, int[] secondY) {
        double result = Double.MAX_VALUE;
        for (int i = 0; i < firstX.length; i++) {
            for (int j = 0; j < secondX.length; j++) {
                double distance = euclideanDistance(
                        firstX[i], firstY[i],
                        secondX[j], secondY[j]
                );
                result = Math.min(result, distance);
            }
        }
        return result;
    }

    private double euclideanDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x1 - y1, 2) + Math.pow(x2 - y2, 2));
    }

    private double addedCostsOfTwoTunnels(double ab, double ac, double bc) {
        return ab + ac + bc - Math.max(Math.max(ab, ac), bc);
    }
}
