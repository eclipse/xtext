/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.autoedit;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.tests.editor.AbstractEditorTest;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AutoEditTest extends AbstractEditorTest {

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.editor.bracketmatching.BmTestLanguage";
	}

	private List<IFile> files = Lists.newArrayList();


	@Override
	protected void tearDown() throws Exception {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
		files.clear();
		super.tearDown();
	}

	public void testParenthesis_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '(');
		assertState("(|)", editor);
		pressKey(editor, '(');
		assertState("((|))", editor);
		pressKey(editor, SWT.BS);
		assertState("(|)", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testParenthesis_2() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '(');
		assertState("(|)", editor);
		pressKey(editor, ')');
		assertState("()|", editor);
		pressKey(editor, SWT.BS);
		assertState("(|", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testParenthesis_3() throws Exception {
		XtextEditor editor = openEditor("|)");
		pressKey(editor, '(');
		assertState("(|)", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testStringLiteral_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '"');
		assertState("\"|\"", editor);
		pressKey(editor, SWT.BS);
		assertState("|", editor);
	}

	public void testStringLiteral_2() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '"');
		assertState("\"|\"", editor);
		pressKey(editor, '"');
		assertState("\"\"|", editor);
		pressKey(editor, SWT.BS);
		assertState("\"|", editor);
	}

	public void testStringLiteral_3() throws Exception {
		XtextEditor editor = openEditor("|'");
		pressKey(editor, '\'');
		assertState("'|'", editor);
		pressKey(editor, '\'');
		assertState("''|", editor);
		pressKey(editor, '\'');
		assertState("'''|'", editor);
		pressKey(editor, SWT.BS);
		assertState("''|", editor);
	}

	public void testCurlyBracesBlock_1() throws Exception {
		XtextEditor editor = openEditor("|");
		pressKey(editor, '{');
		assertState("{|", editor);
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	public void testCurlyBracesBlock_2() throws Exception {
		XtextEditor editor = openEditor("{|\n}");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}

	public void testLongTerminalsBlock_1() throws Exception {
		XtextEditor editor = openEditor("begin|");
		pressKey(editor, '\n');
		assertState("begin\n\t|\nend", editor);
	}

	public void testLongTerminalsBlock_2() throws Exception {
		XtextEditor editor = openEditor("begin|\nend");
		pressKey(editor, '\n');
		assertState("begin\n\t|\nend", editor);
	}

	public void testShortcut_1() throws Exception {
		XtextEditor editor = openEditor("fb|");
		pressKey(editor, 'b');
		assertState("foobarbaz|", editor);
		// Don't know how to simulate the press ESC scenario. The following does not work.
		pressKey(editor, SWT.ESC);
		assertState("fbb|", editor);
	}

	private XtextEditor openEditor(String string) throws Exception {
		int cursor = string.indexOf('|');
		IFile file = createFile("foo/myfile" + files.size() + ".bmtestlanguage", string.replace("|", ""));
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
		assertEquals(cursor, selection.getOffset());
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

}
