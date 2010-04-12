/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class DefaultResourceDescriptionManager implements IResourceDescription.Manager {

	@Inject
	private IQualifiedNameProvider nameProvider;
	
	@Inject
	private IContainer.Manager containerManager;
	
	@Inject
	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;
	
	private static final String CACHE_KEY = DefaultResourceDescriptionManager.class.getName() + "#getResourceDescription";
	
	public IResourceDescription getResourceDescription(final Resource resource) {
		return cache.get(CACHE_KEY, resource, new Provider<IResourceDescription>(){
			public IResourceDescription get() {
				return new DefaultResourceDescription(resource, nameProvider);
			}});
	}
	
	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}
	
	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}
	
	public IContainer.Manager getContainerManager() {
		return containerManager;
	}
	
	public void setContainerManager(IContainer.Manager containerManager) {
		this.containerManager = containerManager;
	}
	
	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}
	
	public IResourceScopeCache getCache() {
		return cache;
	}
	
	public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		if (!delta.haveEObjectDescriptionsChanged())
			return false;
		Set<String> names = Sets.newHashSet();
		addExportedNames(names,delta.getOld());
		addExportedNames(names,delta.getNew());
		return !Collections.disjoint(names, getImportedNames(candidate));
	}

	protected Collection<String> getImportedNames(IResourceDescription candidate) {
		return Collections2.forIterable(candidate.getImportedNames());
	}

	protected void addExportedNames(Set<String> names, IResourceDescription resourceDescriptor) {
		if (resourceDescriptor==null)
			return;
		Iterable<IEObjectDescription> iterable = resourceDescriptor.getExportedObjects();
		for (IEObjectDescription ieObjectDescription : iterable) {
			names.add(ieObjectDescription.getName());
		}
	}

}
