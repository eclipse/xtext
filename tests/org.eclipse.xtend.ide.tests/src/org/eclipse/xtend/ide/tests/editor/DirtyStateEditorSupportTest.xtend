/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.jface.text.source.Annotation
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.junit.After
import org.junit.Before
import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 */
class DirtyStateEditorSupportTest extends AbstractXtendUITestCase {
	@Inject extension WorkbenchTestHelper
	@Inject extension SyncUtil

	@Before def void start() {
		closeWelcomePage
		
	}

	@After def void close() {
		_workbenchTestHelper.tearDown
	}
	
	@Test
	def testunloadJvmTypes(){
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
		consumer.document.replace(0,1,"p")
		consumer.waitForReconciler
		consumer.assertNumberOfErrorAnnotations(0)
		val replaceModel = '''
		package foo
		class NoDebuggingCase {
			def void call() {
				println() 
			} 
		}'''
		editor.document.replace(0,model.length,replaceModel)
		editor.saveEditor(false)
		consumer.waitForDirtyStateUpdater
		consumer.assertNumberOfErrorAnnotations(6)
		editor.document.replace(0, replaceModel.length,model)
		editor.saveEditor(false)
		consumer.waitForDirtyStateUpdater
		consumer.assertNumberOfErrorAnnotations(0)
	}
	
	static val VALIDATION_TIMEOUT = 10000L
	
	private def assertNumberOfErrorAnnotations(XtextEditor editor, int expectedNumber) {
		awaitUIUpdate([editor.errorAnnotations.size == expectedNumber], VALIDATION_TIMEOUT)
		val errors = editor.errorAnnotations
		assertEquals(errors.map[text + "("+ persistent +")"].join(', '), expectedNumber, errors.size)
	}
	
	private def getErrorAnnotations(XtextEditor editor) {
		editor.documentProvider.getAnnotationModel(editor.editorInput).annotationIterator
			.filter(Annotation).filter[type == 'org.eclipse.xtext.ui.editor.error'].toList
	}
	
}