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

import com.google.common.collect.AbstractIterator

import java.util.BitSet

/**
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n -> n/2 (n is even)
 * n -> 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * @see http://projecteuler.net/problem=14
 */
class Solution_014 extends AbstractIterator<Long> {

	def static void main(String[] args) {
		val numbersSeen = new BitSet(1_000_000)
		println((1_000_000..1).map[
			it -> new Solution_014(it, numbersSeen).size
		].reduce[ r1, r2 | if (r1.value > r2.value) r1 else r2 ].key)
	}

	Long current
	BitSet numbersSeen

	new(long start, BitSet numbersSeen) {
		current = start
		if (numbersSeen.get(current.intValue)) {
			current = 1L
		}
		this.numbersSeen = numbersSeen
	}

	override protected Long computeNext() {
		val result = current
		current = switch(current) {
			case 0L: return endOfData
			case 1L: 0L
			case current % 2 == 0: current / 2
			default : 3 * current + 1
		}
		if (result < 1_000_000)
			numbersSeen.set(result.intValue)
		return result
	}

}