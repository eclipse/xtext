/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

import static extension org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XtendEditorChangingClasspathTest extends AbstractXtendUITestCase {

	@Inject
	extension XtendLibClasspathAdder

	@Inject
	WorkbenchTestHelper workbenchTestHelper

	@Inject
	IStateChangeEventBroker stateChangeEventBroker

	override tearDown() throws Exception {
		workbenchTestHelper.tearDown
	}

	@Test
	def void testAddXtendLib() {
		val project = createJavaProject('testProject')
		val file = 'testProject/src/Foo.xtend'.createFile('class Foo {}')
		waitForAutoBuild

		workbenchTestHelper.openEditor(file)
		project.assertAddLibsToClasspath
	}

	@Test
	def void testAddXtendLibWithDirtyEditor() {
		val project = createJavaProject('testProject')
		val file = 'testProject/src/Foo.xtend'.createFile('class Foo {}')
		waitForAutoBuild

		val editor = workbenchTestHelper.openEditor(file)

		waitForChangeEvent[ |
			editor.changeContent("{}", "{ def foo () {} }")
		]

		project.assertAddLibsToClasspath
	}

	def assertAddLibsToClasspath(IJavaProject project) {
		assertNotNull(
			waitForCoarseGrainedEvent [ |
				project.addLibsToClasspath(null)
			])
	}

	def waitForCoarseGrainedEvent(=>void producer) {
		val event = newArrayList()
		val listenToEvent = newArrayList(true)
		stateChangeEventBroker.addListener [ e |
			if (listenToEvent.head && e instanceof IResourceDescription.CoarseGrainedEvent) {
				listenToEvent.set(0, false)
				event.add(e)
				stateChangeEventBroker.removeListener(self)
			}
		]
		producer.apply
		val maxAttempts = 5
		var attempt = 0;
		while (listenToEvent.head && attempt < maxAttempts) {
			Thread.sleep(50)
			attempt = attempt + 1
		}
		event.head
	}

	def waitForChangeEvent(=>void producer) {
		val event = newArrayList()
		val listenToEvent = newArrayList(true)
		stateChangeEventBroker.addListener [ e |
			if (listenToEvent.head) {
				listenToEvent.set(0, false)
				event.add(e)
				stateChangeEventBroker.removeListener(self)
			}
		]
		producer.apply
		val maxAttempts = 5
		var attempt = 0;
		while (listenToEvent.head && attempt < maxAttempts) {
			Thread.sleep(50)
			attempt = attempt + 1
		}
		event.head
	}

	def changeContent(XtextEditor editor, String oldText, String newText) {
		val document = editor.documentProvider.getDocument(editor.editorInput)
		val model = document.get
		document.replace(model.indexOf(oldText), oldText.length, newText)
		editor
	}

}
