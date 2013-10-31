import spock.lang.Specification

class WolfDelaymasterSpec extends Specification {

    static final VALID = "VALID"
    static final INVALID = "INVALID"

    WolfDelaymaster wolfDelaymaster

    def setup() {
        wolfDelaymaster = new WolfDelaymaster()
    }

    def "check whether the string is valid"() {
        expect:
        wolfDelaymaster.check(str) == result

        where:
        str                                        | result
        "wolf"                                     | VALID
        "wolfwwoollffwwwooolllfffwwwwoooollllffff" | VALID
        "wwolfolf"                                 | INVALID
        "flowolf"                                  | INVALID
    }
}
