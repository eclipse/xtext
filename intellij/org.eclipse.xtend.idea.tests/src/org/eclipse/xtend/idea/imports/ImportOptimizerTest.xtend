/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.imports

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.command.CommandProcessor
import com.intellij.psi.PsiDocumentManager
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtext.xbase.idea.imports.XImportSectionOptimizer
import org.junit.Assert

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ImportOptimizerTest extends LightXtendTest {
	
	def void testQualifiedNameGestShortened() {
		'''
			class Foo {
				java.util.List<String> myList
			}
		'''.assertAfterOptimizeImports('''
			import java.util.List
			
			class Foo {
				List<String> myList
			}
		''')
	}
	
	def void testSimpleNameClash() {
		'''
			class List {
				java.util.List<String> myList
			}
		'''.assertAfterOptimizeImports('''
			class List {
				java.util.List<String> myList
			}
		''')
	}
	
	def void testWildcardImportBecomesAbsolute() {
		'''
			import java.util.*
			
			class Foo {
				List<String> myList
			}
		'''.assertAfterOptimizeImports('''
			import java.util.List
			
			class Foo {
				List<String> myList
			}
		''')
	}
	
	def void assertAfterOptimizeImports(CharSequence before, String expected) {
		val file = myFixture.addFileToProject("MyClass.xtend", before.toString) 
		val runnable = XtendLanguage.INSTANCE.getInstance(XImportSectionOptimizer).processFile(file)
		CommandProcessor.instance.executeCommand(project, [
			ApplicationManager.application.runWriteAction [
				runnable.run
			]
			PsiDocumentManager.getInstance(getProject()).commitAllDocuments() 
		],"","")
		Assert.assertEquals(expected.toString, file.getText()) 
	}
}