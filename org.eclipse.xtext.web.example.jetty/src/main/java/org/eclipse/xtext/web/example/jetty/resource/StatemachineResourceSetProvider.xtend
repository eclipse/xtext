/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty.resource

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.web.server.IServiceContext
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider

/**
 * Resources that run in multi-resource mode share the same resource set.
 */
class StatemachineResourceSetProvider implements IWebResourceSetProvider {
	
	static val MULTI_RESOURCE_PREFIX = 'multi-resource'
		
	@Inject Provider<ResourceSet> provider
	
	override get(String resourceId, IServiceContext serviceContext) {
		if (resourceId !== null && resourceId.startsWith(MULTI_RESOURCE_PREFIX)) {
			val pathEnd = Math.max(resourceId.indexOf('/'), MULTI_RESOURCE_PREFIX.length)
			return serviceContext.session.get(ResourceSet -> resourceId.substring(0, pathEnd), [provider.get])
		} else
			return provider.get
	}
	
}