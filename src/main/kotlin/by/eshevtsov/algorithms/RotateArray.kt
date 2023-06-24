package by.eshevtsov.algorithms

fun main(args: Array<String>) {
    invoke()
}

private fun invoke() {
    val input = intArrayOf(1, 2, 3, 4, 5, 6)
    val inputK = 3
    println("Input:\n${input.joinToString()}\n$inputK")

    val output = rotate1(input, inputK)
    println("Output:\n${input.joinToString()}\n$output")
}

private fun rotate(nums: IntArray, k: Int): Unit {
    val step = k % nums.size
    if (step == 0) {
        return
    }
    var curr = nums[0]
    var position = 0
    var moves = 1
    var circleSize = nums.size + 1
    while (moves <= nums.size) {
        position += step
        position %= nums.size
        val tmp = nums[position]
        nums[position] = curr
        curr = tmp
        if (position == 0) {
            circleSize = moves
        }
        if (moves % circleSize == 0) {
            position++
            curr = nums[position]
        }
        moves++
    }
}

private fun rotate1(nums: IntArray, k: Int): Unit {
    val step = k % nums.size
    val partIndex = nums.lastIndex - step
    reverse(nums, partIndex + 1, nums.lastIndex)
    reverse(nums, 0, partIndex)
    reverse(nums, 0, nums.lastIndex)
}

private fun reverse(nums: IntArray, startIndex: Int, endIndexInclusive: Int) {
    var i = startIndex
    var j = endIndexInclusive
    while (i < j) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp

        i += 1
        j -= 1
    }
}

// 1,2,3,4,5,6,7
// _,2,3,1,5,6,7    ->4
// _,2,3,1,5,6,4
// _,2,7,1,5,6,4
// _,2,7,1,5,3,4
// 5,6,7,1,2,3,4