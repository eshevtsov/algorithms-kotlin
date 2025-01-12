package by.eshevtsov.algorithms

fun main(args: Array<String>) {
    process()
}

private fun process() {
    val input = intArrayOf(4, 1, 2, 1, 2)
    println("Input:\n${input.joinToString()}")

    val output: Int = SingleNumber.singleNumber(input)
    println("Output:\n$output")
}

object SingleNumber {

    /**
     * - Notice that XOR is commutative and associative.
     *   That means, a ^ b == b ^ a,
     *   and (a ^ b) ^ c == a ^ (b ^ c) == a ^ b ^ c)
     * - For all a, b, c. Also, if you XOR the same number twice, it cancels out, and the result becomes 0.
     *   Given any number n, n ^ n == 0, also a ^ n ^ n == a.
     * - For all a, a ^ 0 == a because if this bit of a is 1, exactly one bit in that position is 1.
     *
     * So 5^5=0, 5^15^5 = 15 ----> cause 5^15^5 = 5^5^15 = 0^15 = 15
     * (Like in multiplying)
     */
    fun singleNumber(nums: IntArray): Int {
        var result = nums[0]
        var i = 1
        while (i < nums.size) {
            result = result.xor(nums[i])
            i++
        }
        return result
    }
}