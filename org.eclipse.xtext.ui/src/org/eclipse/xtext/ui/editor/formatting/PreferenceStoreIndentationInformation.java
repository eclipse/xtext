/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.formatting;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Knut Wannheden
 */
@Singleton
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
		return storeAccess.getPreferenceStore().getBoolean(
				AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SPACES_FOR_TABS);
	}

	// note: the maximum length allowed in the eclipse preferences dialog is 16
	private final String WS = "                                     ";

	private String indentString = null;

	@Override
	public synchronized String getIndentString() {
		if (indentString == null) {
			indentString = isSpacesForTab() ? WS.substring(0, Math.min(getTabWidth(), WS.length())) : "\t";
		}
		return indentString;
	}

	@Override
	public synchronized void propertyChange(PropertyChangeEvent event) {
		String property = event.getProperty();
		if (AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH.equals(property)
				|| AbstractDecoratedTextEditorPreferenceConstants.EDITOR_SPACES_FOR_TABS.equals(property)) {
			indentString = null;
		}
	}

}
