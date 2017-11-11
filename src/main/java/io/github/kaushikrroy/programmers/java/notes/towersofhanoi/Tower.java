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
package io.github.kaushikrroy.programmers.java.notes.towersofhanoi;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.Deque;

/**
 * @author kaushikrroy@gmail.com
 */
public final class Tower {
	private final Deque<Disk> stack = new LinkedBlockingDeque<Disk>();

	public void push(final Disk disk) {
		if (this.stack.isEmpty()) {
			this.stack.push(disk);
		} else {
			if (this.stack.peek().getRank() <= disk.getRank()) {
				this.stack.push(disk);
			} else {
				throw new RuntimeException("A larger disk cannot be pushed on top of a smaller one.");
			}
		}
	}

	public Disk pop() {
		return this.stack.pop();
	}
	
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}
}
