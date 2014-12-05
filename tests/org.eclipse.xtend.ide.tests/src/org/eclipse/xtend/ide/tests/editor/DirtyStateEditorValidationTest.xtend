/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.jface.text.source.Annotation
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.junit.After
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class DirtyStateEditorValidationTest extends AbstractXtendUITestCase {
	
	static val VALIDATION_TIMEOUT = 10000L
	
	@Inject extension WorkbenchTestHelper helper
	
	@Inject extension SyncUtil
	
	@Inject IResourceValidator validator

	@After override void tearDown() {
		helper.tearDown
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=414947
	 */
	@Test def void testLinkingOfEnum() {
		val content = '''
			import static Foo.*
				
			@SuppressWarnings("all")
			class SomeClass {
				def foo() {
					val Foo x = A
					return x
				}
			}
			
			enum Foo {
				A, B, C
			}
		'''
		val file = createFile("SomeClass.xtend",content)
		waitForBuild(null)
		assertEquals(0, file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE).length)
		
		val editor = openEditor(file)
		editor.document.set('')
		editor.waitForReconciler()
		editor.document.set(content)
		editor.waitForReconciler()
		editor.assertNumberOfErrorAnnotations(0)
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=415052
	 */
	@Test def void testLinkingOfEnum2() {
		val contentWithoutBar = '''
			import static Foo.*
				
			@SuppressWarnings("all")
			class SomeClass {
				def foo() {
					val Foo x = A
					return x
				}
			}
		'''
		val bar = '''
			enum Foo {
				A, B, C
			}
		'''
		val file = createFile("SomeClass.xtend",contentWithoutBar+bar)
		waitForBuild(null)
		assertEquals(0, file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE).length)
		
		val editor = openEditor(file)
		editor.document.set(contentWithoutBar)
		editor.waitForReconciler()
		editor.assertNumberOfErrorAnnotations(3)

		editor.document.set(contentWithoutBar+bar)
		editor.waitForReconciler()
		editor.assertNumberOfErrorAnnotations(0)
	}
	
	@Test def void testAddedInterfaceMethod() {
		val interface = '''
			interface Foo {
			}
		'''
		val interfaceChanged = '''
			interface Foo {
				def void bar(String b)
			}
		'''
		val class = '''
			class Bar implements Foo {
			}
		'''

		val interfaceFile = createFile("Foo.xtend", interface)
		val classFile = createFile("Bar.xtend", class)
		waitForBuild(null)
		assertEquals(0, classFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE).length)
		val interfaceEditor = openEditor(interfaceFile)
		val classEditor = openEditor(classFile)
		classEditor.assertNumberOfErrorAnnotations(0)
		
		interfaceEditor.document.set(interfaceChanged)
		interfaceEditor.waitForReconciler
		classEditor.waitForDirtyStateUpdater
		classEditor.waitForReconciler
		classEditor.document.readOnly [
			val issues = validator.validate(it, CheckMode.NORMAL_AND_FAST, [|false])
			assertEquals(issues.toString, 1, issues.size)
			return null
		]
//		classEditor.assertNumberOfErrorAnnotations(1)
		
		interfaceEditor.document.set(interface)
		interfaceEditor.waitForReconciler
		classEditor.waitForDirtyStateUpdater
		classEditor.waitForReconciler
		classEditor.document.readOnly [
			val issues = validator.validate(it, CheckMode.NORMAL_AND_FAST, [|false])
			assertTrue(issues.toString, issues.empty)
			return null
		]
//		classEditor.assertNumberOfErrorAnnotations(0)
	}
	
	@Test def void testChangedOverriddenSignature() {
		val interface = '''
			interface Foo {
				def void bar()
			}
		'''
		val interfaceChanged = '''
			interface Foo {
				def void bar(String b)
			}
		'''
		val class = '''
			class Bar implements Foo {
				override bar() {}
			}
		'''

		val interfaceFile = createFile("Foo.xtend", interface)
		val classFile = createFile("Bar.xtend", class)
		waitForBuild(null)
		assertEquals(0, classFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE).length)
		val interfaceEditor = openEditor(interfaceFile)
		val classEditor = openEditor(classFile)
		classEditor.assertNumberOfErrorAnnotations(0)
		
		interfaceEditor.document.set(interfaceChanged)
		interfaceEditor.waitForReconciler
		classEditor.waitForDirtyStateUpdater
		classEditor.document.readOnly [
			val issues = validator.validate(it, CheckMode.NORMAL_AND_FAST, [|false])
			assertEquals(issues.toString, 2, issues.size)
			return null
		]
		//classEditor.assertNumberOfErrorAnnotations(2)
		
		interfaceEditor.document.set(interface)
		interfaceEditor.waitForReconciler
		classEditor.waitForDirtyStateUpdater
		classEditor.document.readOnly [
			val issues = validator.validate(it, CheckMode.NORMAL_AND_FAST, [|false])
			assertTrue(issues.toString, issues.empty)
			return null
		]
		//classEditor.assertNumberOfErrorAnnotations(0)
	}
	
	@Test def void testValidateOnOpen() {
		val interface = '''
			interface Foo {
				def void bar()
			}
		'''
		val interfaceChanged = '''
			interface Foo {
				def void bar(String b)
			}
		'''
		val class = '''
			class Bar implements Foo {
				override bar() {}
			}
		'''

		val interfaceFile = createFile("Foo.xtend", interface)
		val classFile = createFile("Bar.xtend", class)
		waitForBuild(null)
		assertEquals(0, classFile.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE).length)
		val interfaceEditor = openEditor(interfaceFile)

		val classEditor = openEditor(classFile)
		classEditor.assertNumberOfErrorAnnotations(0)
				
		classEditor.closeEditor(false)
		interfaceEditor.document.set(interfaceChanged)
		waitForReconciler(interfaceEditor)
		
		val classEditorWithError = openEditor(classFile)
		classEditorWithError.assertNumberOfErrorAnnotations(2)
	}
	
	private def assertNumberOfErrorAnnotations(XtextEditor editor, int expectedNumber) {
		helper.awaitUIUpdate([editor.errorAnnotations.size == expectedNumber], VALIDATION_TIMEOUT)
		val errors = editor.errorAnnotations
		assertEquals(errors.map[text + "("+ persistent +")"].join(', '), expectedNumber, errors.size)
	}
	
	private def getErrorAnnotations(XtextEditor editor) {
		editor.documentProvider.getAnnotationModel(editor.editorInput).annotationIterator
			.filter(Annotation).filter[type == 'org.eclipse.xtext.ui.editor.error'].toList
	}
	
}