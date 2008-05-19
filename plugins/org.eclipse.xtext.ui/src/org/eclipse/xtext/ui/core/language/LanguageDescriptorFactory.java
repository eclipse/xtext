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

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.core.internal.Activator;
import org.eclipse.xtext.ui.core.internal.CoreLog;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class LanguageDescriptorFactory {
	private static final String LANGUAGE_DESCRIPTOR = "languageDescriptor";

	private static Map<String, LanguageDescriptor> registry = new HashMap<String, LanguageDescriptor>();

	/**
	 * Initializes LanguageDescriptor for a given name space and stores it in
	 * the <br>
	 * internal register for reusing
	 * 
	 * @param namespace
	 * @return LanguageDescriptor for given namespace or null if not declared
	 */
	public static LanguageDescriptor createLanguageDescriptor(String namespace) {
		Assert.isNotNull(namespace,
				"Namespace is required for LanguageDescriptor creation");
		LanguageDescriptor langDescr = null;
		if (registry.containsKey(namespace)) {
			langDescr = registry.get(namespace);
		} else {
			langDescr = buildLanguageDescriptor(namespace);
			registry.put(namespace, langDescr);
		}
		return langDescr;
	}

	private static LanguageDescriptor buildLanguageDescriptor(String namespace) {
		LanguageDescriptor retVal = null;
		IExtensionPoint extensionPoint = Platform.getExtensionRegistry()
				.getExtensionPoint(Activator.PLUGIN_ID, LANGUAGE_DESCRIPTOR);
		Assert.isNotNull(extensionPoint, "Extension point "
				+ LANGUAGE_DESCRIPTOR + " not defined!");
		IConfigurationElement[] elements = extensionPoint
				.getConfigurationElements();
		if (elements != null) {
			for (IConfigurationElement element : elements) {
				if (namespace.equals(element.getNamespaceIdentifier())) {
					if (retVal != null) {
						logMoreThanOneLanguageWarning(namespace, retVal);
						break;
					}
					retVal = new LanguageDescriptor(element);
				}
			}
		}
		return retVal;
	}

	private static void logMoreThanOneLanguageWarning(String namespace,
			LanguageDescriptor retVal) {
		CoreLog
				.logWarning("There are more than one language descriptor defined for plugin with namespace '"
						+ namespace
						+ "'. Language descriptor named '"
						+ retVal.getName()
						+ "' with id '"
						+ retVal.getId()
						+ "' will be used.");
	}
}
