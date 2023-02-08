/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.ui;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.bindings.keys.KeyLookupFactory;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.junit.After;
import org.junit.Before;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @deprecated Use org.eclipse.xtext.ui.testing.AbstractAutoEditTest instead
 */
@Deprecated(forRemoval = true)
public abstract class AbstractAutoEditTest extends AbstractEditorTest {

	private List<IFile> files = Lists.newArrayList();

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		closeWelcomePage();
	}
	
	@Override
	@After
	public void tearDown() throws Exception {
		files.clear();
		closeEditors();
		super.tearDown();
	}
	
	protected abstract String getFileExtension();

	protected XtextEditor openEditor(String string) throws Exception {
		int cursor = string.indexOf('|');
		String fileExtension = getFileExtension();
		IFile file = createFile("foo/myfile" + files.size() + "." + fileExtension, string.replace("|", ""));
		files.add(file);
		XtextEditor editor = openEditor(file);
		editor.getInternalSourceViewer().setSelectedRange(cursor, 0);
		editor.getInternalSourceViewer().getTextWidget().setFocus();
		return editor;
	}
	
	protected void assertState(String string, XtextEditor editor) {
		assertState(editor, string);
	}
	
	protected void assertState(XtextEditor editor, String string) {
		int cursor = string.indexOf('|');
		assertEquals(string.replace("|", ""), editor.getDocument().get());
		ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
		assertEquals("unexpected cursor position:",cursor, selection.getOffset());
	}

	protected void selectText(XtextEditor editor,int relativeToCurrentOffset,int length) throws Exception {
		ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
		editor.getInternalSourceViewer().setSelectedRange(selection.getOffset()+relativeToCurrentOffset, length);
	}

	protected void pressKey(XtextEditor editor, char c) throws Exception {
		StyledText textWidget = editor.getInternalSourceViewer().getTextWidget();
		Event e = new Event();
		e.character = c;
		e.type = SWT.KeyDown;
		e.doit = true;
		//XXX Hack!
		if (c == SWT.ESC) {
			e.keyCode = 27;
		}
		textWidget.notifyListeners(SWT.KeyDown, e);
	}
	
	protected void pasteText(XtextEditor editor, String text) throws Exception {
		StyledText textWidget = editor.getInternalSourceViewer().getTextWidget();
		Point selection = textWidget.getSelection();
		Event event = new Event();
		event.start = selection.x;
		event.end = selection.y;
		event.text = text;
		event.keyCode = KeyLookupFactory.getDefault().getCtrl();
		textWidget.notifyListeners(SWT.KeyDown, event);
		Method sendKeyEvent = textWidget.getClass().getDeclaredMethod("sendKeyEvent", Event.class);
		sendKeyEvent.setAccessible(true);
		sendKeyEvent.invoke(textWidget, event);
	}

	protected void pressKeys(XtextEditor editor, String string) throws Exception {
		for(int i = 0; i < string.length(); i++) {
			pressKey(editor, string.charAt(i));
		}
	}

	protected List<IFile> getFiles() {
		return files;
	}
}