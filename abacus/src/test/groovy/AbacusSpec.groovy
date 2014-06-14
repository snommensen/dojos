import spock.lang.Specification

class AbacusSpec extends Specification {

    def abacus

    def setup() { abacus = new Abacus() }

    def "the correct abacus representation is calculated"() {
        expect:
        abacus.add(original as String[], val) == result

        where:
        original         | val    | result
        ["ooo---oooooo",
         "---ooooooooo",
         "---ooooooooo",
         "---ooooooooo",
         "oo---ooooooo",
         "---ooooooooo"] | 5      | ["ooo---oooooo",
                                     "---ooooooooo",
                                     "---ooooooooo",
                                     "---ooooooooo",
                                     "o---oooooooo",
                                     "ooooo---oooo"]
        ["ooo---oooooo",
         "---ooooooooo",
         "---ooooooooo",
         "---ooooooooo",
         "oo---ooooooo",
         "---ooooooooo"] | 21     | ["oo---ooooooo",
                                     "ooooooooo---",
                                     "ooooooooo---",
                                     "ooooooooo---",
                                     "ooooooooo---",
                                     "ooooooooo---"]
        ["ooooooooo---",
         "---ooooooooo",
         "ooooooooo---",
         "---ooooooooo",
         "oo---ooooooo",
         "---ooooooooo"] | 100000 | ["oooooooo---o",
                                     "---ooooooooo",
                                     "ooooooooo---",
                                     "---ooooooooo",
                                     "oo---ooooooo",
                                     "---ooooooooo"]
        ["o---oooooooo",
         "---ooooooooo",
         "---ooooooooo",
         "---ooooooooo",
         "---ooooooooo",
         "---ooooooooo"] | 1      | ["---ooooooooo",
                                     "ooooooooo---",
                                     "ooooooooo---",
                                     "ooooooooo---",
                                     "ooooooooo---",
                                     "ooooooooo---"]
    }

    def "an abacus string is correctly parsed"() {
        expect:
        Abacus.fromAbacus(a as String[]) == number

        where:
        a                | number
        ["ooo---oooooo",
         "---ooooooooo",
         "---ooooooooo",
         "---ooooooooo",
         "oo---ooooooo",
         "---ooooooooo"] | 699979
        ["ooo---oooooo",
         "---ooooooooo",
         "---ooooooooo",
         "---ooooooooo",
         "o---oooooooo",
         "ooooo---oooo"] | 699984
    }

    def "an abacus representation is correctly constructed from an integer"() {
        expect:
        Abacus.toAbacus(number) == a

        where:
        number | a
        699979 | ["ooo---oooooo",
                  "---ooooooooo",
                  "---ooooooooo",
                  "---ooooooooo",
                  "oo---ooooooo",
                  "---ooooooooo"]
        699984 | ["ooo---oooooo",
                  "---ooooooooo",
                  "---ooooooooo",
                  "---ooooooooo",
                  "o---oooooooo",
                  "ooooo---oooo"]
    }

}

