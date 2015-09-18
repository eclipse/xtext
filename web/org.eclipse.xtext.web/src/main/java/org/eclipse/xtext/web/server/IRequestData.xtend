/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server

import java.util.Set

/**
 * Provides the parameters and meta data of a service request.
 */
interface IRequestData {
	
	/**
	 * Key for the service type parameter, which determines the actual service to be invoked.
	 */
	val SERVICE_TYPE = 'serviceType'
	
	/**
	 * The available keys that can be used as arguments to {@link #getParameter(String)}.
	 */
	def Set<String> getParameterKeys()
	
	/**
	 * Returns the request parameter for the given key.
	 */
	def String getParameter(String key)
	
	/**
	 * The available keys that can be used as arguments to {@link #getMetadata(String)}.
	 * The returned collection contains all keys that are supported by this implementation,
	 * but the actual values for some of these keys may be {@code null} because it might
	 * be too expensive to determine the non-null metadata upfront.
	 */
	def Set<String> getMetadataKeys()
	
	/**
	 * Returns the request metadata for the given key.
	 */
	def String getMetadata(String key)
	
}