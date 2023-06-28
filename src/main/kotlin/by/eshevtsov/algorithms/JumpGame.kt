package by.eshevtsov.algorithms

fun main(args: Array<String>) {
    process()
}

private fun process() {
    val input = intArrayOf(2,3,1,1,4)
    println("Input:\n${input.joinToString()}")

    val output = canJump(input)
    println("Output:\n$output")
}

private fun canJump(nums: IntArray): Boolean {
    if (nums.size <= 1) return true

    var jumpStep = 1
    var i = 0
    while (i < nums.size - 1) {
        jumpStep--
        if (nums[i] > jumpStep) {
            jumpStep = nums[i]
        } else if (jumpStep == 0) {
            return false
        }
        i++
    }
    return jumpStep >= 0
}