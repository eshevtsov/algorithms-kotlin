package by.eshevtsov.algorithms

fun main(args: Array<String>) {
    process()
}

private fun process() {
    val input = intArrayOf(7, 1, 5, 3, 6, 4)
    println("Input:\n${input.joinToString()}")

    val output: Int = maxProfitKotlin(input)
    println("Output:\n$output")
}

private fun maxProfitKotlin(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = Int.MAX_VALUE
    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else {
            val diff = price - minPrice
            if (diff > 0) {
                maxProfit += diff
                minPrice = price
            }
        }
    }
    return maxProfit
}