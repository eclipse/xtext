/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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