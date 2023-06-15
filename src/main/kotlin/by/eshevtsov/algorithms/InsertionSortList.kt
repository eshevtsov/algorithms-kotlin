package by.eshevtsov.algorithms

fun main(args: Array<String>) {
    sortLinkedList()
}

private fun sortArrayList() {
    val input: List<Int> = mutableListOf(-1, 5, 3, 4, 0)
    println("Input:\n$input")

    val output: List<Int> = process(input)
    println("Output:\n$output")
}

private fun process(input: List<Int>): List<Int> {
    val list = input.toMutableList()
    var i = 0
    while (i < list.size - 1) {
        i++
        var j = 0
        while (j < i) {
            if (list[j] > list[i]) {
                val item = list.removeAt(i)
                list.add(j, item)
                break
            }
            j++
        }
    }
    return list
}


private fun sortLinkedList() {
    val input: ListNode? = ListNode.of(-1, 5, 3, 4, 0)
    println("Input:\n$input")

    val output: ListNode? = process(input)
    println("Output:\n$output")
}

private class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun of(vararg items: Int): ListNode? {
            return of(items.toList())
        }

        fun of(items: List<Int>): ListNode? {
            val head = ListNode(0)
            items.fold(head) { acc, i ->
                ListNode(i).also { acc.next = it }
            }
            return head.next
        }
    }

    override fun toString(): String {
        var result = "$`val` "
        var iterator = next
        while (iterator != null) {
            result += "" + iterator.`val` + " "
            iterator = iterator.next
        }
        return result
    }
}

private fun process(head: ListNode?): ListNode? {
    var head = head ?: return null
    var iI = head
    while (iI.next != null) {
        var iIP = iI
        iI = iI.next!!
        var jI = head
        var jIP = head
        while (jI != iI) {
            if (jI.`val` > iI.`val`) {
                iIP.next = iI.next
                val item = iI
                if (jI == head) {
                    item.next = head
                    head = item
                } else {
                    item.next = jI
                    jIP.next = item
                }
                iI = iIP
                break
            }
            jIP = jI
            if (jI.next == null) {
                break
            }
            jI = jI.next!!
        }
    }
    return head
}