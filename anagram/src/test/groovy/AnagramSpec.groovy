import spock.lang.Specification
import spock.lang.Unroll

class AnagramSpec extends Specification {

    def anagram

    def setup() {
        anagram = new Anagram()
    }

    @Unroll
    def "explode given word listing all anagrams"() {
        expect:
        anagram.explode(S) - result == []

        where:
        S      | result
        ""     | []
        "bi"   | ["bi", "ib"]
        "bit"  | ["bti", "bit", "itb", "ibt", "tib", "tbi"]
        "abc"  | ["abc", "acb", "bac", "bca", "cab", "cba"]
        "abbc" | ["abbc", "abcb", "acbb", "babc", "bbac", "bbca", "bcab",
                "bcba", "bacb", "cabb", "cbab", "cbba"]
    }
}