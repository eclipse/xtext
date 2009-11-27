/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceSetBasedContainer extends AbstractContainer {

	private final ResourceSet resourceSet;
	private final IResourceDescription.Manager.Registry descriptionManagerRegistry;

	public ResourceSetBasedContainer(ResourceSet resourceSet, IResourceDescription.Manager.Registry descriptionManagerRegistry) {
		this.resourceSet = resourceSet;
		this.descriptionManagerRegistry = descriptionManagerRegistry;
	}
	
	public IResourceDescription getResourceDescription(URI uri) {
		Resource resource = resourceSet.getResource(uri, false);
		if (resource == null)
			return null;
		return getDescriptionFor(resource);
	}

	public Iterable<IResourceDescription> getResourceDescriptions() {
		return Iterables.filter(Iterables.transform(resourceSet.getResources(), new Function<Resource, IResourceDescription>() {
			public IResourceDescription apply(Resource resource) {
				return getDescriptionFor(resource);
			}
		}), Predicates.notNull());
	}
	
	protected IResourceDescription getDescriptionFor(Resource resource) {
		IResourceDescription.Manager descriptionManager = descriptionManagerRegistry.getResourceDescriptionManager(resource.getURI(), null);
		if (descriptionManager == null)
			return null;
		return descriptionManager.getResourceDescription(resource);
	}

}
