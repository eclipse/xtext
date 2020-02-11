/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.common.annotations.Beta;
import com.google.inject.ImplementedBy;
import com.google.inject.ProvidedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(DefaultResourceServiceProvider.class)
public interface IResourceServiceProvider {

	/**
	 *@return the resource description manager for this resource service manager. Not null.
	 */
	IResourceValidator getResourceValidator();

	/**
	 *@return the resource description manager for this resource service manager.
	 */
	IResourceDescription.Manager getResourceDescriptionManager();

	/**
	 * @return the container manager for this resource service manager.
	 */
	IContainer.Manager getContainerManager();
	
	/**
	 * Tells whether the given URI can be handled by this {@link IResourceServiceProvider}
	 * @return true if the URI can be handled
	 */
	boolean canHandle(URI uri);
	
	IEncodingProvider getEncodingProvider();
	
	/**
	 * A generic way to obtain an implementation for a certain type.
	 * @return <code>null</code> if no implementation of the given type can be provided. 
	 */
	public <T> T get(Class<T> t);
	
	@ProvidedBy(Registry.RegistryProvider.class)
	interface Registry {
		/**
		 * Returns the {@link IResourceServiceProvider} appropriate for the given URI. <b>Content types are not yet
		 * supported.</b>
		 * 
		 * @param uri
		 *            the URI.
		 * @param contentType
		 *            the content type of the URI or <code>null</code> if a content type should not be used during
		 *            lookup.
		 * @return the {@link IResourceServiceProvider} appropriate for the given URI, or <code>null</code> if there
		 *         isn't one.
		 */
		IResourceServiceProvider getResourceServiceProvider(URI uri, String contentType);

		/**
		 * Returns the resource factory appropriate for the given URI.
		 * <p>
		 * An implementation will (typically) use the URI's {@link URI#scheme scheme} to search the
		 * {@link #getProtocolToFactoryMap protocol} map the URI's {@link URI#fileExtension file extension} to search
		 * {@link #getExtensionToFactoryMap extension} map, and the URI's
		 * {@link URIConverter#contentDescription(URI, Map) content type identifier} to search the
		 * {@link #getContentTypeToFactoryMap() content type} map.
		 * </p>
		 * 
		 * @param uri
		 *            the URI.
		 * @return the {@link IResourceServiceProvider} appropriate for the given URI, or <code>null</code> if there
		 *         isn't one.
		 */
		IResourceServiceProvider getResourceServiceProvider(URI uri);

		final static Registry INSTANCE = new ResourceServiceProviderRegistryImpl();

		Map<String, Object> getContentTypeToFactoryMap();

		Map<String, Object> getExtensionToFactoryMap();

		Map<String, Object> getProtocolToFactoryMap();
		
		public static class RegistryProvider implements com.google.inject.Provider<Registry> {
			@Override
			public Registry get() {
				return INSTANCE;
			}
		}
	}
	
	/**
	 * Instances of this interface can be registered in the {@link IResourceServiceProvider.Registry} or via the
	 * corresponding extension points.
	 * 
	 * Please don't use this interface as it is not guaranteed that clients of the Registry request a new
	 * ResourceServiceProvider for every URI.
	 * 
	 * @since 2.4
	 * @noextend This interface is not intended to be extended by clients.
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	@Beta
	interface Provider {
		/**
		 * @param uri
		 *            The uri that the returned ResourceServiceProvider will be responsible for.
		 * @param contentType
		 *            A contentType if one is available, null otherwise.
		 * 
		 * @return a new or an existing ResourceServiceProvider
		 */
		IResourceServiceProvider get(URI uri, String contentType);
	}
}
