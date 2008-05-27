/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.language;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.preferences.ScopedPreferenceStore;
import org.eclipse.xtext.ui.core.internal.Activator;
import org.eclipse.xtext.ui.core.internal.CoreLog;
import org.eclipse.xtext.ui.core.service.ISyntaxColorer;

/**
 * @author Peter Friese - Initial contribution and API
 * 
 */
public class LanguageServiceFactory {

	private static final String LANGUAGE_ID = "languageId";
	private static final String CLASS = "class";

	private static final String SYNTAXCOLORER = "syntaxColorer";
	private static LanguageServiceFactory instance;
	private static Map<String, IPreferenceStore> preferenceStoreCache = new HashMap<String, IPreferenceStore>();

	private LanguageServiceFactory() {
	}

	public static final LanguageServiceFactory getInstance() {
		if (instance == null) {
			instance = new LanguageServiceFactory();
		}
		return instance;
	}

	public ISyntaxColorer getSyntaxColorer(LanguageDescriptor language) {
		return (ISyntaxColorer) loadService(language, SYNTAXCOLORER);
	}

	private ILanguageService loadService(LanguageDescriptor languageDescriptor, String serviceName) {
		if (languageDescriptor == null) {
			throw new IllegalArgumentException("languageDescriptor must not be null");
		}
		return createServiceExtension(languageDescriptor, serviceName);
	}

	private ILanguageService createServiceExtension(LanguageDescriptor languageDescriptor, String serviceName) {
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(Activator.PLUGIN_ID,
				serviceName);
		if (extensionPoint == null) {
			return null;
		}
		IConfigurationElement[] configurationElements = extensionPoint.getConfigurationElements();
		for (IConfigurationElement configurationElement : configurationElements) {
			try {
				String languageId = configurationElement.getAttribute(LANGUAGE_ID);
				if (languageDescriptor.getId().equals(languageId)) {
					ILanguageService service = (org.eclipse.xtext.ui.core.language.ILanguageService) configurationElement
							.createExecutableExtension(CLASS);
					service.setLanguageDescriptor(languageDescriptor);
					return service;
				}
			}
			catch (CoreException e) {
				CoreLog.log(e.getStatus());
			}
		}
		return null;
	}

	public IPreferenceStore getPreferenceStore(LanguageDescriptor languageDescriptor) {
		IPreferenceStore preferenceStore = preferenceStoreCache.get(languageDescriptor.getNameSpace());
		if (preferenceStore == null) {
			preferenceStore = new ScopedPreferenceStore(new InstanceScope(), languageDescriptor.getNameSpace());
			preferenceStoreCache.put(languageDescriptor.getNameSpace(), preferenceStore);
		}
		return preferenceStore;
	}

}
