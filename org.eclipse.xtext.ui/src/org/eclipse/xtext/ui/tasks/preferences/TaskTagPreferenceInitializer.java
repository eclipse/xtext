/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tasks.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.tasks.PreferenceTaskTagProvider;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class TaskTagPreferenceInitializer implements IPreferenceStoreInitializer {

	@Override
	public void initialize(IPreferenceStoreAccess access) {
		IPreferenceStore store = access.getWritablePreferenceStore();
		PreferenceTaskTagProvider.KEYS.forEach(preferenceKey -> store.setDefault(preferenceKey.getId(), preferenceKey.getDefaultValue()));
	}
}
