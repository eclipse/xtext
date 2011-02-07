/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.autoedit;

import junit.framework.Test;

import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AutoEditInFirstMethodTest extends AutoEditTest {

	public static Test suite() {
		return suite(AutoEditInFirstMethodTest.class);
	}
	
	private static String PREFIX = "class Foo {\n\tfoo()\n";
	
	private static String SUFFIX = "\n\tbar() '''} zonk'''\n}";
	
	@Override
	protected XtextEditor openEditor(String string) throws Exception {
		return super.openEditor(PREFIX + string + SUFFIX);
	}
	
	@Override
	protected void assertState(String string, XtextEditor editor) {
		super.assertState(PREFIX + string + SUFFIX, editor);
	}
	
	/**
	 * FIXME: The test should pass as defined in the base class 
	 */
	@Override
	public void testCurlyBracesBlockInRichString_1() throws Exception {
		XtextEditor editor = openEditor("'''|'''");
		pressKey(editor, '{');
		assertState("'''{|'''", editor);
		pressKey(editor, '\n');
		assertState("'''{\n\t|'''", editor);
		pressKey(editor, '\n');
		assertState("'''{\n\t\n\t|'''", editor);
	}
	
	/**
	 * FIXME: The test should pass as defined in the base class 
	 */
	@Override
	public void testCurlyBracesBlockInRichString_4() throws Exception {
		XtextEditor editor = openEditor("'''foo {|'''");
		pressKey(editor, '\n');
		assertState("'''foo {\n\t|'''", editor);
	}
	
	/**
	 * FIXME: The test should pass as defined in the base class 
	 */
	@Override
	public void testCurlyBracesBlockInRichString_17() throws Exception {
		XtextEditor editor = openEditor("'''{\n|'''");
		pressKey(editor, '\n');
		assertState("'''{\n\n|'''", editor);
	}
	
}