/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.xtext.Constants;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Peter Friese
 */
public class XtextEditorPropertyTester extends PropertyTester {

	public XtextEditorPropertyTester() {
		super();
	}

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (Constants.LANGUAGE_NAME.equals(property)) {
			XtextEditor xtextEditor = Adapters.adapt(receiver, XtextEditor.class);
			if (xtextEditor != null) {
				return xtextEditor.getLanguageName().equals(expectedValue);
			}
		}
		return false;
	}

}
