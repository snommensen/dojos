import spock.lang.Specification
import spock.lang.Unroll

class LittleElephantAndBallsSpec extends Specification {

    LittleElephantAndBalls littleElephantAndBalls

    def setup() {
        littleElephantAndBalls = new LittleElephantAndBalls()
    }

    @Unroll
    def "test"() {
        expect:
        littleElephantAndBalls.getNumber(s) == result

        where:
        s         | result
        "RGB"     | 3
        "RGGRBBB" | 21
        "RRRGBRR" | 16
        "RRRR"    | 5
        "GGRRRGR" | 18
        "G"       | 0
    }
}