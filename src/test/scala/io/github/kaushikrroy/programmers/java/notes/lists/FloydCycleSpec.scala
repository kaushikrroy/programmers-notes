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
 */
package io.github.kaushikrroy.programmers.java.notes.lists

import org.scalatest.{FlatSpec, Matchers}

/**
 * @author kaushikrroy@gmail.com
 */
class FloydCycleSpec extends FlatSpec with Matchers {

  "This should make the algorithm detect a cycle and it" should "yield true" in {
    val x1 = new ListNode[Int](1)
    val x2 = new ListNode[Int](2)
    val x3 = new ListNode[Int](3)
    val x4 = new ListNode[Int](4)
    val x5 = new ListNode[Int](5)

    x1 setNext x2 setNext x3 setNext x4 setNext x5 setNext x1

    val cycleDetector = new FloydCycle
    cycleDetector findCycle x1 shouldBe(true)
  }
}
