package by.eshevtsov.algorithms

import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    process()
}

private fun process() {
    val input = intArrayOf(3, 2, 6, 5, 0, 3)
    println("Input:\n${input.joinToString()}")

    val output: Int = maxProfit(input)
    println("Output:\n$output")
}

private fun maxProfit(prices: IntArray): Int {
    var savedProfit = 0
    var end = prices.size
    var i = 0
    do {
        var decreasing = true
        var maxI = i
        var minI = i
        var minBMI = i
        i++
        while (i < end) {
            if (prices[i] < prices[minI]) {
                minI = i
            } else {
                decreasing = false
            }
            if (prices[i] >= prices[maxI]) {
                maxI = i
                minBMI = minI
            }
            i++
        }
        if (decreasing || maxI == minI) {
            return savedProfit
        }
        if (maxI > minI) {
            val temp = prices[maxI] - prices[minI]
            if (temp > savedProfit) {
                savedProfit = temp
            }
            return savedProfit
        }
        val temp = prices[maxI] - prices[minBMI]
        if (temp > savedProfit) {
            savedProfit = temp
        }
        if (minI != end - 1) {
            i = minI + 1
            var maxAMI = i
            while (i < end) {
                if (prices[i] >= prices[maxAMI]) {
                    maxAMI = i
                }
                i++
            }
            val temp = prices[maxAMI] - prices[minI]
            if (temp > savedProfit) {
                savedProfit = temp
            }
        }
        i = maxI + 1
        end = minI
    } while (i < end)

    return savedProfit
}

private fun maxProfitKotlin(prices: IntArray): Int {
    var maxProfit = 0
    var minPrice = prices[0]
    for (price in prices) {
        if (price < minPrice) {
            minPrice = price
        } else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice
        }
    }
    return maxProfit
}