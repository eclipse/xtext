/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * Contributors:
 *   Jan Koehnlein - Initial API and implementation
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.graph;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

import com.google.inject.Singleton;

/**
 * Handles preferences of the railroad diagram view.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class RailroadViewPreferences extends AbstractPreferenceInitializer {

	private ScopedPreferenceStore preferenceStore;
	
	public static final String LINK_WITH_EDITOR_KEY = "linkWithEditor";

	public RailroadViewPreferences() {
		preferenceStore = new ScopedPreferenceStore(ConfigurationScope.INSTANCE, "Xtext Grammar View");
	}

	@Override
	public void initializeDefaultPreferences() {
		preferenceStore.setDefault(LINK_WITH_EDITOR_KEY, false);
	}

	public boolean isLinkWithEditor() {
		return preferenceStore.getBoolean(LINK_WITH_EDITOR_KEY);
	}
	
	public void setLinkWithEditor(boolean isLinkWithEditor) {
		preferenceStore.setValue(LINK_WITH_EDITOR_KEY, isLinkWithEditor);
	}
	
	public ScopedPreferenceStore getPreferenceStore() {
		return preferenceStore;
	}
}
