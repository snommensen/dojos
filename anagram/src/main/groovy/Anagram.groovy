class Anagram {

    static explode(String S) {
        if (S.length() == 0) return []

        final result = []

        for (int k in 0..S.length() - 1) {
            final prefix = S[k]
            final R = without(S, k)
            result.addAll(shuffle(R, prefix))
        }

        result
    }

    static without(String S, int k) {
        final end = S.length() - 1

        if (k == 0)
            S[1..end]
        else if (k == end)
            S[0..end - 1]
        else
            S[0..k - 1] + S[k + 1..end]
    }

    static shuffle(String R, String prefix) {
        final result = [] as Set

        for (int i in R.length() - 1)
            for (int j in 0..R.length() - 1)
                result.add(prefix + swap(R, i, j))

        result
    }

    static swap(String S, int i, int j) {
        final C = S.toCharArray()

        final tmp = C[i]
        C[i] = C[j]
        C[j] = tmp

        C.toString()
    }
}


