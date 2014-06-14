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
        String s = "" + number;
        String[] abacus = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int n = Integer.parseInt("" + s.charAt(i));
            int r = 9 - n;
            abacus[i] = constructOneAbacusNumber(r, n);
        }
        return abacus;
    }

    static String constructOneAbacusNumber(int r, int n) {
        String number = "";
        for (int j = 0; j < r; j++)
            number += "o";
        number += "---";
        for (int j = 0; j < n; j++)
            number += "o";
        return number;
    }
}

