/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.xtext.ui.core.language.LanguageDescriptor;
import org.eclipse.xtext.ui.core.language.LanguageDescriptorFactory;
import org.eclipse.xtext.ui.core.language.LanguageServiceFactory;
import org.eclipse.xtext.ui.core.preferences.XtextDefaultsInitializer;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BaseTextEditor extends TextEditor {
	public static final String ID = "org.eclipse.xtext.baseEditor";

	@Override
	public void setInitializationData(IConfigurationElement cfig, String propertyName, Object data) {
		super.setInitializationData(cfig, propertyName, data);
		LanguageDescriptor languageDescriptor = initializeLanguageDescriptor();
		XtextModelManager manager = new XtextModelManager(languageDescriptor);

		IPreferenceStore preferenceStore = LanguageServiceFactory.getInstance().getPreferenceStore(languageDescriptor);
		XtextDefaultsInitializer.initializeDefaults(preferenceStore);
		ChainedPreferenceStore chainedPreferenceStore = new ChainedPreferenceStore(new IPreferenceStore[] {
				getPreferenceStore(), preferenceStore });

		setSourceViewerConfiguration(new XtextSourceViewerConfiguration(manager, chainedPreferenceStore, this));
		setDocumentProvider(new TextFileDocumentProvider());
	}

	private LanguageDescriptor initializeLanguageDescriptor() {
		String namespace = this.getConfigurationElement().getNamespaceIdentifier();
		LanguageDescriptor langDescr = LanguageDescriptorFactory.createLanguageDescriptor(namespace);
		Assert.isNotNull(langDescr, "LanguageDescriptor is not provided for " + namespace + " plugin");
		return langDescr;
	}
}
