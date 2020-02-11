/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.jetty.resource;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.web.server.IServiceContext;
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider;

/**
 * Resources that run in multi-resource mode share the same resource set.
 */
public class StatemachineResourceSetProvider implements IWebResourceSetProvider {
	
	public static final String MULTI_RESOURCE_PREFIX = "multi-resource";
		
	@Inject 
	private Provider<ResourceSet> provider;
	
	@Override
	public ResourceSet get(String resourceId, IServiceContext serviceContext) {
		if (resourceId != null && resourceId.startsWith(MULTI_RESOURCE_PREFIX)) {
			int pathEnd = Math.max(resourceId.indexOf('/'), MULTI_RESOURCE_PREFIX.length());
			return serviceContext.getSession().get(Pair.of(ResourceSet.class, resourceId.substring(0, pathEnd)), ()->provider.get());
		} else
			return provider.get();
	}
	
}