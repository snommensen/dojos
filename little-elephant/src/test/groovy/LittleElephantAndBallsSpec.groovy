import spock.lang.Specification
import spock.lang.Unroll

class LittleElephantAndBallsSpec extends Specification {

    LittleElephantAndBalls littleElephantAndBalls

    def setup() {
        littleElephantAndBalls = new LittleElephantAndBalls()
    }

    @Unroll
    def "calculate the maximum points that can be scored"() {
        expect:
        littleElephantAndBalls.getNumber(S) == points

        where:
        S                                                    | points
        "RGB"                                                | 3
        "RGGRBBB"                                            | 21
        "RRRGBRR"                                            | 16
        "RRRR"                                               | 5
        "GGRRRGR"                                            | 18
        "G"                                                  | 0
        "RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR" | 97
        "RRRRRRRRRRRRRRRRRRRRRRRRRGGGGGGGGGGGGGGGGGGGGGGGGG" | 144
        "RRRRRRRRRRRRRRRRGGGGGGGGGGGGGGGGBBBBBBBBBBBBBBBBBB" | 195
    }
}