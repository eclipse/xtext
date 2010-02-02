/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.xtext.Constants;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextEditorPropertyTester extends PropertyTester {

	public XtextEditorPropertyTester() {
		super();
	}
	
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (receiver instanceof XtextEditor) {
			XtextEditor editor = (XtextEditor) receiver;
			if (Constants.LANGUAGE_NAME.equals(property))
				return editor.getLanguageName().equals(expectedValue);
		}
		return false;
	}

}
