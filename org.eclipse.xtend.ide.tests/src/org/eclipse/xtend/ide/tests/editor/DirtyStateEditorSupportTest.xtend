/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.apache.log4j.Level
import org.eclipse.jface.text.source.Annotation
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.logging.LoggingTester
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.model.XtextDocument
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.junit.After
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.TESTPROJECT_NAME
import static org.eclipse.xtend.ide.tests.WorkbenchTestHelper.createPluginProject

/**
 * @author Holger Schill - Initial contribution and API
 */
class DirtyStateEditorSupportTest extends AbstractXtendUITestCase {
	@Inject extension WorkbenchTestHelper
	@Inject extension SyncUtil

	@Before def void start() {
		createPluginProject(TESTPROJECT_NAME)
		closeWelcomePage
		IResourcesSetupUtil.reallyWaitForAutoBuild
	}

	@After def void close() {
		_workbenchTestHelper.tearDown
	}
	
	@Test
	def testBug464483() {
		IResourcesSetupUtil.assertNoErrorsInWorkspace
		val model = '''
			class A {
				new() {}
				static class B {}
			}
		'''
		val c1Editor = openEditor("C1.xtend", model)
		c1Editor.waitForReconciler
		
		val c2Editor = openEditor("C2.xtend",'''
			import A.B
			
			class C {}
		''')
		c2Editor.waitForReconciler

		c1Editor.assertHasNoErrors
		c2Editor.assertHasNoErrors
		// now remove the nested type
		val staticOffset = model.indexOf('static')
		LoggingTester.captureLogging(Level.ERROR, XtextDocument) [
			c1Editor.document.replace(staticOffset, 0, "// ")
			c1Editor.waitForReconciler
			c2Editor.assertHasErrors('A.B cannot be resolved to a type.')
		].assertNoLogEntries
	}
	
	@Test
	def testUnloadJvmTypes(){
		val model = '''
			package foo
			class NoDebuggingCase {
				def void call(NoDebuggingAcceptor inner) {
					println(inner) 
				}
				interface NoDebuggingAcceptor {
					def void accept(String typeImport)
				}
			} 
		'''
		val editor = openEditor("foo/foo.xtend",model)
		editor.waitForReconciler
		waitForBuild(null)
		
		val consumer = openEditor("foo/bar.xtend",'''
			package foo
			import foo.NoDebuggingCase
			class Bar {
				def void testCase() {
					var c = new NoDebuggingCase()
					c.call(new NoDebuggingCase.NoDebuggingAcceptor() {
						override accept(String typeImport) {
							throw new UnsupportedOperationException("TODO: auto-generated method stub")
						}
					})
				}
			}
		''')
		consumer.waitForReconciler
		waitForBuild(null)
		consumer.assertHasNoErrors
		
		
		val replaceModel = '''
			package foo
			class NoDebuggingCase {
				def void call() {
					println() 
				} 
			}
		'''
		editor.document.replace(0, model.length, replaceModel)
		editor.waitForReconciler
		consumer.assertHasErrors
		
		editor.document.replace(0, replaceModel.length, model)
		editor.waitForReconciler
		consumer.assertHasNoErrors
	}
	
	static val VALIDATION_TIMEOUT = 2000L
	
	private def assertHasErrors(XtextEditor editor) {
		editor.assertHasErrors(null)
	}
	
	private def assertHasErrors(XtextEditor editor, String... messages) {
		awaitUIUpdate([editor.errorAnnotations.size > 0], VALIDATION_TIMEOUT)
		val errors = editor.errorAnnotations
		assertTrue(errors.map[text + "("+ persistent +")"].join(', '), errors.size > 0)
		if (messages !== null) {
			val actualErrors = errors.map[text].toSet
			val expectedErrors = messages.toSet
			assertEquals(expectedErrors, actualErrors)
		}
	}
	
	private def assertHasNoErrors(XtextEditor editor) {
		awaitUIUpdate([editor.errorAnnotations.size == 0], VALIDATION_TIMEOUT)
		val errors = editor.errorAnnotations
		assertTrue(errors.map[text + "("+ persistent +")"].join(', '), errors.size == 0)
	}
	
	private def getErrorAnnotations(XtextEditor editor) {
		editor.documentProvider.getAnnotationModel(editor.editorInput).annotationIterator
			.filter(Annotation).filter[type == 'org.eclipse.xtext.ui.editor.error'].toList
	}
	
}