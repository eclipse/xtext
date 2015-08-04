/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.documentation

import com.intellij.openapi.command.WriteCommandAction
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import org.eclipse.xtend.idea.LightXtendTest

import static extension com.intellij.codeInsight.documentation.DocumentationManager.*

/**
 * 
 * @author kosyakov - Initial contribution and API
 */
class XtendDocumentationTest extends LightXtendTest {

	protected override invokeTestRunnable(Runnable runnable) {
		WriteCommandAction.runWriteCommandAction(project, runnable)
	}

	def void testGenerateDocumentation() {
		myFixture.configureByText('Bar.java', '''
			package bar
			public class Bar {
				private foo.Fo<caret>o foo;
			}
		''')
		val expectedDocumentation = generateDocumentation('testSrc-xtend-gen', 'foo/Foo.java')
		val actualDocumentation = generateDocumentation('testSrc', 'foo/Foo.xtend')
		assertEquals(expectedDocumentation, actualDocumentation)
	}

	protected def generateDocumentation(String sourceFolder, String sourcePath) {
		val virtualFile = myFixture.copyFileToProject(sourceFolder + '/' + sourcePath, sourcePath)
		try {
			file.findReferenceAt(myFixture.caretOffset).generateDocumentation
		} finally {
			virtualFile.delete(this)
		}
	}

	protected def generateDocumentation(PsiReference reference) {
		val originalElement = reference.element
		val element = reference.resolve
		generateDocumentation(element, originalElement)
	}

	protected def generateDocumentation(PsiElement element, PsiElement originalElement) {
		element.getProviderFromElement(originalElement).generateDoc(element, originalElement)
	}

}