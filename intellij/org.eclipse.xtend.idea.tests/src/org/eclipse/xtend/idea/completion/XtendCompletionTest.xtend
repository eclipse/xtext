/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.completion

import org.eclipse.xtend.idea.LightXtendTest

class XtendCompletionTest extends LightXtendTest {

	def void testClassKeyword() {
		complete("cl<caret>")
		assertLookupStrings("class")
	}
	
	def void testExtendsKeyword() {
		complete("class Foo ex<caret>")
		assertLookupStrings("extends")
	}
	
	def void testEmptyFile() {
		complete("")
		assertLookupStrings(
			"annotation",
			"class",
			"enum",
			"import",
			"interface",
			"package"
		)
	}
}