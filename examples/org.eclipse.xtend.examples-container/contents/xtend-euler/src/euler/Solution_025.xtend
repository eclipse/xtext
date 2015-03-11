/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sebastian Zarnekow
 * See https://github.com/szarnekow/xtend-euler 
 *******************************************************************************/
 package euler

import java.math.BigInteger
import com.google.common.collect.AbstractIterator

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 *
 *   Fn = Fn-1 + Fn-2, where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:
 *
 *    F1 = 1
 *    F2 = 1
 *    F3 = 2
 *    F4 = 3
 *    F5 = 5
 *    F6 = 8
 *    F7 = 13
 *    F8 = 21
 *    F9 = 34
 *    F10 = 55
 *    F11 = 89
 *    F12 = 144
 *
 * The 12th term, F12, is the first term to contain three digits.
 *
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 *
 * @see http://projecteuler.net/problem=25
 */
class Solution_025 extends AbstractIterator<Integer> {

	def static void main(String[] args) {
		println(new Solution_025().last)
	}

	BigInteger max = 10bi.pow(999)
	BigInteger f1 = 1bi
	BigInteger f2 = 1bi
	int idx = 2

	override Integer computeNext() {
		if (f2 >= max)
			return endOfData
		val next = f1 + f2
		f1 = f2
		f2 = next
		idx = idx + 1
		return idx
	}

}