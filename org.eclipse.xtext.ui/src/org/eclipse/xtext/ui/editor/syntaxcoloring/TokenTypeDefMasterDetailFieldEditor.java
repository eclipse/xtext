/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.editor.preferences.fields.AbstractDetailsPart;
import org.eclipse.xtext.ui.editor.preferences.fields.AbstractMasterDetailsFieldEditor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.util.Triple;

/**
 * @author Dennis Hübner - Initial contribution and API
 *
 */
public class TokenTypeDefMasterDetailFieldEditor extends AbstractMasterDetailsFieldEditor {

	TokenTypeDefMasterDetailFieldEditor(String name, String labelText, Composite composite,
			IPreferenceStore preferenceStore, List<Triple<String, String, TextStyle>> list) {
		super(name, labelText, composite, preferenceStore, list);
	}

	@Override
	protected String label(Object object) {
		if (object instanceof Triple<?, ?, ?>)
			return (String) ((Triple<?, ?, ?>) object).getSecond();
		return object.toString();
	}

	@Override
	protected String identifier(Object object) {
		if (object instanceof Triple<?, ?, ?>)
			return (String) ((Triple<?, ?, ?>) object).getFirst();
		return object.toString();
	}

	@Override
	protected AbstractDetailsPart createDetailsPart() {
		return new TokenTypeDefDetailsPart(getPreferenceStore());
	}
}
