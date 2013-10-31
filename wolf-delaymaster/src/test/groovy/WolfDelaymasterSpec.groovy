import spock.lang.Specification
import spock.lang.Unroll

class WolfDelaymasterSpec extends Specification {

    static final VALID = "VALID"
    static final INVALID = "INVALID"

    WolfDelaymaster wolfDelaymaster

    def setup() {
        wolfDelaymaster = new WolfDelaymaster()
    }

    def "return the tasks which the business man chooses to execute"() {
        expect:
        wolfDelaymaster.check(str) == result

        where:
        str    | result
        "wolf" | VALID
    }
}
