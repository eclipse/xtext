/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceServiceProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class UriValidator {
	
	@Inject
	private IResourceServiceProvider.Registry registry = IResourceServiceProvider.Registry.INSTANCE;

	public boolean isValid(URI uri, IStorage storage) {
		if (uri==null)
			return false;
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri);
		if (resourceServiceProvider!=null) {
			if (resourceServiceProvider instanceof IResourceUIServiceProvider) {
				return ((IResourceUIServiceProvider) resourceServiceProvider).canHandle(uri, storage);
			} else {
				return resourceServiceProvider.canHandle(uri);
			}
		}
		return false;
	}
	
	/**
	 * @since 2.4
	 */
	public boolean canBuild(URI uri, IStorage storage) {
		if (uri == null)
			return false;
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri);
		if (resourceServiceProvider != null) {
			if (resourceServiceProvider instanceof IResourceUIServiceProviderExtension) {
				return ((IResourceUIServiceProviderExtension) resourceServiceProvider).canBuild(uri, storage);
			} else if (resourceServiceProvider instanceof IResourceUIServiceProvider) {
				return ((IResourceUIServiceProvider) resourceServiceProvider).canHandle(uri, storage);
			} else {
				return resourceServiceProvider.canHandle(uri);
			}
		}
		return false;
	}

	/**
	 * @return whether there's possibly an {@link IResourceServiceProvider} for the given storage
	 * @since 2.4
	 */
	public boolean isPossiblyManaged(IStorage storage) {
		if (!registry.getContentTypeToFactoryMap().isEmpty())
			return true;
		String name = storage.getName();
		if (name == null) {
			return true;
		}
		name = URI.encodeSegment(name, true); 
		int index = name.lastIndexOf('.');
		if (index == -1) {
			return true;
		}
		return registry.getExtensionToFactoryMap().containsKey(name.substring(index + 1));
	}
}
