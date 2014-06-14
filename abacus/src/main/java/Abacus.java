public class Abacus {

    public String[] add(String[] original, int val) {
        int number = fromAbacus(original);
        int sum = number + val;
        return toAbacus(sum);
    }

    static int fromAbacus(String[] abacus) {
        String number = "";
        for (String s : abacus) {
            int idx = s.lastIndexOf('-');
            String n = s.substring(idx + 1);
            number += n.length();
        }
        return Integer.parseInt(number);
    }

    static String[] toAbacus(int number) {
        String n = "" + number;
        String[] abacus = new String[n.length()];
        int k = 0;
        for (char c : n.toCharArray()) {
            int i = Integer.parseInt("" + c);
            int r = 9 - i;
            String s = "";
            for (int j = 0; j < r; j++)
                s += "o";
            s += "---";
            for (int j = 0; j < i; j++)
                s += "o";
            abacus[k] = s;
            k++;
        }
        return abacus;
    }
}
