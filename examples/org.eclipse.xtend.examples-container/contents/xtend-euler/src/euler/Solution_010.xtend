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

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 *
 * @see http://projecteuler.net/problem=10
 */
class Solution_010 {

	def static void main(String[] args) {
		var primes = <Long>newArrayList
		for(i: 2..1_999_999) {
			var primeIter = primes.iterator
			var isPrime = true
			var knownPrime = 0L
			while(isPrime && knownPrime * knownPrime < i && primeIter.hasNext) {
				knownPrime = primeIter.next
				if (i % knownPrime == 0) {
					isPrime = false
				}
			}
			if (isPrime) {
				primes += i as long
			}
		}
		println(primes.reduce [i1, i2 | i1 + i2])
	}
}