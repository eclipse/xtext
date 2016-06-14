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
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;

/**
 * @author Sven Efftinge
 */
class ProtocolResourceServiceProviderRegistryReader extends AbstractRegistryReader {

	private final static Logger log = Logger.getLogger(ProtocolResourceServiceProviderRegistryReader.class);
	
	@Override
	protected String getKeyAttribute() {
		return "protocolName";
	}

	@Override
	protected Map<String, Object> getMap() {
		return ((ResourceServiceProviderRegistryImpl) IResourceServiceProvider.Registry.INSTANCE)
				.getProtocolToFactoryMap();
	}

	public ProtocolResourceServiceProviderRegistryReader(IExtensionRegistry extensionRegistry, String symbolicBundleName) {
		super(extensionRegistry, symbolicBundleName, "protocol_resourceServiceProvider");
	}
	
	protected String getDeprecatedKeyAttribute() {
		return "protocol";
	}
	
	@Override
	protected String getValueForKeyAttribute(IConfigurationElement element) {
		String result = super.getValueForKeyAttribute(element);
		if (result == null) {
			result = element.getAttribute(getDeprecatedKeyAttribute());
			if (result != null) {
				log.warn("Attribute name '" + getDeprecatedKeyAttribute()+ "' is deprecated for extension point 'resourceServiceProvider'. " +
						"Use '" + getKeyAttribute() + "' instead.");
			}
		}
		return result;
	}
}
