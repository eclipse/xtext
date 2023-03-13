/*******************************************************************************
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.smoke

class Case_3 {
	def testReturnExpression_06() {
	    val (Integer) => Integer closure = [Integer i| return i]
	    for (x : 1..100) closure.apply(x)
	}
	def testReturnExpression_07(Class<?> c) {
		if (typeof(Case_3) != c) {
		    val (int)=>int closure = [Integer i| return i]
		    for (x : 1..100) closure.apply(x)
		}
	}
	
	def testOverriddenLocalVariable() {
	  val x = 3
	  var y = 2
	  {
	  	x.toString // just to get rid of the unused warning
	    var x2 = y
	    val y2 = 1
	    x2+y2
	  }
	}
	def testFeatureCall_03() {
		{ 
			var java.util.List<Character> x = ('abc'.toCharArray as Iterable<Character>).toList() 
			x 
		}
	}
}