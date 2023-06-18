package by.eshevtsov.algorithms

fun main(args: Array<String>) {
    removeDuplicates()
}

private fun removeDuplicates() {
    val input = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    println("Input:\n${input.joinToString()}")

    val output = removeDuplicates(input)
    println("Output:\n${input.joinToString()}\n$output")
}

private fun removeDuplicates(nums: IntArray): Int {
    if (nums.size < 2) {
        return nums.size
    }
    var uniqueCount = 0
    var i = 1
    while (i < nums.size) {
        if (nums[uniqueCount] != nums[i]) {
            if (i - uniqueCount > 1) {
                nums[uniqueCount + 1] = nums[i]
            }
            uniqueCount++
        }
        i++

    }
    return uniqueCount + 1
}

// 0, 0, 1, 1, 1, 2, 2, 3, 3, 4