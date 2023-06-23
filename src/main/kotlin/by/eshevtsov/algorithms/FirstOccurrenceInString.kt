package by.eshevtsov.algorithms

fun main(args: Array<String>) {
    invoke()
}

private fun invoke() {
    val input = "mississippi"
    val input2 = "pi"
    println("Input:\n$input $input2")

    val output = strStr(input, input2)

    println("Output:\n$output")
}

private fun strStr(haystack: String, needle: String): Int {
    val invalid = -1
    if (needle.length > haystack.length) {
        return invalid
    }
    var occurrence = invalid
    var i = 0
    var j = 0
    while (i < haystack.length) {
        if (j == needle.length) {
            return occurrence
        }
        if (haystack[i] == needle[j]) {
            if (occurrence == invalid) {
                occurrence = i
            }
            j++
        } else {
            j = 0
            if (occurrence != invalid) {
                i = occurrence
            }
            occurrence = invalid
        }
        i++
    }
    return if (haystack.length - occurrence != needle.length) {
        invalid
    } else {
        occurrence
    }
}