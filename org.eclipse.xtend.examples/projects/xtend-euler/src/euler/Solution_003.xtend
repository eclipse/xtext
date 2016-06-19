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

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @see http://projecteuler.net/problem=3
 */
class Solution_003 extends AbstractIterator<Long> {

	def static void main(String[] args) {
		println(new Solution_003().last)
	}

	long compound = 600851475143L
	long sqrt = Math.sqrt(compound).longValue
	long current = 2

	override protected computeNext() {
		while(current < sqrt) {
			if (compound % current == 0 && current.isPrime) {
				var result = current
				current = current + 1
				return result
			}
			current = current + 1
		}
		endOfData
	}

	def isPrime(long l) {
		(2..Math.sqrt(l).intValue).filter[ i | l % i == 0 ].empty
	}
}