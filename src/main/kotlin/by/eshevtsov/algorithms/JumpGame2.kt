package by.eshevtsov.algorithms

import kotlin.math.min

fun main(args: Array<String>) {
    process()
}

private fun process() {
    val input = intArrayOf(1,1,1,1)
    println("Input:\n${input.joinToString()}")

    val output = jump(input)
    println("Output:\n$output")
}

private fun jump(nums: IntArray): Int {
    if (nums.size <= 1) return 0

    var stepCount = 0
    var i = 0
    while (i < nums.size) {
        stepCount++
        if (nums[i] >= nums.lastIndex - i) {
            return stepCount
        }
        i = lastMax(i, nums)
    }
    return stepCount
}

private fun lastMax(jumpI: Int, nums: IntArray): Int {
    val size = min(nums.size, jumpI + nums[jumpI] + 1)

    var max = nums[jumpI] + 1
    var maxI = jumpI

    var i = jumpI + 1
    while (i < size) {
        max--
        if (nums[i] >= max) {
            max = nums[i]
            maxI = i
        }
        i++
    }
    return maxI
}