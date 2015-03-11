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
import java.util.Set

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis even though it is known that the greatest number that cannot
 * be expressed as the sum of two abundant numbers is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 *
 * @see http://projecteuler.net/problem=23
 */
class Solution_023 {

	def static void main(String[] args) {
		val allAbundantNumbers = (28123..1).filter[abundant].toSet
		println((28123..1).filter[ !isSumOfAbundantNumbers(allAbundantNumbers) ].reduce[ i1, i2 | i1 + i2])
	}

	def static isSumOfAbundantNumbers(int input, Set<Integer> allAmbundantNumbers) {
		for(i : allAmbundantNumbers) {
			if (allAmbundantNumbers.contains(input - i))
				return true
		}
		return false
	}

	def static isAbundant(int input) {
		val sqrt = Math.sqrt(input).floor.intValue;
		val sumOfDivisors = (2..sqrt).filter [ div |
			div != input && input % div == 0
		].fold(1) [ i1, i2 |
			val other = input / i2
			if (other != i2 && other != input)
				i1 + i2 + other
			else
				i1 + i2
		]
		return sumOfDivisors > input
	}

}