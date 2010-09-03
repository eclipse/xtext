/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author koehnlein - Initial contribution and API
 */
public class OutlinePreferenceStoreInitializer implements IPreferenceStoreInitializer {

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	protected String languageName;

	protected String getQualifiedPropertyKey(String propertyKey) {
		return languageName + "." + propertyKey;
	}

	public void initialize(IPreferenceStoreAccess access) {
		access.getWritablePreferenceStore().setDefault(
				getQualifiedPropertyKey(ToggleLinkWithEditorAction.PREFERENCE_KEY), false);
		access.getWritablePreferenceStore().setDefault(getQualifiedPropertyKey(ToggleSortingAction.PREFERENCE_KEY),
				false);
	}
}
