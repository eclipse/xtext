/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.refactoring;

import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendRefactoringPreferences extends RefactoringPreferences {
	
	public static class Initializer implements IPreferenceStoreInitializer {
		@Override
		public void initialize(IPreferenceStoreAccess access) {
			access.getWritablePreferenceStore().setDefault(SAVE_ALL_BEFORE_REFACTORING, true);
			access.getWritablePreferenceStore().setDefault(USE_INLINE_REFACTORING, true);
		}
	}
}
