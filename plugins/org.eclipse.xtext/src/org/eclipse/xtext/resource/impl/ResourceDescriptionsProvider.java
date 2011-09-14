/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceDescriptionsProvider {

	public static final String NAMED_BUILDER_SCOPE = "org.eclipse.xtext.scoping.namespaces.DefaultGlobalScopeProvider.BUILDER_SCOPE";

	public static final String LIVE_SCOPE = "org.eclipse.xtext.scoping.LIVE_SCOPE";

	@Inject
	@Named(NAMED_BUILDER_SCOPE)
	private Provider<IResourceDescriptions> builderScopeResourceDescriptions;

	@Inject
	@Named(LIVE_SCOPE)
	private Provider<IResourceDescriptions> liveScopeResourceDescriptions;

	@Inject
	private Provider<IResourceDescriptions> resourceDescriptions;
	
	public IResourceDescriptions getResourceDescriptions(Resource resource) {
		return getResourceDescriptions(resource.getResourceSet());
	}
	
	/**
	 * @since 2.1
	 */
	public IResourceDescriptions getResourceDescriptions(ResourceSet resourceSet) {
		Map<Object, Object> loadOptions = resourceSet.getLoadOptions();
		IResourceDescriptions result = createResourceDescriptions();
		if (loadOptions.containsKey(NAMED_BUILDER_SCOPE)) {
			result = createBuilderScopeResourceDescriptions();
		}
		if (loadOptions.containsKey(LIVE_SCOPE)) {
			result = createLiveScopeResourceDescriptions();
		}
		if (result instanceof IResourceDescriptions.IContextAware) {
			((IResourceDescriptions.IContextAware) result).setContext(resourceSet);
		}
		return result;
	}

	public IResourceDescriptions createLiveScopeResourceDescriptions() {
		return liveScopeResourceDescriptions.get();
	}
	
	public IResourceDescriptions createBuilderScopeResourceDescriptions() {
		return builderScopeResourceDescriptions.get();
	}
	
	public IResourceDescriptions createResourceDescriptions() {
		return resourceDescriptions.get();
	}
	
	public void setBuilderScopeResourceDescriptions(Provider<IResourceDescriptions> resourceDescriptions) {
		this.builderScopeResourceDescriptions = resourceDescriptions;
	}

	public void setResourceDescriptions(Provider<IResourceDescriptions> resourceDescriptions) {
		this.resourceDescriptions = resourceDescriptions;
	}
}
