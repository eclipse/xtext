package euler

import java.math.BigInteger

/**
 *
 * n! means n x (n - 1) x ... x 3 x 2 x 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 *
 * @see http://projecteuler.net/problem=20
 */
class Solution_020 {
	def static void main(String[] args) {
		println((1..100).fold(1bi) [ value, i |
			value * BigInteger::valueOf(i)
		].toString.toCharArray.fold(0) [ i, c |
			Character::getNumericValue(c) + i
		])
	}

}