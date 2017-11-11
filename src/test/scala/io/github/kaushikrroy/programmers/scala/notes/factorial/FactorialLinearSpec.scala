package io.github.kaushikrroy.programmers.scala.notes.factorial

import org.scalatest.FlatSpec
import org.scalatest.Matchers
import org.scalactic.source.Position.apply

/**
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
 * @author kaushikrroy@gmail.com
 *
 */
class FactorialLinearSpec extends FlatSpec with Matchers {
  import io.github.kaushikrroy.programmers.scala.notes.factorial.Iterative._;
  
  "Factorial of 0 by linear" should " yield 1" in {
    factorial(0) should be(1)
  }

  "Factorial of 1 by linear" should " yield 1" in {
    factorial(1) should be(1)
  }

  "Factorial of 2 by linear" should " yield 2" in {
    factorial(2) should be(2)
  }

  "Factorial of 3 by linear" should " yield 6" in {
    factorial(3) should be(6)
  }

  "Factorial of 5 by linear" should " yield 120" in {
    factorial(5) should be(120)
  }
}