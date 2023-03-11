/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;

import com.google.inject.Singleton;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Dennis Huebner - IssueCodes
 */
@Singleton
public class XtendPreferenceStoreInitializer implements IPreferenceStoreInitializer, IPropertyChangeListener {
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	@Override
	public void initialize(IPreferenceStoreAccess preferenceStoreAccess) {
		this.preferenceStoreAccess = preferenceStoreAccess;

		IPreferenceStore preferenceStore = org.eclipse.jdt.ui.PreferenceConstants.getPreferenceStore();
		preferenceStore.addPropertyChangeListener(this);
		preferenceStoreAccess.getWritablePreferenceStore().setDefault(PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION,
				preferenceStore.getBoolean(org.eclipse.jdt.ui.PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION));
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (preferenceStoreAccess == null) {
			return;
		}
		if (org.eclipse.jdt.ui.PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION.equalsIgnoreCase(event.getProperty())) {
			preferenceStoreAccess.getWritablePreferenceStore().setValue(PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION,
					Boolean.valueOf(event.getNewValue().toString()));
		}
	}

}
