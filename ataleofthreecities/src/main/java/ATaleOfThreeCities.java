public class ATaleOfThreeCities {

    public static ATaleOfThreeCities make() {
        return new ATaleOfThreeCities();
    }

    public double connect(int[] ax, int[] ay,
                          int[] bx, int[] by,
                          int[] cx, int[] cy) {

        double ab, ac, bc;
        ab = ac = bc = Double.MAX_VALUE;

        for (int i = 0; i < ax.length; i++) {
            for (int j = 0; j < bx.length; j++) {
                double d = euclideanDistance(ax[i], ay[i], bx[j], by[j]);
                ab = Math.min(d, ab);
            }
        }

        for (int i = 0; i < ax.length; i++) {
            for (int j = 0; j < cx.length; j++) {
                double d = euclideanDistance(ax[i], ay[i], cx[j], cy[j]);
                ac = Math.min(d, ac);
            }
        }

        for (int i = 0; i < bx.length; i++) {
            for (int j = 0; j < cx.length; j++) {
                double d = euclideanDistance(bx[i], by[i], cx[j], cy[j]);
                bc = Math.min(bc, d);
            }
        }

        return ab + ac + bc - Math.max(Math.max(ab, ac), bc);
    }

    private double euclideanDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x1 - y1, 2) + Math.pow(x2 - y2, 2));
    }
}
