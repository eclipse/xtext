package euler

import java.util.List

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @see http://projecteuler.net/problem=4
 */
class Solution_004 {

	def static void main(String[] args) {
		var result = 0
		for(left: 100..999) {
			for(right: left..999) {
				var candidate = left * right
				if (candidate > result) {
					var List<Character> charList = candidate.toString.toCharArray
					if (charList.reverseView == charList)
						result = candidate
				}
			}
		}
		println(result)
	}

}