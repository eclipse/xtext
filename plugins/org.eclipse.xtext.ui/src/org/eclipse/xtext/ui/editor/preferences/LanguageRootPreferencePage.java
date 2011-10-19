/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.google.inject.Inject;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class LanguageRootPreferencePage extends AbstractPreferencePage {

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;
	
	@Override
	protected void createFieldEditors() {
	}

	/**
	 * @since 2.1
	 */
	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		return preferenceStoreAccess.getWritablePreferenceStore();
	}
}
