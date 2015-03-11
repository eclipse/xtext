/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	@SuppressWarnings("deprecation")
	public RailroadViewPreferences() {
		preferenceStore = new ScopedPreferenceStore(new ConfigurationScope(), "Xtext Grammar View");
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
