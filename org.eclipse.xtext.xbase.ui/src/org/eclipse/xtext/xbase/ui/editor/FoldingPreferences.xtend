/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor

import org.eclipse.jdt.ui.PreferenceConstants

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class FoldingPreferences {
	
	def boolean isEnabled() {
		getBoolean(PreferenceConstants.EDITOR_FOLDING_ENABLED);
	}
	
	def boolean isFoldImports() {
		getBoolean(PreferenceConstants.EDITOR_FOLDING_IMPORTS);
	}
	
	def boolean isFoldHeader() {
		getBoolean(PreferenceConstants.EDITOR_FOLDING_HEADERS);
	}
	
	def boolean isFoldInnerTypes() {
		getBoolean(PreferenceConstants.EDITOR_FOLDING_INNERTYPES);
	}
	
	def boolean isFoldMethods() {
		getBoolean(PreferenceConstants.EDITOR_FOLDING_METHODS);
	}
	
	def boolean isFoldComments() {
		getBoolean(PreferenceConstants.EDITOR_FOLDING_JAVADOC);
	}
	
	protected def getBoolean(String string) {
		Boolean.valueOf(PreferenceConstants.getPreference(string, null))
	}
	
}