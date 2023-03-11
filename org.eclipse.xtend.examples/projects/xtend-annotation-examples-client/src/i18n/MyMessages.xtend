/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package i18n

import java.util.Date

@Externalized
class MyMessages {
	
	val GREETING = "Hello {0}!"
	val DATE_AND_LOCATION = "Today is {0,date} and you are in {1}"
	
	def static void main(String[] args) {
		println('''
			«GREETING("World")»
			«DATE_AND_LOCATION(new Date(), "Kiel")»
		''')
	}
}