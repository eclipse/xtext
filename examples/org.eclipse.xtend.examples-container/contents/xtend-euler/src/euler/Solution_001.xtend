package euler

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @see http://projecteuler.net/problem=1
 */
class Solution_001 {

	def static void main(String[] args) {
		println((1..999).filter[ i | i % 3 == 0 || i % 5 == 0].reduce[i1, i2 | i1 + i2])
	}

}