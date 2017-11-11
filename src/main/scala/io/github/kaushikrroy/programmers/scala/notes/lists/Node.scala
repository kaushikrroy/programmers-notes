package io.github.kaushikrroy.programmers.scala.notes.lists

/**
 * @author kaushik.roy
 *
 */
trait Node[T] {
  /**
   * @return
   */
  def next: Node[T]

  /**
   * @return
   */
  def value: T

  /**
   * @param next
   * @return
   */
  def ->(next: Node[T]): Node[T]
}