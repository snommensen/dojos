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
        result - anagram.explode(S) == []

        where:
        S      | result
        "bi"   | ["bi", "ib"]
        "bit"  | ["bti", "bit", "itb", "ibt", "tib", "tbi"]
        "abc"  | ["abc", "acb", "bac", "bca", "cab", "cba"]
        "abbc" | ["abbc", "abcb", "acbb", "babc", "bbac", "bbca", "bcab",
                "bcba", "bacb", "cabb", "cbab", "cbba"]
        "abcd" | ["adcb", "abdc", "abcd", "acdb", "acbd",
                "bdca", "badc","bacd", "bdac", "bcda", "bcad",
                "cdba", "cadb", "cabd", "cdab", "cbad", "cbda",
                "dcba", "dacb", "dabc", "dcab", "dbac"]
    }
}