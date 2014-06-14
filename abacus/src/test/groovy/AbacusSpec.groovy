import spock.lang.Specification

class AbacusSpec extends Specification {

    def abacus

    def setup() { abacus = new Abacus() }

    def "the correct abacus representation is calculated"() {
        expect:
        abacus.add(original as String[], val) == result

        where:
        original         | val | result
        ["ooo---oooooo",
         "---ooooooooo",
         "---ooooooooo",
         "---ooooooooo",
         "oo---ooooooo",
         "---ooooooooo"] | 5   | ["ooo---oooooo",
                                  "---ooooooooo",
                                  "---ooooooooo",
                                  "---ooooooooo",
                                  "o---oooooooo",
                                  "ooooo---oooo"]
    }

}
