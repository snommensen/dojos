import spock.lang.Specification
import spock.lang.Unroll

class BusinessTasksSpec extends Specification {

    BusinessTasks businessTasks

    def setup() {
        businessTasks = new BusinessTasks()
    }

    @Unroll
    def "return the tasks which the business man chooses to execute"() {
        expect:
        businessTasks.getTask(list as String[], n) == result

        where:
        list                                                   | n       | result
        ["a", "b", "c", "d"]                                   | 2       | "a"
        ["a", "b", "c", "d", "e"]                              | 3       | "d"
        ["alpha", "beta", "gamma", "delta", "epsilon"]         | 1       | "epsilon"
        ["a", "b"]                                             | 1000    | "a"
        ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
         "u", "v", "w", "x", "y", "z"]                         | 17      | "n"
        ["zlqamum", "yjsrpybmq", "tjllfea", "fxjqzznvg", "nvhekxr", "am", "skmazcey", "piklp",
         "olcqvhg", "dnpo", "bhcfc", "y", "h", "fj", "bjeoaxglt", "oafduixsz", "kmtbaxu",
         "qgcxjbfx", "my", "mlhy", "bt", "bo", "q"]            | 9000000 | "fxjqzznvg"
        ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "w",
         "v", "x", "y", "aa", "bb", "cc", "dd", "ee", "ff", "gg", "hh", "ii", "jj", "kk", "ll", "mm", "nn", "oo",
         "pp", "qq", "rr", "ss", "tt", "uu", "ww", "vv", "xx"] | 9999993 | "gg"

    }
}
