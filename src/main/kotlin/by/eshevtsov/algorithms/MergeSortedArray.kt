package by.eshevtsov.algorithms

import kotlin.collections.ArrayDeque
import kotlin.math.min

fun main(args: Array<String>) {
    mergeSortedArray()
}

private fun mergeSortedArray() {
    val nums1 = intArrayOf(0)
    val m = 0
    val nums2 = intArrayOf(1)
    val n = nums2.size
    println("Input:\n${nums1.joinToString(" ")}\n$m\n${nums2.joinToString(" ")}\n$n")

    merge(nums1, m, nums2, n)
    println("Output:\n${nums1.joinToString(" ")}")
}

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    if (n == 0) return

    val queue = ArrayDeque<Int>()
    val size = m + n

    var inserted = 0
    var i = 0
    while (i < m) {
        if (inserted == n || (queue.isNotEmpty() && queue.first() < nums2[inserted])) {
            queue.add(nums1[i])
            nums1[i] = queue.removeFirst()
        } else if (nums1[i] > nums2[inserted]) {
            queue.add(nums1[i])
            nums1[i] = nums2[inserted]
            inserted++
        }
        i++
    }
    while (i < size && inserted != n) {
        if (queue.isNotEmpty() && queue.first() < nums2[inserted]) {
            nums1[i] = queue.removeFirst()
        } else {
            nums1[i] = nums2[inserted]
            inserted++
        }
        i++
    }
    while (i < size && queue.isNotEmpty()) {
        nums1[i] = queue.removeFirst()
        i++
    }
}

//[1,1,4,_,_,_,_,_,_] queue = [] nums2 = [0,2,2,2,3,4]
//[0,1,4,_,_,_,_,_,_] queue = [1] nums2 = [_,2,2,2,3,4]
//[0,1,1,_,_,_,_,_,_] queue = [4] nums2 = [_,2,2,2,3,4]
//[0,1,1,_,_,_,_,_,_] queue = [4] nums2 = [_,2,2,2,3,4]


//[1,2,5,7,10,_], m = 3, nums2 = [_,_,6]
//[1,7,10,_,_,_], m = 3, nums2 = [2,5,6]
//[1,7,4,_,_,_], m = 3, nums2 = [2,5,9]
//[1,2,3,_,_,_], m = 3, nums2 = [4,5,6]
