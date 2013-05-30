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

import java.util.GregorianCalendar
import static java.util.Calendar.*

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 *  1 Jan 1900 was a Monday.
 *  Thirty days has September,
 *  April, June and November.
 *  All the rest have thirty-one,
 *  Saving February alone,
 *  Which has twenty-eight, rain or shine.
 *  And on leap years, twenty-nine.
 *  A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 *How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 * @see http://projecteuler.net/problem=19
 */
class Solution_019 {

	def static void main(String[] args) {
		val calendar = GregorianCalendar.instance
		calendar.set(1901, 1, 1)
		var result = 0
		do {
			if (calendar.get(DAY_OF_WEEK) == SUNDAY)
				result = result + 1
			calendar.add(MONTH, 1)
		} while(calendar.get(YEAR) <= 2000)
		println(result)
	}

}