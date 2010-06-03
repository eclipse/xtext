/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

/**
 * Abstract super class of all scope providers that are capable of creating {@link IResourceDescription}s for
 * {@link Resource}s.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractExportedObjectsAwareScopeProvider extends AbstractScopeProvider {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	public IResourceServiceProvider.Registry getResourceServiceProviderRegistry() {
		return resourceServiceProviderRegistry;
	}

	public void setResourceServiceProviderRegistry(IResourceServiceProvider.Registry resourceDescriptionManagerRegistry) {
		this.resourceServiceProviderRegistry = resourceDescriptionManagerRegistry;
	}

	protected IResourceDescription getResourceDescription(Resource resource) {
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
