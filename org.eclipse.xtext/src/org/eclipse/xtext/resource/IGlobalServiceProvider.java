/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IGlobalServiceProvider.ResourceServiceProviderImpl.class)
public interface IGlobalServiceProvider {
	/**
	 * @return an instance of the demanded service class for the given {@link URI}'s language implementation, or null if no
	 *         service or language implementation could be found.
	 */
	<T> T findService(URI uri, Class<T> serviceClazz);
	
	/**
	 * @return an instance of the demanded service class for the given {@link EObject}'s language implementation, or null if no
	 *         service or language implementation could be found.
	 */
	<T> T findService(EObject eObject, Class<T> serviceClazz);
	
	public static class ResourceServiceProviderImpl implements IGlobalServiceProvider {
		
		private IResourceServiceProvider.Registry registry;
		private IResourceServiceProvider thisLanguageServiceProvider;
		
		@Inject
		public ResourceServiceProviderImpl(IResourceServiceProvider.Registry registry, IResourceServiceProvider thisLanguageServiceProvider) {
			this.registry = registry;
			this.thisLanguageServiceProvider = thisLanguageServiceProvider;
		}

		@Override
		public <T> T findService(URI uri, Class<T> serviceClazz) {
			if (thisLanguageServiceProvider.canHandle(uri))
				return thisLanguageServiceProvider.get(serviceClazz);
			IResourceServiceProvider serviceProvider = registry.getResourceServiceProvider(uri);
			if (serviceProvider==null)
				return null;
			final T result = serviceProvider.get(serviceClazz);
			return result;
		}

		@Override
		public <T> T findService(EObject eObject, Class<T> serviceClazz) {
			if (eObject.eIsProxy()) {
				return findService(((InternalEObject)eObject).eProxyURI(),serviceClazz);
			} else {
				Resource eResource = eObject.eResource();
				if(eResource != null)
					return findService(eResource.getURI(),serviceClazz);
			}
			return null;
		}
		
	}
}
