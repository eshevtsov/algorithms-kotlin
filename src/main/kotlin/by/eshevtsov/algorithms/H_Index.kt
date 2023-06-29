package by.eshevtsov.algorithms

import kotlin.math.min


fun main(args: Array<String>) {
    process()
}

private fun process() {
    val input = intArrayOf(3, 0, 6, 1, 5) // 0, 1, 3, 5, 6
    println("Input:\n${input.joinToString()}")

    val output = hIndex(input)
    println("Output:\n$output")
}

private fun hIndex(citations: IntArray): Int {
    var h = citations.size
    citations.sort()
    for (c in citations) {
        if (c < h) h--
    }
    return h
}

private fun hIndexSort(citations: IntArray): Int {
    citations.sort()
    var i = citations.lastIndex
    var h = 0
    while (i >= 0 && citations[i] > h) {
        h++
        i--
    }
    return h
}

