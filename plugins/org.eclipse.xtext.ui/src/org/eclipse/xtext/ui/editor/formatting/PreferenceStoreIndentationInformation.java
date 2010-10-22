/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Knut Wannheden
 */
public class PreferenceStoreIndentationInformation implements IIndentationInformation, IPropertyChangeListener {

	private IPreferenceStoreAccess storeAccess;

	@Inject
	public void setPreferenceStoreAccess(IPreferenceStoreAccess storeAccess) {
		this.storeAccess = storeAccess;
		storeAccess.getPreferenceStore().addPropertyChangeListener(this);
	}

	public int getTabWidth() {
		return storeAccess.getPreferenceStore().getInt(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH);
	}

	public boolean isSpacesForTab() {
		return storeAccess.getPreferenceStore().getBoolean(AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SPACES_FOR_TABS);
	}

	private final String WS = "                                     ";

	private String indentString = null;

	public synchronized String getIndentString() {
		if (indentString == null) {
			if (isSpacesForTab()) {
				if (getTabWidth() > WS.length()) {
					indentString = WS;
				}
				indentString = WS.substring(0, getTabWidth());
			} else {
				indentString = "\t";
			}
		}
		return indentString;
	}

	public synchronized void propertyChange(PropertyChangeEvent event) {
		indentString = null;
	}

}
