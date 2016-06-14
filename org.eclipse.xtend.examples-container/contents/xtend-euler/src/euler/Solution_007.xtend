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

import java.util.List

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 *
 * @see http://projecteuler.net/problem=7
 */
class Solution_007 {

	def static void main(String[] args) {
		var n = 10001
		var seenPrimes = <Integer>newArrayList
		var slice = 0
		while(true) {
			var numbers = ((slice*n + 1)..((slice + 1)*n)).toList
			for(prime: seenPrimes) {
				markAsNotPrime(prime, numbers)
			}
			slice = slice + 1
			while(!numbers.empty) {
				var nextPrime = numbers.remove(0)
				if (nextPrime != 1) {
					seenPrimes+=nextPrime
					if (seenPrimes.size == n) {
						println(nextPrime)
						return
					}
					markAsNotPrime(nextPrime, numbers)
				}
			}
		}
	}

	def static markAsNotPrime(int prime, List<Integer> numbers) {
		var iter = numbers.iterator
		while(iter.hasNext) {
			if (iter.next % prime == 0) {
				iter.remove
			}
		}
	}

}