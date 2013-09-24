/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import com.google.inject.Inject
import org.eclipse.jdt.core.ElementChangedEvent
import org.eclipse.jdt.core.JavaCore
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper

import static org.junit.Assert.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class JavaEditorExtension {

	val static VERBOSE = false

	@Inject
	extension WorkbenchTestHelper

	def reconcile(String fileName, String oldText, String newText) {
		fileName.openJavaEditor.reconcile(oldText, newText)
	}

	def reconcile(ITextEditor editor, String oldText, String newText) {
		editor.reconcile [
			changeContent(oldText, newText)
		]
	}

	def ITextEditor reconcile(ITextEditor editor, (ITextEditor)=>ITextEditor consumer) {
		if (consumer == null) {
			return editor
		}
		waitForPostReconcileEvent [ |
			consumer.apply(editor)
		]
		editor
	}

	def save(ITextEditor editor) {
		save(editor, null)
	}

	def save(ITextEditor editor, (ITextEditor)=>ITextEditor consumer) {
		waitForPostChangeEvent [ |
			if (consumer != null) {
				consumer.apply(editor)
			}
			assertTrue(editor.saveEditor(false))
		]
		editor
	}

	def close(ITextEditor editor) {
		close(editor, null)
	}

	def close(ITextEditor editor, (ITextEditor)=>ITextEditor consumer) {
		waitForPostChangeEvent [ |
			if (consumer != null) {
				consumer.apply(editor)
			}
			assertTrue(editor.closeEditor(false))
		]
		editor
	}

	def waitForPostReconcileEvent(=>void producer) {
		waitForElementChangedEvent(ElementChangedEvent.POST_RECONCILE, producer)
	}

	def waitForPostChangeEvent(=>void producer) {
		waitForElementChangedEvent(ElementChangedEvent.POST_CHANGE, producer)
	}

	def waitForElementChangedEvent(int eventMask, =>void producer) {
		if (VERBOSE) {
			println('''start waiting for an element changed event: «eventMask»''')
		}
		val changed = newArrayList(false)
		JavaCore.addElementChangedListener(
			[
				JavaCore.removeElementChangedListener(self)
				if (!changed.head) {
					changed.set(0, true)
					if (VERBOSE) {
						println(it)
					}
				}
			], eventMask)
		producer.apply
		while (!changed.head) {
		}
		if (VERBOSE) {
			println('''end waiting for an element changed event: «eventMask»''')
		}
	}

	def openJavaEditor(String fileName) {
		fileName.file.openLikeTextEditor
	}

	def changeContent(ITextEditor editor, String oldText, String newText) {
		val document = editor.documentProvider.getDocument(editor.editorInput)
		val model = document.get
		document.replace(model.indexOf(oldText), oldText.length, newText)
		editor
	}

}
