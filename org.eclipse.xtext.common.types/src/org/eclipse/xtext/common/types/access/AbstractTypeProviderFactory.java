/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeProviderFactory implements IJvmTypeProvider.Factory {

	@Inject(optional = true)
	private IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	@Inject
	private TypeResourceServices services;
	
	@Override
	public IJvmTypeProvider findTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		return (IJvmTypeProvider) resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().get(URIHelperConstants.PROTOCOL);
	}

	@Override
	public IJvmTypeProvider createTypeProvider() {
		return createTypeProvider(new ResourceSetImpl());
	}
	
	@Override
	public IJvmTypeProvider findOrCreateTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		IJvmTypeProvider result = findTypeProvider(resourceSet);
		if (result != null)
			return result;
		return createTypeProvider(resourceSet);
	}
	
	protected IndexedJvmTypeAccess getIndexedJvmTypeAccess() {
		return indexedJvmTypeAccess;
	}

	protected TypeResourceServices getServices() {
		return services;
	}
}
