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
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import org.junit.After
import org.junit.Test
import org.eclipse.emf.common.notify.NotifyingList
import org.eclipse.emf.common.notify.impl.AdapterImpl
import org.eclipse.emf.common.notify.Notification
import org.eclipse.emf.ecore.resource.Resource

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class EditorValidationTest extends AbstractXtendUITestCase {
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
		editor.document.readOnly [
			val issues = validator.validate(it, CheckMode.NORMAL_AND_FAST, [|false])
			assertTrue(issues.toString,issues.empty)
			return null
		]
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
		editor.document.readOnly [ r |
			r.eAdapters.add(new AdapterImpl() {
				override notifyChanged(Notification msg) {
					if(msg.getFeatureID(Resource) == Resource.RESOURCE__ERRORS) {
						if(msg.eventType == Notification.ADD) {
							println
							println("Error added (" + r.errors.size + " " + msg.newValue)
							new Exception().printStackTrace
						} else if(msg.eventType == Notification.REMOVE_MANY) {
							println("Error removed " + msg.oldValue)
							new Exception().printStackTrace
						}
					}
				}
			})	
		]
		editor.document.set(contentWithoutBar)
		editor.waitForReconciler()
		editor.document.readOnly [
			val issues = validator.validate(it, CheckMode.NORMAL_AND_FAST, [|false])
			assertEquals(issues.join("\n"),3,issues.length)
			return null
		]
		editor.document.set(contentWithoutBar+bar)
		editor.waitForReconciler()
		editor.document.readOnly [
			val issues = validator.validate(it, CheckMode.NORMAL_AND_FAST, [|false])
			assertTrue(issues.join("\n"),issues.empty)
			return null
		]
	}
	
	
}