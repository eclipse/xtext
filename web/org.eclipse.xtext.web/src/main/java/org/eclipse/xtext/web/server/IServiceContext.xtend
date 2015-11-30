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
interface IServiceContext {
	
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
	 * Returns a session into which information can be stored across multiple requests from
	 * the same client. If a session does not exist yet, one is created.
	 * 
	 * <p><em>Warning:</em> This method may have side effects on the response sent to the client,
	 * such as adding a session Id.</p>
	 */
	def ISession getSession()
	
}