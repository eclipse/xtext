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

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.atomic.AtomicLong
import java.util.regex.Pattern

import static extension java.lang.Character.*

/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over five-thousand first names,
 * begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list.
 * So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 * @see http://projecteuler.net/problem=22
 */
class Solution_022 {

	def static void main(String[] args) {
		val reader = new BufferedReader(new InputStreamReader(Solution_022.getResourceAsStream("names.txt")))
		try {
			val line = reader.readLine
			val matcher = Pattern.compile('"(\\w+)"').matcher(line)
			val names = <String>newArrayList
			while(matcher.find) {
				names.add(matcher.group(1))
			}
			val result = new AtomicLong
			names.sort.forEach [ name, i |
				result.addAndGet(name.toCharArray.map [
					numericValue - 9
				].reduce[ i1, i2 |
					i1 + i2
				] * (i + 1))
			]
			println(result)
		} finally {
			reader.close
		}
	}

}