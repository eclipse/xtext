/*******************************************************************************
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.ui.editor.XtextEditor
import org.junit.Test
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher
import java.lang.reflect.Field
import java.util.List
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.StyledText
import org.eclipse.swt.widgets.Event
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil
import org.eclipse.core.runtime.NullProgressMonitor

/**
 * Test for <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=493784">https://bugs.eclipse.org/bugs/show_bug.cgi?id=493784</a>
 * 
 * @author Christian Dietrich - Initial contribution and API
 */
class Bug493784Test extends AbstractXtendUITestCase {

	@Inject
	WorkbenchTestHelper testHelper;
	
	@Inject extension SyncUtil

	@Test
	def void testNoMemoryLeakOnEditing() {
		val String xtendModel = '''
			class A {
				
			}
			
			class A2 extends A {
				def test() {
				}
			}
		''';
		val IFile xtendClass = testHelper.createFile("XtendClass.xtend", xtendModel);
		val editor = testHelper.openEditor(xtendClass)
		assertEquals(1, editor.listenerCount)
		editor.pressKey(" ")
		editor.waitForReconciler
		assertEquals(1, editor.listenerCount)
		editor.pressKey(" ")
		editor.waitForReconciler
		assertEquals(1, editor.listenerCount)
		editor.doSave(new NullProgressMonitor)
		editor.waitForReconciler
		assertEquals(1, editor.listenerCount)
	}

	def private getListenerCount(XtextEditor editor) {
		editor.document.readOnly [
			val JvmTypeChangeDispatcher dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(it.resourceSet)
			val Field field = dispatcher.getClass().getDeclaredField("listeners")
			field.accessible = true
			val listeners = field.get(dispatcher) as List<Runnable>
			
			return listeners.size
		]
	}
	
	def private void pressKey(XtextEditor editor, char c) throws Exception {
		val StyledText textWidget = editor.getInternalSourceViewer().getTextWidget();
		val Event e = new Event();
		e.character = c;
		e.type = SWT.KeyDown;
		e.doit = true;
		textWidget.notifyListeners(SWT.KeyDown, e);
	}
}
