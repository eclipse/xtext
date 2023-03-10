/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.editor;

import org.eclipse.jdt.ui.PreferenceConstants;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FoldingPreferences {

	public boolean isEnabled() {
		return getBoolean(PreferenceConstants.EDITOR_FOLDING_ENABLED).booleanValue();
	}

	public boolean isFoldImports() {
		return getBoolean(PreferenceConstants.EDITOR_FOLDING_IMPORTS).booleanValue();
	}

	public boolean isFoldHeader() {
		return getBoolean(PreferenceConstants.EDITOR_FOLDING_HEADERS).booleanValue();
	}

	public boolean isFoldInnerTypes() {
		return getBoolean(PreferenceConstants.EDITOR_FOLDING_INNERTYPES).booleanValue();
	}

	public boolean isFoldMethods() {
		return getBoolean(PreferenceConstants.EDITOR_FOLDING_METHODS).booleanValue();
	}

	public boolean isFoldComments() {
		return getBoolean(PreferenceConstants.EDITOR_FOLDING_JAVADOC).booleanValue();
	}

	protected Boolean getBoolean(String string) {
		return Boolean.valueOf(PreferenceConstants.getPreference(string, null));
	}
}
