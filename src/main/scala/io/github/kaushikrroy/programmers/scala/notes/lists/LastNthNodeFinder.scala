/*
 * MIT License
 *
 * Copyright (c) 2017 Kaushik Roy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
 */
package io.github.kaushikrroy.programmers.scala.notes.lists

/**
 * @author kaushik.roy
 *
 */
object LastNthNodeFinder {
  /**
   * @param head
   * @param n
   * @return
   */
  def findNthFromLast[T](head: Node[T], n: Int): Node[T] = {
    var runner = head; var result = head; var i = 0

    while (null != head && i < n) {
      runner = runner.next
      i = i + 1;
    }

    if (null != runner) {
      while (null != runner) {
        runner = runner.next
        result = result.next
      }
    }

    result;
  }

  def main(args: Array[String]): Unit = {
    val x1 = new ListNode[Integer](1);
    val x2 = new ListNode[Integer](2);
    val x3 = new ListNode[Integer](3);
    val x4 = new ListNode[Integer](4);
    val x5 = new ListNode[Integer](5);
    
    x1 -> x2 -> x3 -> x4 -> x5
    
    println(x1)
    
    val result = LastNthNodeFinder.findNthFromLast(x1, 2)
    
    println(result)
  }
}