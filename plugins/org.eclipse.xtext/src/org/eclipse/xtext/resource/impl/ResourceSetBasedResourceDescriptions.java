/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Iterator;
import java.util.List;

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

import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 */
public class ResourceSetBasedResourceDescriptions extends AbstractCompoundSelectable implements IResourceDescriptions.IContextAware {

	private ResourceSet resourceSet;

	@Inject
	private IResourceServiceProvider.Registry registry;

	public void setRegistry(IResourceServiceProvider.Registry registry) {
		this.registry = registry;
	}
	
	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Iterables.filter(new Iterable<IResourceDescription>() {
			public Iterator<IResourceDescription> iterator() {
				return new AbstractIterator<IResourceDescription>() {
					int index = 0;
					List<Resource> resources = resourceSet.getResources();
					@Override
					protected IResourceDescription computeNext() {
						if (resources.size() <= index)
							return endOfData();
						Resource resource = resources.get(index);
						index++;
						return getResourceDescription(resource.getURI());
					}
				};
			}
		}, Predicates.notNull());

	}
	
	@Override
	protected Iterable<? extends ISelectable> getSelectables() {
		return getAllResourceDescriptions();
	}
	
	@Override
	public boolean isEmpty() {
		return resourceSet.getResources().isEmpty();
	}
	
	/**
	 * @since 2.1
	 */
	protected boolean hasDescription(URI uri) {
		Resource resource = resourceSet.getResource(uri, false);
		return resource != null;
	}
	
	public IResourceDescription getResourceDescription(URI uri) {
		Resource resource = resourceSet.getResource(uri, false);
		if (resource == null)
			return null;
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null)
			return null;
		Manager manager = resourceServiceProvider.getResourceDescriptionManager();
		if (manager==null)
			return null;
		return manager.getResourceDescription(resource);
	}

	public void setContext(Notifier ctx) {
		this.resourceSet = EcoreUtil2.getResourceSet(ctx);
	}

}
