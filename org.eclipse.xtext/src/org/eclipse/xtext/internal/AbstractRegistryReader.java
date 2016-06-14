/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.internal;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.emf.ecore.plugin.RegistryReader;

/**
 * @author Sven Efftinge
 */
abstract class AbstractRegistryReader extends RegistryReader {

	public AbstractRegistryReader(IExtensionRegistry pluginRegistry, String pluginID, String extensionPointID) {
		super(pluginRegistry, pluginID, extensionPointID);
	}
	
	private final Logger log = Logger.getLogger(getClass());
	
	static final String ATT_CLASS = "class";
	
	protected abstract String getKeyAttribute();

	@Override
	protected boolean readElement(IConfigurationElement element, boolean add) {
		if (element.getName().equals("resourceServiceProvider")) {
			String contentTypeIdentifier = getValueForKeyAttribute(element);
			if (contentTypeIdentifier == null) {
				logMissingAttribute(element, getKeyAttribute());
			} else if (element.getAttribute(ATT_CLASS) == null) {
				logMissingAttribute(element, ATT_CLASS);
			} else if (add) {
				Object previous = getMap().put(
						contentTypeIdentifier, new ResourceServiceProviderDescriptor(element, ATT_CLASS));
				if (previous instanceof ResourceServiceProviderDescriptor) {
					ResourceServiceProviderDescriptor descriptor = (ResourceServiceProviderDescriptor) previous;
					log.warn("Both '" + descriptor.getElement().getContributor().getName() + "' and '"
							+ element.getContributor().getName() + "' register a content parser for '"
							+ contentTypeIdentifier + "'");
				}
				return true;
			} else {
				getMap().remove(contentTypeIdentifier);
				return true;
			}
		}
		return false;
	}

	protected String getValueForKeyAttribute(IConfigurationElement element) {
		return element.getAttribute(getKeyAttribute());
	}

	protected abstract Map<String, Object> getMap();

	@Override
	protected void logError(IConfigurationElement element, String text) {
		IExtension extension = element.getDeclaringExtension();
		log.error("Plugin " + extension.getContributor().getName() + ", extension "
				+ extension.getExtensionPointUniqueIdentifier());
		log.error(text);
	}
	
}
