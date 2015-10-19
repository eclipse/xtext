/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.documentation

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiReference
import com.intellij.testFramework.PsiTestCase
import com.intellij.testFramework.PsiTestUtil
import org.eclipse.xtend.core.idea.lang.XtendLanguage
import org.eclipse.xtext.idea.tests.LightToolingTest

import static extension com.intellij.codeInsight.documentation.DocumentationManager.*
import com.intellij.openapi.vfs.VfsUtil

/**
 * 
 * @author kosyakov - Initial contribution and API
 * @author moritz.eysholdt@itemis.de
 */
class XtendDocumentationTest extends PsiTestCase {

	VirtualFile src
	VirtualFile xtendgen

	override protected setUp() throws Exception {
		super.setUp()
		ApplicationManager.application.runWriteAction([
			val myTempDirectory = FileUtil.createTempDirectory(getTestName(true), "test", false);
			myFilesToDelete.add(myTempDirectory)
			val root = LocalFileSystem.getInstance().refreshAndFindFileByIoFile(myTempDirectory)
			src = VfsUtil.createDirectoryIfMissing(root, "src")
			xtendgen = VfsUtil.createDirectoryIfMissing(root, "xtend-gen")
			myModule = createModule("myModule")
			LightToolingTest.addFacetToModule(module, XtendLanguage.INSTANCE.ID)
			PsiTestUtil.addContentRoot(myModule, root);
			PsiTestUtil.addSourceRoot(myModule, src);
			PsiTestUtil.addSourceRoot(myModule, xtendgen);
		] as Runnable)
	}

	def void testJavaClass() {
		createFile(src, "Foo.java", '''
			/**
			 * mydocumentation
			 */
			public class Foo {
			}
		''')
		val xtend = createReferenceByFileWithMarker(src, 'Bar.xtend', '''
			class Bar extends F<caret>oo {
			}
		''')
		val expected = xtend.generateDocumentation
		assertTrue(expected.contains("mydocumentation"))
	}

	def void testXtendClass() {
		createFile(src, "Foo.xtend", '''
			/**
			 * mydocumentation
			 */
			class Foo {
			}
		''')
		val xtend = createReferenceByFileWithMarker(src, 'Bar.xtend', '''
			class Bar extends F<caret>oo {
			}
		''')
		val expected = xtend.generateDocumentation
		assertTrue(expected.contains("mydocumentation"))
	}

	def void testXtendField() {
		createFile(src, "Foo.xtend", '''
			class Foo {
				/**
				 * mydocumentation
				 */
				public val String myfoo = "x"
			}
		''')
		val xtend = createReferenceByFileWithMarker(src, 'Bar.xtend', '''
			class Bar {
				val String x = new Foo().my<caret>foo
			}
		''')
		val expected = xtend.generateDocumentation
		assertTrue(expected.contains("<b>myfoo = &quot;x&quot;</b>"))
		assertTrue(expected.contains("mydocumentation"))
	}

	def void testXtendMethod() {
		createFile(src, "Foo.xtend", '''
			class Foo {
				/**
				 * mydocumentation
				 */
				def myfoo() { "x" }
			}
		''')
		val xtend = createReferenceByFileWithMarker(src, 'Bar.xtend', '''
			class Bar {
				val String x = new Foo().my<caret>foo()
			}
		''')
		val expected = xtend.generateDocumentation
		assertTrue(expected.contains("<b>myfoo</b>()"))
		assertTrue(expected.contains("mydocumentation"))
	}

	def void testXtendConstructor() {
		createFile(src, "Foo.xtend", '''
			class Foo {
				/**
				 * mydocumentation
				 */
				new() {}
			}
		''')
		val xtend = createReferenceByFileWithMarker(src, 'Bar.xtend', '''
			class Bar {
				val String x = new F<caret>oo()
			}
		''')
		val expected = xtend.generateDocumentation
		assertTrue(expected.contains("<b>Foo</b>()"))
		assertTrue(expected.contains("mydocumentation"))
	}

	protected def PsiFile createFile(VirtualFile dir, String fileName, String contents) {
		createFile(myModule, dir, fileName, contents)
	}

	protected def PsiReference createReferenceByFileWithMarker(VirtualFile dir, String fileName, String contents) {
		val caret = "<caret>"
		val index = contents.indexOf(caret)
		val document = contents.substring(0, index) + contents.substring(index + caret.length, contents.length)
		val file = createFile(myModule, dir, fileName, document)
		return file.findReferenceAt(index)
	}

	protected def generateDocumentation(PsiReference reference) {
		val originalElement = reference.element
		val element = reference.resolve
		assertNotNull(originalElement)
		assertNotNull(element)
		generateDocumentation(element, originalElement)
	}

	protected def generateDocumentation(PsiElement element, PsiElement originalElement) {
		element.getProviderFromElement(originalElement).generateDoc(element, originalElement)
	}

}