/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.junit.editor.autoedit;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Event;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.junit.editor.AbstractEditorTest;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractAutoEditTest extends AbstractEditorTest {

	private List<IFile> files = Lists.newArrayList();

	protected AbstractAutoEditTest() {
		super();
	}

	protected AbstractAutoEditTest(String name) {
		super(name);
	}

	@Override
	protected void tearDown() throws Exception {
		files.clear();
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
		int cursor = string.indexOf('|');
		assertEquals(string.replace("|", ""), editor.getDocument().get());
		ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
		assertEquals("unexpected cursor position:",cursor, selection.getOffset());
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

	protected void pressKeys(XtextEditor editor, String string) throws Exception {
		for(int i = 0; i < string.length(); i++) {
			pressKey(editor, string.charAt(i));
		}
	}

}