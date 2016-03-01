/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor

import com.google.inject.Inject
import com.google.inject.Injector
import java.util.List
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.swt.SWT
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Event
import org.eclipse.xtext.junit4.ui.AbstractEditorTest
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.ui.editor.XtextEditor
import org.eclipse.xtext.ui.editor.XtextSourceViewer
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.junit.Before
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class DirtyStateEditorSupportIntegrationTest extends AbstractEditorTest {
	
	@Inject extension SyncUtil syncUtil
	
	XtextEditor editor
	
	List<IResourceDescription.Event> events
	
	Display display
	
	@Before
	def void setUpEditor() {
		val rsp = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(URI.createURI('dummy.testlanguage'))
		rsp.get(Injector).injectMembers(this)
		val file = createFile('test/foo.testlanguage', 'stuff foo')
		editor = openEditor(file)
		yieldToQueuedDisplayJobs(new NullProgressMonitor)
		events = <IResourceDescription.Event>newArrayList
		editor.dirtyStateEditorSupport.dirtyStateManager.addListener [
			events += it
		]
		display = editor.site.shell.display
		val styledText = editor.internalSourceViewer.textWidget
		styledText.caretOffset = 9
		styledText.setFocus
		waitForReconciler(editor)
		yieldToQueuedDisplayJobs(new NullProgressMonitor)
		assertTrue(events.empty)
	}

	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=488380
	 */	
	@Test
	def testSaveAndEdit() {
		display.post(new Event => [
			character = 'b'.toCharArray.head
			type = SWT.KeyDown
		])
		yieldToQueuedDisplayJobs(new NullProgressMonitor)	
		waitForReconciler(editor)
		assertEquals(1, events.size)
		assertEquals('foob', events.last.deltas.head.^new.exportedObjects.head.qualifiedName.segments.last)
		
		editor.doSave(new NullProgressMonitor)
		yieldToQueuedDisplayJobs(new NullProgressMonitor)
		assertEquals(2, events.size)
		assertNull(events.last.deltas.head.^new)
		display.post(new Event => [
			keyCode = SWT.BS
			type = SWT.KeyDown
		])	
		yieldToQueuedDisplayJobs(new NullProgressMonitor)
		waitForReconciler(editor)
		assertEquals(3, events.size)
		assertEquals('foo', events.last.deltas.head.^new.exportedObjects.head.qualifiedName.segments.last)
	}
	
	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=354123
	 */
	@Test
	def testUndoRedo() {
		display.post(new Event => [
			character = 'b'.toCharArray.head
			type = SWT.KeyDown
		])
		yieldToQueuedDisplayJobs(new NullProgressMonitor)	
		waitForReconciler(editor)
		assertEquals(1, events.size)
		assertEquals('foob', events.last.deltas.head.^new.exportedObjects.head.qualifiedName.segments.last)
	
		val undoManager = (editor.internalSourceViewer as XtextSourceViewer).undoManager
		undoManager.undo
		yieldToQueuedDisplayJobs(new NullProgressMonitor)
		waitForReconciler(editor)
		assertEquals(2, events.size)
		assertNull(events.last.deltas.head.^new)

		undoManager.redo
		yieldToQueuedDisplayJobs(new NullProgressMonitor)
		waitForReconciler(editor)
		assertEquals(3, events.size)
		assertEquals('foob', events.last.deltas.head.^new.exportedObjects.head.qualifiedName.segments.last)
	}
	
	override protected getEditorId() {
		'org.eclipse.xtext.ui.tests.TestLanguage'
	}
	
}