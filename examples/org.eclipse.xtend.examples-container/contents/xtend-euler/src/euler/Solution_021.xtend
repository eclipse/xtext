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

import static extension java.lang.Math.*

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a != b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 * @see http://projecteuler.net/problem=21
 */
class Solution_021 {

	def static void main(String[] args) {
		var result = <Integer>newHashSet
		val max = 10000
		for(i: 1..max) {
			if (!result.contains(i)) {
				val sumOfDivisors = sumOfDivisors(i)
				if (sumOfDivisors != i && sumOfDivisors <= max) {
					val otherSumOfDivisors = sumOfDivisors(sumOfDivisors)
					if (otherSumOfDivisors == i) {
						result.add(i)
						result.add(sumOfDivisors)
					}
				}
			}
		}
		println(result.reduce[i1, i2| i1 + i2])
	}

	def static sumOfDivisors(int input) {
		val sqrt = Math.sqrt(input).floor.intValue;
		(2..sqrt).filter [ div |
			input % div == 0
		].fold(1) [ i1, i2 |
			val other = input / i2
			if (other != i2)
				i1 + i2 + other
			else
				i1 + i2
		]
	}

}