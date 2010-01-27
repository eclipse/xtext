/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceServiceProviderRegistryImpl;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.ImplementedBy;

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
	}
}
