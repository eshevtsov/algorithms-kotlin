package by.eshevtsov.algorithms

fun main(args: Array<String>) {
    removeDuplicates()
}

private fun removeDuplicates() {
    val input = intArrayOf(0,0,1,1,1,1,1,1,2,3,3)
    println("Input:\n${input.joinToString()}")

    val output = removeDuplicates1(input)
    println("Output:\n${input.joinToString()}\n$output")
}

private fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 2) {
        return nums.size
    }
    var uniqueCount = 0
    var i = 1
    while (i < nums.size - 1) {
        if (nums[uniqueCount] != nums[i] || nums[uniqueCount] != nums[i + 1]) {
            if (i - uniqueCount > 1) {
                nums[uniqueCount + 1] = nums[i]
            }
            uniqueCount++
        }
        i++
    }
    if (i - uniqueCount >= 1) {
        nums[uniqueCount + 1] = nums[i]
        uniqueCount++
    }
    return uniqueCount + 1
}

private fun removeDuplicates1(nums: IntArray): Int {
    var unique = 2
    for (i in 2 until nums.size) {
        if (nums[i] != nums[unique - 2]) {
            nums[unique] = nums[i]
            unique++
        }
    }
    return unique
}

// 0, 0, 1, 1, 1, 2, 2, 3, 3, 4