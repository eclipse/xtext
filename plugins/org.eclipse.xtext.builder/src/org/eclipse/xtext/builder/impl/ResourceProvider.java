/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Map;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;

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
		removeDefaultFactories(resourceSet);
		if (resourceSet.getResourceFactoryRegistry().getFactory(uri) == null)
			return null;
		return resourceSet.getResource(uri, true);
	}
	
	protected void removeDefaultFactories(final ResourceSet resourceSet) {
		
		Resource.Factory.Registry copy = new ResourceFactoryRegistryImpl()
        {
	          @Override
	          protected URIConverter getURIConverter()
	          {
	            return resourceSet.getURIConverter();
	          }

	          @Override
	          protected Map<?, ?> getContentDescriptionOptions()
	          {
	            return resourceSet.getLoadOptions();
	          }
	        };
		copy.getProtocolToFactoryMap().putAll(Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap());
		copy.getExtensionToFactoryMap().putAll(Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap());
		copy.getContentTypeToFactoryMap().putAll(Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap());
		
		copy.getExtensionToFactoryMap().remove(Resource.Factory.Registry.DEFAULT_EXTENSION);
		copy.getContentTypeToFactoryMap().remove(Resource.Factory.Registry.DEFAULT_CONTENT_TYPE_IDENTIFIER);
		
		resourceSet.setResourceFactoryRegistry(copy);
	}

	public URI getURI(IStorage resource) {
		if (resource == null)
			throw new NullPointerException("resource");
		return URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
	}
}
