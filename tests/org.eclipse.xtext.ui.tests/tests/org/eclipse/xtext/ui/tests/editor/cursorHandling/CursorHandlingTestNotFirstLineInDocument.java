/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.cursorHandling;

import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CursorHandlingTestNotFirstLineInDocument extends CursorHandlingTest {

	@Override
	protected XtextEditor openEditor(String content) throws Exception {
		return super.openEditor("\n\n" + content);
	}
	
	@Override
	protected void assertState(String string, XtextEditor editor) {
		super.assertState("\n\n" + string, editor);
	}
	
}
