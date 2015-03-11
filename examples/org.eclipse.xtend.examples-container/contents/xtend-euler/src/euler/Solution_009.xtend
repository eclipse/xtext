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
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a^2 + b^2 = c^2
 *
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * @see http://projecteuler.net/problem=9
 */
class Solution_009 {

	def static void main(String[] args) {
		(1..1000).forEach[ a|
			((a+1)..(1000-a)).forEach[ b|
				var c = 1000 - a - b
				if (c >= 0) {
					if (a*a + b*b == c*c) {
						println('''
							a = «a»
							b = «b»
							c = «c»
							product = «a*b*c»
						''')
					}
				}
			]
		]
	}
}