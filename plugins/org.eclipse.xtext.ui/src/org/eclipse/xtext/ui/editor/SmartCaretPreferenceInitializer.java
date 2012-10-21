/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.4
 */
public class SmartCaretPreferenceInitializer implements IPreferenceStoreInitializer {

	public void initialize(IPreferenceStoreAccess access) {
		access.getWritablePreferenceStore().setDefault(PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION, true);
	}

}
