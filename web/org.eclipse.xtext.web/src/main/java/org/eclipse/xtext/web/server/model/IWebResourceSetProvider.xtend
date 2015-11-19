/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.model

import com.google.inject.ImplementedBy
import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.web.server.IServiceContext

/**
 * Provider for resource set instances.
 */
@ImplementedBy(DefaultImpl)
interface IWebResourceSetProvider {
	
	/**
	 * Provides a resource set. The resourceId may be {@code null}, which means that the
	 * request should be processed in stateless mode. Fetching the session from the service
	 * context should be avoided in this case.
	 */
	def ResourceSet get(String resourceId, IServiceContext serviceContext)
	
	/**
	 * The default implementation creates a new resource set for each resource.
	 */
	class DefaultImpl implements IWebResourceSetProvider {
		
		@Inject Provider<ResourceSet> provider
		
		override get(String resourceId, IServiceContext serviceContext) {
			provider.get
		}
		
	}
	
}