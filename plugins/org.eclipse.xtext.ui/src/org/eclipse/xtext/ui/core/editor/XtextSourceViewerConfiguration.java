/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.xtext.ui.core.language.LanguageDescriptor;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextSourceViewerConfiguration extends
		TextSourceViewerConfiguration {
	private LanguageDescriptor languageDescriptor;

	/**
	 * @param langDescr
	 */
	public XtextSourceViewerConfiguration(IPreferenceStore preferenceStore) {
		super(preferenceStore);
	}

	/**
	 * @return
	 */
	public LanguageDescriptor getLanguageDescriptor() {
		return languageDescriptor;
	}

	public void setLanguageDescriptor(LanguageDescriptor languageDescriptor) {
		this.languageDescriptor = languageDescriptor;
	}
}
