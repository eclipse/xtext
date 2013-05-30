/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ISelectable;

import com.google.common.base.Joiner;
import com.google.inject.Inject;

/**
 * An implementation of {@link IResourceDescriptions} which indexes a given resource set the first time it is used (i.e.
 * {@link #getAllResourceDescriptions()} is called).
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class EagerResourceSetBasedResourceDescriptions extends AbstractCompoundSelectable implements
		IResourceDescriptions.IContextAware {

	private Map<URI, IResourceDescription> descriptions = null;

	private ResourceSet resourceSet;

	@Inject
	private IResourceServiceProvider.Registry registry;

	private Map<URI, IResourceDescription> getDescriptionsMap() {
		if (descriptions == null) {
			descriptions = new HashMap<URI, IResourceDescription>();
			List<Resource> list = new ArrayList<Resource>(getResourceSet().getResources());
			for (Resource resource : list) {
				IResourceDescription description = computeResourceDescription(resource.getURI());
				if (description != null) {
					descriptions.put(resource.getURI(), description);
				}
			}
		}
		return descriptions;
	}

	private IResourceDescription computeResourceDescription(URI uri) {
		Resource resource = resourceSet.getResource(uri, false);
		if (resource == null)
			return null;
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null)
			return null;
		Manager manager = resourceServiceProvider.getResourceDescriptionManager();
		if (manager == null)
			return null;
		return manager.getResourceDescription(resource);
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Collections.unmodifiableCollection(getDescriptionsMap().values());
	}

	public void setRegistry(IResourceServiceProvider.Registry registry) {
		this.registry = registry;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	@Override
	protected Iterable<? extends ISelectable> getSelectables() {
		return getAllResourceDescriptions();
	}

	@Override
	public boolean isEmpty() {
		return getDescriptionsMap().isEmpty();
	}

	/**
	 * @since 2.1
	 */
	protected boolean hasDescription(URI uri) {
		return getDescriptionsMap().containsKey(uri);
	}

	public void setContext(Notifier ctx) {
		this.resourceSet = EcoreUtil2.getResourceSet(ctx);
	}

	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + "\n  " + Joiner.on("\n  ").join(getAllResourceDescriptions()) + "\n]";
	}

	public IResourceDescription getResourceDescription(URI uri) {
		return getDescriptionsMap().get(uri);
	}
}
