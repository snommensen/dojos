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

    def "the correct minimal costs for two tunnels are calculated"() {
        expect:
        aTaleOfThreeCities.connect(
                ax as int[], ay as int[],
                bx as int[], by as int[],
                cx as int[], cy as int[]) == result

        where:
        ax                                | ay                                 | bx                                       | by                                       | cx                                       | cy                                        | result
        [0, 0, 0]                         | [0, 1, 2]                          | [2, 3]                                   | [1, 1]                                   | [1, 5]                                   | [3, 28]                                   | 3.414213562373095
        [-2, -1, 0, 1, 2]                 | [0, 0, 0, 0, 0]                    | [-2, -1, 0, 1, 2]                        | [1, 1, 1, 1, 1]                          | [-2, -1, 0, 1, 2]                        | [2, 2, 2, 2, 2]                           | 2.0
        [4, 5, 11, 21, 8, 10, 3, 9, 5, 6] | [12, 8, 9, 12, 2, 3, 5, 7, 10, 13] | [34, 35, 36, 41, 32, 39, 41, 37, 39, 50] | [51, 33, 41, 45, 48, 22, 33, 51, 41, 40] | [86, 75, 78, 81, 89, 77, 83, 88, 99, 77] | [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] | 50.323397776611024
    }
}
