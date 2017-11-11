/*
 *
 */
package io.github.kaushikrroy.programmers.scala.notes.lists

/**
 * @author kaushik.roy
 *
 */
class SortedListInserter {
  /**
   * @param head
   * @param n
   * @return
   */
  def insert(head: Node[Int], n: Int): Node[Int] = {
    if (null == head) new ListNode[Int](n) else {
      var currentNode = head
      var previousNode = currentNode

      while (null != currentNode && n > previousNode.value) {
        previousNode = currentNode
        currentNode = currentNode.next
      }

      previousNode -> new ListNode[Int](n) -> currentNode

      head
    }
  }
}