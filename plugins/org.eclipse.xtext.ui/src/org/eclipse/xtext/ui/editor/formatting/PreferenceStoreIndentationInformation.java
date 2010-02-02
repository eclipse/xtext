/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting;

import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PreferenceStoreIndentationInformation implements IIndentationInformation {
	@Inject
	private IPreferenceStoreAccess storeAccess;
	
	public int getTabWidth() {
		return storeAccess.getPreferenceStore().getInt(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH);
	}
	
	public boolean isSpacesForTab() {
		return storeAccess.getPreferenceStore().getBoolean(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SPACES_FOR_TABS);
	}
	
	private final String WS = "                                     ";
	
	public String getIndentString() {
		if (isSpacesForTab()) {
			if (getTabWidth()>WS.length()) {
				return WS;
			}
			return WS.substring(0, getTabWidth());
		}
		return "\t";
	}
}
