/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.ui.editor.preferences.fields.AbstractDetailsPart;
import org.eclipse.xtext.ui.editor.preferences.fields.AbstractMasterDetailsFieldEditor;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class OutputConfigurationFieldEditor extends AbstractMasterDetailsFieldEditor {

	public OutputConfigurationFieldEditor(String name, String labelText, Composite composite,
			IPreferenceStore preferenceStore, List<?> list) {
		super(name, labelText, composite, preferenceStore, list);
	}

	@Override
	protected AbstractDetailsPart createDetailsPart() {
		return new OutputConfigurationPage(getPreferenceStore());
	}

	@Override
	protected String label(Object object) {
		if (object instanceof OutputConfiguration)
			return ((OutputConfiguration) object).getDescription();
		return object.toString();
	}

	@Override
	protected String identifier(Object object) {
		if (object instanceof OutputConfiguration)
			return ((OutputConfiguration) object).getName();
		return object.toString();
	}

}
