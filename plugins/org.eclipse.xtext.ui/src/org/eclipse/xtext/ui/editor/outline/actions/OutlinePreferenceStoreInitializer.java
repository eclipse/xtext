/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.outline.actions;

import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;

/**
 * @author koehnlein - Initial contribution and API
 */
public class OutlinePreferenceStoreInitializer implements IPreferenceStoreInitializer {

	public void initialize(IPreferenceStoreAccess access) {
		access.getWritablePreferenceStore().setDefault(ToggleLinkWithEditorAction.PREFERENCE_KEY, false);
		access.getWritablePreferenceStore().setDefault(ToggleSortingAction.PREFERENCE_KEY, false);
	}
}
