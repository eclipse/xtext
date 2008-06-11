/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.service.ILanguageDescriptor;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public class XtextDocumentProviderFactory {
	
	private static XtextDocumentProviderFactory instance;
	
	private Map<ILanguageDescriptor, XtextDocumentProvider> documentProviders = new HashMap<ILanguageDescriptor, XtextDocumentProvider>();

	private XtextDocumentProviderFactory() {
	}
	
	public static XtextDocumentProviderFactory getInstance() {
		if (instance == null) {
			instance = new XtextDocumentProviderFactory();
		}
		return instance;
	}
	
	public XtextDocumentProvider getDocumentProvider(ILanguageDescriptor languageDescriptor) {
		XtextDocumentProvider documentProvider = documentProviders.get(languageDescriptor);
		if (documentProvider == null) {
			documentProvider = new XtextDocumentProvider(languageDescriptor);
			documentProviders.put(languageDescriptor, documentProvider);
		}
		return documentProvider;
	}

}
