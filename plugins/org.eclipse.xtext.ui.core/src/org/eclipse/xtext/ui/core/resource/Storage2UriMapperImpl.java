/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.resource;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Storage2UriMapperImpl implements IStorage2UriMapper {

	public Iterable<IStorage> getStorages(URI uri) {
		if (uri.isPlatformResource()) {
			Path path = new Path(uri.toPlatformString(true));
			IFile file = getWorkspaceRoot().getFile(path);
			return Collections.singleton((IStorage)file);
		}
		return Iterables.emptyIterable();
	}

	protected IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	public URI getUri(IStorage storage) {
		if (storage instanceof IFile) {
			return URI.createPlatformResourceURI(storage.getFullPath().toString(), true);
		}
		return null;
	}
	
	private ResourceSet resourceSet;

	@Inject
	public void setResourceSet(ResourceSet resourceSet) {
		removeDefaultFactories(resourceSet);
		this.resourceSet = resourceSet;
	}
	
	protected boolean isValidUri(URI uri) {
		return (resourceSet.getResourceFactoryRegistry().getFactory(uri) != null);
	}

	protected void removeDefaultFactories(final ResourceSet resourceSet) {
		Resource.Factory.Registry copy = new ResourceFactoryRegistryImpl() {
			@Override
			protected URIConverter getURIConverter() {
				return resourceSet.getURIConverter();
			}

			@Override
			protected Map<?, ?> getContentDescriptionOptions() {
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
}
