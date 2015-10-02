/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.validation

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.roots.ModuleRootManager
import org.eclipse.xtend.idea.LightXtendTest
import com.intellij.openapi.vfs.VfsUtil

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendIdeaValidationTests extends LightXtendTest {
	
	def void testWrongPackage() {
		configureByText('''
			package <error descr="The declared package 'my.foo.pack' does not match the expected package ''">my.foo.pack</error>
			class Foo {
			}
		''')
		myFixture.checkHighlighting
	}
	
	def void testExcludedFile() {
		ApplicationManager.application.runWriteAction[
			val model = ModuleRootManager.getInstance(myFixture.module).modifiableModel
			val contentEntry = model.contentEntries.head
			val excludedDir = VfsUtil.createDirectoryIfMissing(contentEntry.file, 'excluded')
			contentEntry.addExcludeFolder(excludedDir)
			model.commit
		]
		val file = myFixture.addFileToProject('excluded/Foo.xtend', '''
			package mypackage
			class Foo extends <error descr="Bar cannot be resolved to a type."><error descr="Superclass must be a class">Bar</error></error> {
			}
		''').virtualFile
		myFixture.testHighlighting(true, true, true, file)
	}

}