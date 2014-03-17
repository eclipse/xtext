/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.autoedit;

import org.eclipse.core.resources.IFile;
import org.eclipse.swt.SWT;
import org.eclipse.xtext.junit4.ui.AbstractCStyleLanguageAutoEditTest;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AutoEditTest extends AbstractCStyleLanguageAutoEditTest {

	@Override
	protected String getEditorId() {
		return "org.eclipse.xtext.ui.tests.editor.bracketmatching.BmTestLanguage";
	}

	@Override
	protected String getFileExtension() {
		return "bmtestlanguage";
	}

	@Test public void testLongTerminalsBlock_1() throws Exception {
		XtextEditor editor = openEditor("begin|");
		pressKey(editor, '\n');
		assertState("begin\n\t|\nend", editor);
	}

	@Test public void testLongTerminalsBlock_2() throws Exception {
		XtextEditor editor = openEditor("begin|\nend");
		pressKey(editor, '\n');
		assertState("begin\n\t|\nend", editor);
	}

	@Test public void testShortcut_1() throws Exception {
		XtextEditor editor = openEditor("fb|");
		pressKey(editor, 'b');
		assertState("foobarbaz|", editor);
		// Don't know how to simulate the press ESC scenario. The following does not work.
		pressKey(editor, SWT.ESC);
		assertState("fbb|", editor);
	}
	
	@Test public void testClosingTerminalNextToDifferentPartition() throws Exception {
		XtextEditor editor = openEditor("{|\n}'foo'");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}'foo'", editor);
	}
	
	@Override
	protected XtextEditor openEditor(IFile file) throws Exception {
		JavaProjectSetupUtil.setUnixLineEndings(file.getProject());
		XtextEditor editor = super.openEditor(file);
		return editor;
	}

}
