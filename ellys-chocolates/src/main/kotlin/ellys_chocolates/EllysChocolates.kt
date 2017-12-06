package ellys_chocolates

class EllysChocolates {

    fun getCount(P: Int, K: Int, N: Int): Int {
        var chocolates = 0
        var amountOfMoney = N
        var exchanges = 1

        while (canBuy(amountOfMoney, P)) {
            val buyResult = buy(amountOfMoney, P, chocolates)
            amountOfMoney = buyResult.first
            chocolates = buyResult.second

            if (canExchange(chocolates, exchanges, K)) {
                val exchangeResult = exchange(chocolates, exchanges)
                chocolates = exchangeResult.first
                exchanges = exchangeResult.second
            }
        }

        return chocolates
    }

    private fun canBuy(amountOfMoney: Int, P: Int): Boolean = amountOfMoney >= P

    private fun canExchange(chocolates: Int, exchanges: Int, K: Int): Boolean = chocolates % K == 0

    private fun exchange(chocolates: Int, exchanges: Int): Pair<Int, Int> {
        var chocolates1 = chocolates
        var exchanges1 = exchanges
        chocolates1 += 1
        exchanges1 += 1
        return Pair(chocolates1, exchanges1)
    }

    private fun buy(amountOfMoney: Int, price: Int, chocolates: Int): Pair<Int, Int> {
        var amountOfMoney1 = amountOfMoney
        var chocolates1 = chocolates
        amountOfMoney1 -= price
        chocolates1 += 1
        return Pair(amountOfMoney1, chocolates1)
    }
}
