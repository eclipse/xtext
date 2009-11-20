/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class ResourceProvider {
	
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	
	public void setResourceSetProvider(Provider<ResourceSet> resourceSetProvider) {
		this.resourceSetProvider = resourceSetProvider;
	}
	
	public Resource getResource(IStorage storage) {
		URI uri = getURI(storage);
		if (uri==null)
			return null;
		ResourceSet resourceSet = resourceSetProvider.get();
		return resourceSet.getResource(uri, true);
	}
	
	public URI getURI(IStorage resource) {
		if (resource == null)
			throw new NullPointerException("resource");
		return URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
	}
}
