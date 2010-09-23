/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.autoedit;

import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MultiLineTerminalsEditStrategyTest extends AbstractAutoEditTest{
	
	public void testNewLine_1() throws Exception {
		XtextEditor editor = openEditor("{|}");
		pressKey(editor, '\n');
		assertState("{\n\t|\n}", editor);
	}
	public void testNewLine_2() throws Exception {
		XtextEditor editor = openEditor("{foo|}");
		pressKey(editor, '\n');
		assertState("{\n\tfoo\n\t|\n}", editor);
	}
	public void testNewLine_3() throws Exception {
		XtextEditor editor = openEditor("{foo|bar}");
		pressKey(editor, '\n');
		assertState("{\n\tfoo\n\t|\n\tbar\n}", editor);
	}
	public void testNewLine_4() throws Exception {
		XtextEditor editor = openEditor("{\nfoo|bar}");
		pressKey(editor, '\n');
		assertState("{\nfoo\n\t|bar\n}", editor);
	}
	public void testNewLine_5() throws Exception {
		XtextEditor editor = openEditor("{\nfoo}|{bar}");
		pressKey(editor, '\n');
		assertState("{\nfoo}\n|{bar}", editor);
	}
	public void testNewLine_nested() throws Exception {
		XtextEditor editor = openEditor("{{foo}|{bar}}");
		pressKey(editor, '\n');
		assertState("{\n\t{foo}\n\t|\n\t{bar}\n}", editor);
	}
}
