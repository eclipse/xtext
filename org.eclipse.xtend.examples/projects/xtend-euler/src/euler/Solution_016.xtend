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

import static extension java.lang.Character.*

/**
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 2^1000?
 *
 * @see http://projecteuler.net/problem=16
 */
class Solution_016 {
	def static void main(String[] args) {
		println(2bi.pow(1000).toString.toCharArray.map[
			charValue.getNumericValue
		].reduce[ i1, i2 |
			i1 + i2
		])
	}
}