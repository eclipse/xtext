/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Author - Sebastian Zarnekow
 * See https://github.com/szarnekow/xtend-euler 
 *******************************************************************************/
 package euler

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * @see http://projecteuler.net/problem=5
 */
class Solution_005 {

	def static void main(String[] args) {
		var result = <Integer>newArrayList()
		for(i: 2..20) {
			var j = i
			for(k: result) {
				if (j % k == 0) {
					j = j / k
				}
			}
			if (j != 1)
				result += j
		}
		println(result.reduce[ m1, m2 | m1 * m2])
	}

}