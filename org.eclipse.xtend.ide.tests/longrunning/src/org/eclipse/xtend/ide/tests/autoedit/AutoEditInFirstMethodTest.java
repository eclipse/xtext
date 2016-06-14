/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.autoedit;

import org.eclipse.xtext.ui.editor.XtextEditor;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AutoEditInFirstMethodTest extends AutoEditTest {

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
	@Ignore("FIXME: The test should pass as defined in the base class")
	@Test public void testCurlyBracesBlockInRichString_1() throws Exception {
		super.testCurlyBracesBlockInRichString_1();
	}
	
	/**
	 * FIXME: The test should pass as defined in the base class 
	 */
	@Override
	@Ignore("FIXME: The test should pass as defined in the base class")
	@Test public void testCurlyBracesBlockInRichString_4() throws Exception {
		super.testCurlyBracesBlockInRichString_4();
	}
	
	/**
	 * FIXME: The test should pass as defined in the base class 
	 */
	@Override
	@Ignore("FIXME: The test should pass as defined in the base class")
	@Test public void testCurlyBracesBlockInRichString_17() throws Exception {
		super.testCurlyBracesBlockInRichString_17();
	}
	
}