/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke

class Case_4 {
	def richStrings_01() {
		'''foobar'''
	}
	def richStrings_02()
		'''«'start'»
		  first line
		  second line
	    		'''
	def richStrings_03() {
		'''«IF false»foobar«ELSEIF false»foobar«ELSE»zonk«ENDIF»'''
	}
	def richStrings_04() {
		'''  «FOR a:'1'.toCharArray»«FOR a2:'1'.toCharArray»foobar«ENDFOR»«ENDFOR»'''
	}
	def richStrings_05() {
		'''
			«FOR a:'1'.toCharArray»
			  «FOR a2:'12'.toCharArray»foobar«ENDFOR»
			«ENDFOR»
		'''
	}
}