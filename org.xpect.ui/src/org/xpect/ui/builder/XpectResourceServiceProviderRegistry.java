/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.builder;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectResourceServiceProviderRegistry implements IResourceServiceProvider.Registry {

	public final static XpectResourceServiceProviderRegistry INSTANCE = new XpectResourceServiceProviderRegistry();

	protected XpectResourceServiceProviderRegistry() {
	}

	@Override
	public IResourceServiceProvider getResourceServiceProvider(URI uri, String contentType) {
		IResourceServiceProvider serviceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri, contentType);
		if (serviceProvider instanceof IResourceServiceProviderProvider)
			return ((IResourceServiceProviderProvider) serviceProvider).get(uri, contentType);
		return IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri, contentType);
	}

	@Override
	public IResourceServiceProvider getResourceServiceProvider(URI uri) {
		IResourceServiceProvider serviceProvider = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
		if (serviceProvider instanceof IResourceServiceProviderProvider)
			return ((IResourceServiceProviderProvider) serviceProvider).get(uri, null);
		return IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(uri);
	}

	@Override
	public Map<String, Object> getContentTypeToFactoryMap() {
		return IResourceServiceProvider.Registry.INSTANCE.getContentTypeToFactoryMap();
	}

	@Override
	public Map<String, Object> getExtensionToFactoryMap() {
		return IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap();
	}

	@Override
	public Map<String, Object> getProtocolToFactoryMap() {
		return IResourceServiceProvider.Registry.INSTANCE.getProtocolToFactoryMap();
	}

}
