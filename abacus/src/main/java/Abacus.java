public class Abacus {

    static int fromAbacus(String[] abacus) {
        StringBuilder number = new StringBuilder();
        for (String s : abacus) {
            int idx = s.lastIndexOf('-');
            String n = s.substring(idx + 1);
            number.append(n.length());
        }
        return Integer.parseInt(number.toString());
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
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < (9 - n); i++)
            number.append("o");
        number.append("---");
        for (int i = 0; i < n; i++)
            number.append("o");
        return number.toString();
    }

    public String[] add(String[] original, int val) {
        int number = fromAbacus(original);
        int sum = number + val;
        return toAbacus(sum);
    }
}

