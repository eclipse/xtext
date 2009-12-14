/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.internal;

import java.util.Map;

import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;

/**
 * @author Sven Efftinge
 */
class ProtocolResourceServiceProviderRegistryReader extends AbstractRegistryReader {

	@Override
	protected String getKeyAttribute() {
		return "protocol";
	}

	@Override
	protected Map<String, Object> getMap() {
		return ((ResourceServiceProviderRegistryImpl) IResourceServiceProvider.Registry.INSTANCE)
				.getProtocolToFactoryMap();
	}

	public ProtocolResourceServiceProviderRegistryReader(IExtensionRegistry extensionRegistry, String symbolicBundleName) {
		super(extensionRegistry, symbolicBundleName, "protocol_resourceServiceProvider");
	}
}
