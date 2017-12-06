package ellys_chocolates

import org.junit.Test
import kotlin.test.assertEquals

/*
 * https://community.topcoder.com/stat?c=problem_statement&pm=14681
 */
class EllysChocolatesTest {

    val ellysChocolates = EllysChocolates()

    @Test
    fun `Elly has 15 euros, one is sold for 1, 3 can be exchanged for a new one, she can get 22`() {
        assertEquals(22, ellysChocolates.getCount(1, 3, 15))
    }

    @Test
    fun `Elly has 823172 euros, one is sold for 666, 13 can be exchanged for a new one, she can get 1337`() {
        assertEquals(1337, ellysChocolates.getCount(666, 13, 823172))
    }

    @Test
    fun `Elly has 444 euros, one is sold for 666, 222 can be exchanged for a new one, she can get 0`() {
        assertEquals(0, ellysChocolates.getCount(666, 222, 444))
    }

    @Test
    fun `Elly has 1337 euros, one is sold for 41, 4 can be exchanged for a new one, she can get 42`() {
        assertEquals(42, ellysChocolates.getCount(41, 4, 1337))
    }
}
