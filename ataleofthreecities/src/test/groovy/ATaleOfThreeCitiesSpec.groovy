import spock.lang.Specification

/**
 * Top Coder problem statement:
 * http://community.topcoder.com/stat?c=problem_statement&pm=3543
 */
class ATaleOfThreeCitiesSpec extends Specification {

    def aTaleOfThreeCities

    def setup() {
        aTaleOfThreeCities = ATaleOfThreeCities.make()
    }

    def "the correct minimal costs for a tunnel are calculated"() {
        expect:
        aTaleOfThreeCities.connect(
                ax as int[], ay as int[],
                bx as int[], by as int[],
                cx as int[], cy as int[]) == result

        where:
        ax        | ay        | bx     | by     | cx     | cy      | result
        [0, 0, 0] | [0, 1, 2] | [2, 3] | [1, 1] | [1, 5] | [3, 28] | 3.414213562373095
    }
}
