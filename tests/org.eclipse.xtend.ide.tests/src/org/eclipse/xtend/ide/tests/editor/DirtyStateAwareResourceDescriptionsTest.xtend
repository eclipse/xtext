/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.eclipse.xtext.builder.impl.DirtyStateAwareResourceDescriptions

/**
 * @author Holger Schill - Initial contribution and API
 */
class DirtyStateAwareResourceDescriptionsTest extends AbstractXtendUITestCase {
	@Inject extension WorkbenchTestHelper
	
	@Inject
	DirtyStateAwareResourceDescriptions dirtyStateAwareResourceDescriptions

	

	@Before def void start() {
		closeWelcomePage
	}

	@After def void close() {
		_workbenchTestHelper.tearDown
	}
	
	@Test
	def testDerivedJvmTypeInDelta(){
		val model = '''
		class NoDebuggingCase {
			def void call(NoDebuggingAcceptor inner) {
				println(inner) 
			}   
		
			interface NoDebuggingAcceptor {
				def void accept(String typeImport)
			}
		} 
		'''
		val editor = openEditor("foo.xtend",model)
		editor.document.replace(0,model.length,'''
		class NoDebuggingCase {
			def void call() {
				println() 
			} 
		}''')
		val events = waitForChangeEvent
		val deltas = events.deltas
		assertEquals(3,deltas.size)
		deltas.forEach[d | println(d.uri.toString)]
		assertEquals("platform:/resource/test.project/src/foo.xtend",deltas.get(0).uri.toString)
		assertEquals("java:/Objects/NoDebuggingCase",deltas.get(1).uri.toString)
		assertEquals("java:/Objects/NoDebuggingCase$NoDebuggingAcceptor",deltas.get(2).uri.toString)
	}

	
	def waitForChangeEvent() {
		val events = <IResourceDescription.Event>newArrayList()
		val listenToEvent = newArrayList(true)
		dirtyStateAwareResourceDescriptions.addListener [ e |
			if (listenToEvent.head) {
				listenToEvent.set(0, false)
				events.add(e)
				dirtyStateAwareResourceDescriptions.removeListener(self)
			}
		]
		val maxAttempts = 5
		var attempt = 0;
		while (listenToEvent.head && attempt < maxAttempts) {
			Thread.sleep(100)
			attempt = attempt + 1
		}
		events.head
	}
	
}