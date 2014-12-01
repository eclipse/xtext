/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@Singleton
public class XtextPreferenceStoreInitializer implements IPreferenceStoreInitializer {
	
	private @Inject ConfigurableIssueCodesProvider issueCodesProvider;
	
	public void initialize(IPreferenceStoreAccess preferenceStoreAccess) {
		IPreferenceStore preferenceStore = preferenceStoreAccess.getWritablePreferenceStore();
		for (PreferenceKey prefKey : issueCodesProvider.getConfigurableIssueCodes().values()) {
			preferenceStore.setDefault(prefKey.getId(), prefKey.getDefaultValue());
		}
	}

}
