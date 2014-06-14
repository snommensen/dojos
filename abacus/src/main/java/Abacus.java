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
            abacus[i] = constructOneAbacusNumber(n);
        }
        return abacus;
    }

    static String constructOneAbacusNumber(int n) {
        String number = "";
        for (int i = 0; i < (9 - n); i++)
            number += "o";
        number += "---";
        for (int i = 0; i < n; i++)
            number += "o";
        return number;
    }
}

