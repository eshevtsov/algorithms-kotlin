package by.eshevtsov.algorithms

import kotlin.text.Typography.half

fun main(args: Array<String>) {
    process()
}

private fun process() {
    val input = intArrayOf(3, 3, 4)
    println("Input:\n${input.joinToString()}")

    val output = majorityElement1(input)
    println("Output:\n$output")
}

private fun majorityElement(nums: IntArray): Int {
    val repetitions = hashMapOf<Int, Int>()
    val half = nums.size / 2
    for (n in nums) {
        val newCount = repetitions.getOrDefault(n, 0) + 1
        if (newCount > half) {
            return n
        }
        repetitions[n] = newCount
    }
    return 0
}

private fun majorityElement1(nums: IntArray): Int {
    var repetitions = 0
    var majority = 0
    for (n in nums) {
        if (repetitions == 0 || majority == n) {
            majority = n
            repetitions++
        } else {
            repetitions--
        }
    }
    return majority
}