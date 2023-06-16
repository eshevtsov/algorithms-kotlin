package by.eshevtsov.algorithms

fun main(args: Array<String>) {
    removeElementInPlace()
}

private fun testWithOutput() {
    val inputItems: IntArray = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)
    val inputValue: Int = 2
    println("Input:\n${inputItems.joinToString(" ")}\n$inputValue")

    val outputItemsSize = removeElement(inputItems, inputValue)

    println("Output:\n${inputItems.joinToString(" ")}\n$outputItemsSize")
}

private fun removeElementInPlace() {
    val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2); // Input array
    val `val` = 2; // Value to remove
    val expectedNums = intArrayOf(0, 1, 4, 0, 3); // The expected answer with correct length.
    // It is sorted with no values equaling val.

    val k = removeElement(nums, `val`); // Calls your implementation

    assert(k == expectedNums.size)
    nums.sort(0, k); // Sort the first k elements of nums
    for (i in 0 until k) {
        assert(nums[i] == expectedNums[i])
    }
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
    var count: Int = 0
    for (i in nums.indices) {
        if (nums[i] != `val`) {
            nums[count] = nums[i]
            count++
        }
    }
    return count
}
