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

    fun canBuy(amountOfMoney: Int, P: Int) = amountOfMoney >= P

    fun canExchange(chocolates: Int, K: Int) = chocolates % K == 0

    fun buy(amountOfMoney: Int, P: Int, chocolates: Int) = Pair(amountOfMoney - P, chocolates + 1)

    fun exchange(chocolates: Int) = chocolates + 1
}
