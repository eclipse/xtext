/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

class TestClass1 {

	def testFunction1() {
		42
	}
	
	def testFunction2() {
		return 42
	}
		
	def Integer testFunction3() {
		40 + 2
	}
	
	def Integer testFunction4() {
		return 6 * 7
	}	
}