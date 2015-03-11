/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.autoedit;

import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AutoEditInSecondMethodTest extends AutoEditTest {

	private static String PREFIX = "class Foo {\n\tfoo() '''zonk {'''\n\tbar()\n";
	
	private static String SUFFIX = "\n}";
	
	@Override
	protected XtextEditor openEditor(String string) throws Exception {
		return super.openEditor(PREFIX + string + SUFFIX);
	}
	
	
	@Override
	protected void assertState(String string, XtextEditor editor) {
		super.assertState(PREFIX + string + SUFFIX, editor);
	}
	
}