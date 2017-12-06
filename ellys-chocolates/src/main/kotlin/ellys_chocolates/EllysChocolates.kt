package ellys_chocolates

class EllysChocolates {

    fun getCount(P: Int, K: Int, N: Int): Int {
        var chocolates = 0
        var amountOfMoney = N

        while (canBuy(amountOfMoney, P)) {
            val buyResult = buy(amountOfMoney, P, chocolates)
            amountOfMoney = buyResult.first
            chocolates = buyResult.second

            if (canExchange(chocolates, K)) {
                chocolates = exchange(chocolates)
            }
        }

        return chocolates
    }

    private fun canBuy(amountOfMoney: Int, P: Int): Boolean = amountOfMoney >= P

    private fun canExchange(chocolates: Int, K: Int): Boolean = chocolates % K == 0

    private fun buy(amountOfMoney: Int, P: Int, chocolates: Int): Pair<Int, Int> {
        return Pair(amountOfMoney - P, chocolates + 1)
    }

    private fun exchange(chocolates: Int): Int {
        return chocolates + 1
    }
}
