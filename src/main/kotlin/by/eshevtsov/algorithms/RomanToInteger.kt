package by.eshevtsov.algorithms

import java.util.HashMap

fun main(args: Array<String>) {
    invoke()
}

private fun invoke() {
    val input = "MCMXCIV"
    println("Input:\n$input")

    val output = romanToInt(input)

    println("Output:\n$output")
}

private fun romanToInt(s: String): Int {
    var i = 0
    var result = 0
    while (i < s.length - 1) {
        val current = s[i]
        val next = s[i + 1]
        if (
            (current == 'I') && (next == 'V' || next == 'X') ||
            (current == 'X') && (next == 'L' || next == 'C') ||
            (current == 'C') && (next == 'D' || next == 'M')
        ) {
            result -= map(current)
            result += map(next)
            i++
        } else {
            result += map(current)
        }
        i++
    }
    if (i < s.length) {
        result += map(s[i])
    }
    return result
}

private fun map(c: Char) =
    when (c) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }

//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.