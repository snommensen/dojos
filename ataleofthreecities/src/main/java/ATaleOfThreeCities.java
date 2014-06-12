public class ATaleOfThreeCities {

    public double connect(int[] ax, int[] ay,
                          int[] bx, int[] by,
                          int[] cx, int[] cy) {
        double ab = minDistanceBetweenTwoCities(ax, ay, bx, by);
        double ac = minDistanceBetweenTwoCities(ax, ay, cx, cy);
        double bc = minDistanceBetweenTwoCities(bx, by, cx, cy);

        return addedCostsOfTwoTunnels(ab, ac, bc);
    }

    private double minDistanceBetweenTwoCities(int[] ax, int[] ay,
                                               int[] bx, int[] by) {
        double result = Double.MAX_VALUE;
        for (int i = 0; i < ax.length; i++) {
            for (int j = 0; j < bx.length; j++) {
                double distance = euclideanDistance(ax[i], ay[i], bx[j], by[j]);
                result = Math.min(result, distance);
            }
        }
        return result;
    }

    private double euclideanDistance(int ax, int ay, int bx, int by) {
        return Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2));
    }

    private double addedCostsOfTwoTunnels(double ab, double ac, double bc) {
        return ab + ac + bc - mostExpensiveTunnelCosts(ab, ac, bc);
    }

    private double mostExpensiveTunnelCosts(double ab, double ac, double bc) {
        return Math.max(Math.max(ab, ac), bc);
    }
}
