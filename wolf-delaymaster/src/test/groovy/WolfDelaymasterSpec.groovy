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
        str                                                | result
        "wolf"                                             | VALID
        "wolfwwoollffwwwooolllfffwwwwoooollllffff"         | VALID
        "wwwwwwwwwwwwoooooooooooollllllllllllffffffffffff" | VALID
        "wwwwoooollllffffwwwwwwwooooooolllllllfffffff"     | VALID
        "wwwwwwwwwwoooooooooollllllllllffffffffff"         | VALID
        "wwolfolf"                                         | INVALID
        "flowolf"                                          | INVALID
        "o"                                                | INVALID
        "fo"                                               | INVALID
        "lfw"                                              | INVALID
        "lllwl"                                            | INVALID
        "ofwff"                                            | INVALID
        "fwwloo"                                           | INVALID
        "llwolow"                                          | INVALID
        "flffwwff"                                         | INVALID
        "lllfoffff"                                        | INVALID
        "ffwffwwoow"                                       | INVALID
        "ffwffwwoow"                                       | INVALID
        "wflolwfolwo"                                      | INVALID
        "wlwwlfolflow"                                     | INVALID
        "loofwwwfooolffwlwoowwwwwfoofwowwollffowoo"        | INVALID
        "oofoolllowwlfllofwofwfololllflflfoollwwflo"       | INVALID
    }
}
