package by.eshevtsov.algorithms

import java.lang.StringBuilder

fun main(args: Array<String>) {
    invoke()
}

private fun invoke() {
    val input = arrayOf("flower", "flow", "flight")
    println("Input:\n${input.joinToString()}")

    val output = longestCommonPrefix(input)

    println("Output:\n$output")
}

private fun longestCommonPrefix(strs: Array<String>): String {
    var result = ""
    if (strs.isEmpty()) return result

    var prefixLength = 0
    val firstWord = strs[0]

    if (firstWord.isEmpty()) return result
    var firstLetter = firstWord[0]
    var minLength = firstWord.length
    var i = 1
    while (i < strs.size) {
        val next = strs[i]
        if (next.isEmpty() || firstLetter != next[0]) {
            return result
        } else if (next.length < minLength) {
            minLength = next.length
        }
        i++
    }
    result += firstLetter

    i = 1
    while (i < minLength) {
        val letter = firstWord[i]
        var j = 1
        while (j < strs.size) {
            if (strs[j][i] != letter) {
                return result
            }
            j++
        }
        result+=letter
        prefixLength++
        i++
    }
    return result
}