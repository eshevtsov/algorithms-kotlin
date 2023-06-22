package by.eshevtsov.algorithms

import java.util.HashMap

fun main(args: Array<String>) {
    invoke()
}

private fun invoke() {
    val input = "as"
    println("Input:\n$input")

    val output = lengthOfLastWord(input)

    println("Output:\n$output")
}

private fun lengthOfLastWord(s: String): Int {
    var wordFound = false
    var wordEnd = -1
    var i = s.length - 1
    while (i >= 0) {
        if (s[i] != ' ' && !wordFound) {
            wordEnd = i
            wordFound = true
        } else if (s[i] == ' ' && wordFound) {
            return wordEnd - i
        }
        i--
    }

    return if (wordFound) {
        wordEnd + 1
    } else {
        0
    }
}

//I can be placed before V (5) and X (10) to make 4 and 9.
//X can be placed before L (50) and C (100) to make 40 and 90.
//C can be placed before D (500) and M (1000) to make 400 and 900.