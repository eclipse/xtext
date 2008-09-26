/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype;

import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.ui.core.editor.preferences.fields.AbstractDetailsPart;
import org.eclipse.xtext.ui.core.editor.preferences.fields.AbstractMasterDetailsFieldEditor;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class TokenTypeDefMasterDetailFieldEditor extends AbstractMasterDetailsFieldEditor {

	public TokenTypeDefMasterDetailFieldEditor(String name, String labelText, Composite composite,
			IPreferenceStore preferenceStore, List<ITokenTypeDef> list) {
		super(name, labelText, composite, preferenceStore, list);
	}

	protected String label(Object object) {
		if (object instanceof ITokenTypeDef)
			return ((ITokenTypeDef) object).getName();
		return object.toString();
	}

	protected String identifier(Object object) {
		if (object instanceof ITokenTypeDef)
			return ((ITokenTypeDef) object).getId();
		return object.toString();
	}

	@Override
	protected AbstractDetailsPart createDetailsPart() {
		return new TokenTypeDefDetailsPart(getPreferenceStore());
	}
}
