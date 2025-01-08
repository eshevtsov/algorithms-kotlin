package by.eshevtsov.algorithms

import kotlin.math.abs

fun main(args: Array<String>) {
    invoke()
}

private fun invoke() {
    val input = "A man, a plan, a canal: Panama"
    // "race a car"
    // " "
    // "0P"
    println("Input:\n$input")

    val output = isPalindrome(input)

    println("Output:\n$output")
}

private fun isPalindrome(s: String): Boolean {
    val chars = s
    var start = 0
    var end = s.length - 1
    while (start < end) {
        while ((!isValid(chars[start])) && start < end) start++
        while ((!isValid(chars[end])) && start < end) end--
        if (isLetter(chars[start]) && !letterSame(chars[start], chars[end])) return false
        if (isDigit(chars[start]) && chars[start] != chars[end]) return false
        start++
        end--
    }
    return true
}

private fun isValid(c: Char): Boolean =
    (c >= 'a' && c <= 'z') || (c >= 'A'&& c <= 'Z') || (c >= '0'&& c <= '9')

private fun isLetter(c: Char): Boolean =
    (c >= 'a' && c <= 'z') || (c >= 'A'&& c <= 'Z')

private fun isDigit(c: Char): Boolean =
    (c >= '0'&& c <= '9')

private fun letterSame(c1: Char, c2: Char): Boolean =
    c1 == c2 || abs(c1 - c2) == 32