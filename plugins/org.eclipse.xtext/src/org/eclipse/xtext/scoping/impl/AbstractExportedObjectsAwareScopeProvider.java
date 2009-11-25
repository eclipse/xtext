/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractExportedObjectsAwareScopeProvider extends AbstractScopeProvider {

	@Inject
	private IResourceDescription.Manager.Registry resourceDescriptionManagerRegistry;
	
	public IResourceDescription.Manager.Registry getResourceDescriptionManagerRegistry() {
		return resourceDescriptionManagerRegistry;
	}

	public void setResourceDescriptionProviderRegistry(IResourceDescription.Manager.Registry resourceDescriptionProviderRegistry) {
		this.resourceDescriptionManagerRegistry = resourceDescriptionProviderRegistry;
	}
	
	public Iterable<IEObjectDescription> getExportedEObjects(Resource resource) {
		IResourceDescription.Manager manager = resourceDescriptionManagerRegistry.getResourceDescriptionManager(resource.getURI(),null);
		if (manager == null)
			return Iterables.emptyIterable();
		IResourceDescription description = manager.getResourceDescription(resource);
		if (description == null)
			return Iterables.emptyIterable();
		Iterable<IEObjectDescription> result = description.getExportedObjects();
		return result;
	}
	
}
