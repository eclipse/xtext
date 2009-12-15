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
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.util.SimpleCache;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class Storage2UriMapperImpl implements IStorage2UriMapper, IResourceChangeListener {

	private ResourceFactoryRegistryImpl resourceFactoryRegistry;

	public Storage2UriMapperImpl() {
		ResourcesPlugin.getWorkspace().addResourceChangeListener(this);
		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceFactoryRegistry = new ResourceFactoryRegistryImpl() {
			@Override
			protected URIConverter getURIConverter() {
				return resourceSet.getURIConverter();
			}

			@Override
			protected Map<?, ?> getContentDescriptionOptions() {
				return resourceSet.getLoadOptions();
			}
		};
		resourceFactoryRegistry.getProtocolToFactoryMap().putAll(
				Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap());
		resourceFactoryRegistry.getExtensionToFactoryMap().putAll(
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap());
		resourceFactoryRegistry.getContentTypeToFactoryMap().putAll(
				Resource.Factory.Registry.INSTANCE.getContentTypeToFactoryMap());

		resourceFactoryRegistry.getExtensionToFactoryMap().remove(Resource.Factory.Registry.DEFAULT_EXTENSION);
		resourceFactoryRegistry.getContentTypeToFactoryMap().remove(
				Resource.Factory.Registry.DEFAULT_CONTENT_TYPE_IDENTIFIER);

		resourceSet.setResourceFactoryRegistry(resourceFactoryRegistry);
	}

	public Iterable<IStorage> getStorages(URI uri) {
		synchronized (cache) {
			return cache.get(uri);
		}
	}

	protected IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	public final URI getUri(IStorage storage) {
		URI uri = internalGetUri(storage);
		if (uri!=null && isValidUri(uri))
			return uri;
		return null;
	}

	protected URI internalGetUri(IStorage storage) {
		if (storage instanceof IFile) {
			return URI.createPlatformResourceURI(storage.getFullPath().toString(), true);
		}
		return null;
	}

	protected boolean isValidUri(URI uri) {
		return uri!=null && (resourceFactoryRegistry.getFactory(uri) != null);
	}
	
	
	private final SimpleCache<URI, Iterable<IStorage>> cache = new SimpleCache<URI, Iterable<IStorage>>(new Function<URI, Iterable<IStorage>>() {
		public Iterable<IStorage> apply(URI uri) {
			if (uri.isPlatformResource()) {
				Path path = new Path(uri.toPlatformString(true));
				IFile file = getWorkspaceRoot().getFile(path);
				return Collections.singleton((IStorage) file);
			}
			return Iterables.emptyIterable();
		}
	});

	public void resourceChanged(IResourceChangeEvent event) {
		synchronized (cache) {
			cache.clear();
		}
	}

}
