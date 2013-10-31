import spock.lang.Specification
import spock.lang.Unroll

class WolfDelaymasterSpec extends Specification {

    static final VALID = "VALID"
    static final INVALID = "INVALID"

    WolfDelaymaster wolfDelaymaster

    def setup() {
        wolfDelaymaster = new WolfDelaymaster()
    }

    @Unroll
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
