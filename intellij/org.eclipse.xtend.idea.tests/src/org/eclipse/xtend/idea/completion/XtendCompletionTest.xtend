/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.completion

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtext.idea.tests.LightToolingTest

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

class XtendCompletionTest extends LightToolingTest {

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
			"@",
			"annotation",
			"class",
			"enum",
			"import",
			"interface",
			"package"
		)
	}
	
	new() {
		super(XtendFileType.INSTANCE)
	}
	
	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXbaseLibrary
	}
}