/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Manager;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceSetBasedResourceDescriptions implements IResourceDescriptions, IResourceDescriptions.IContextAware {

	private ResourceSet resourceSet;

	@Inject
	private IResourceDescription.Manager.Registry registry;

	public void setRegistry(IResourceDescription.Manager.Registry registry) {
		this.registry = registry;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Iterables.transform(resourceSet.getResources(), new Function<Resource, IResourceDescription>() {
			public IResourceDescription apply(Resource from) {
				return getResourceDescription(from.getURI());
			}
		});
	}

	public IResourceDescription getResourceDescription(URI uri) {
		Resource resource = resourceSet.getResource(uri, false);
		if (resource == null)
			return null;
		Manager manager = registry.getResourceDescriptionManager(uri, null);
		return manager.getResourceDescription(resource);
	}

	public void setContext(Notifier ctx) {
		this.resourceSet = EcoreUtil2.getResourceSet(ctx);
	}

	public void addListener(IResourceDescription.Event.Listener listener) {
		throw new UnsupportedOperationException();
	}

	public void removeListener(IResourceDescription.Event.Listener listener) {
		throw new UnsupportedOperationException();
	}

}
