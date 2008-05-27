/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.xtext.parser.ITokenTypes;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextDefaultsInitializer {
	public static void initializeDefaults(IPreferenceStore preferenceStore) {
		preferenceStore.setDefault(XtextPreferenceConstants.getTokenColorPreferenceKey(ITokenTypes.ANYOTHER),
				StringConverter.asString(XtextPreferenceConstants.DEFAULT_COLOR));
		preferenceStore.setDefault(XtextPreferenceConstants.getTokenColorPreferenceKey(ITokenTypes.COMMENT),
				StringConverter.asString(XtextPreferenceConstants.COMMENT_COLOR));
		preferenceStore.setDefault(XtextPreferenceConstants.getTokenColorPreferenceKey(ITokenTypes.KEYWORD),
				StringConverter.asString(XtextPreferenceConstants.KEYWORD_COLOR));
		preferenceStore.setDefault(XtextPreferenceConstants.getTokenColorPreferenceKey(ITokenTypes.STRINGLITERAL),
				StringConverter.asString(XtextPreferenceConstants.STRING_COLOR));
		// Style
		preferenceStore.setDefault(XtextPreferenceConstants.getTokenStylePreferenceKey(ITokenTypes.KEYWORD),
				StringConverter.asString(XtextPreferenceConstants.KEYWORD_STYLE));
	}
}
