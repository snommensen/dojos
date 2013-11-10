class Anagram {

    List result

    def explode(String S) {
        result = []
        explode(S, 0, S.length() - 1)
        result
    }

    def explode(String S, int k, int n) {
        if (k == n) result.add(S)
        else {
            for (int i in k..n) {
                S = swap(S, i, k)
                explode(S, k + 1, n)
                S = swap(S, i, k)
            }
        }
    }

    static swap(String S, int i, int j) {
        final C = S.toCharArray()

        final tmp = C[i]
        C[i] = C[j]
        C[j] = tmp

        C.toString()
    }
}


