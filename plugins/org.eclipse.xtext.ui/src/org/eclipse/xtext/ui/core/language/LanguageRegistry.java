/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.language;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.core.internal.Activator;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class LanguageRegistry {
	private static final String LANGUAGE_DESCRIPTOR = "languageDescriptor";
	private static Set<LanguageDescriptor> languages;

	public static Set<LanguageDescriptor> findAllLanguages() {
		if (languages == null) {
			init();
		}
		return languages;
	}

	public static LanguageDescriptor getLanguageDescriptor(String fileExtenion) {
		Assert.isNotNull(fileExtenion, "File extension can't be null");
		for (LanguageDescriptor languageDescriptor : findAllLanguages()) {
			String[] fileExtensions = languageDescriptor.getFileExtensions();
			if (fileExtensions != null) {
				for (int i = 0; i < fileExtensions.length; i++) {
					if (fileExtenion.equals(fileExtensions[i])) {
						return languageDescriptor;
					}
				}
			}
		}
		return null;
	}

	private static void init() {
		languages = new HashSet<LanguageDescriptor>();
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
				.getExtensionPoint(Activator.PLUGIN_ID, LANGUAGE_DESCRIPTOR);
		Assert.isNotNull(extensionPoint);
		IConfigurationElement[] elements = extensionPoint
				.getConfigurationElements();
		if (elements != null) {
			for (IConfigurationElement element : elements) {
				LanguageDescriptor langDescr = new LanguageDescriptor(element);
				langDescr.setFileExtensions(new String[]{"test","tst"});
				register(langDescr);
			}
		}
	}

	private static void register(LanguageDescriptor langDescr) {
		languages.add(langDescr);
	}

}
