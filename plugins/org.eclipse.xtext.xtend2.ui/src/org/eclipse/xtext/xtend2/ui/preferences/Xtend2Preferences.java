/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.preferences;

import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2Preferences {

	public static class Initializer implements IPreferenceStoreInitializer {
		public void initialize(IPreferenceStoreAccess access) {
			access.getWritablePreferenceStore().setDefault(ENABLE_RENAME_REFACTORING, true);
		}
	}

	public static final String ENABLE_RENAME_REFACTORING = "enableRenameRefactoring";

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;


	public boolean isRefactoringEnabled() {
		return preferenceStoreAccess.getPreferenceStore().getBoolean(ENABLE_RENAME_REFACTORING);
	}

}
