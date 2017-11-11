package io.github.kaushikrroy.programmers.scala.notes.lists

/**
 * @author kaushik.roy
 *
 */
class ListNode[T](val data: T) extends Node[T] {
  private[this] var _next: Node[T] = null

  /**
   * @see io.github.kaushikrroy.programmers.scala.notes.lists.Node#next()
   */
  def next: Node[T] = this._next

  /**
   * @return
   */
  def value: T = this.data

  /**
   * @param next
   * @return
   */
  def ->(next: Node[T]): Node[T] = {
    this._next = next; next
  }

  /**
   * @see java.lang.Object#toString()
   */
  override def toString =
    String.valueOf(this.data) + (if (null != this.next) " -> " + this.next.toString() else "")
}