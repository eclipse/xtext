/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class GlobalResourceDescriptionProvider {
	
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	public GlobalResourceDescriptionProvider(IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
		this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
	}

	public IResourceDescription getResourceDescription(Resource resource) {
		IResourceServiceProvider resourceServiceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(resource.getURI());
		if (resourceServiceProvider == null)
			return null;
		IResourceDescription.Manager manager = resourceServiceProvider.getResourceDescriptionManager();
		if (manager == null)
			return null;
		IResourceDescription description = manager.getResourceDescription(resource);
		return description;
	}

}
