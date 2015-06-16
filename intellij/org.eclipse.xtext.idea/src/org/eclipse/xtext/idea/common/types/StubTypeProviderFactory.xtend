/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.common.types

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory
import org.eclipse.xtext.idea.resource.IndexingAwareGlobalSearchScope
import org.eclipse.xtext.idea.resource.ModuleProvider
import org.eclipse.xtext.psi.IPsiModelAssociator
import org.eclipse.xtext.resource.XtextResourceSet

class StubTypeProviderFactory extends AbstractTypeProviderFactory {
	
	@Inject
	IPsiModelAssociator psiModelAssociator
	
	@Inject IndexingAwareGlobalSearchScope.Factory searchScopeFactory
	
	override createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet instanceof XtextResourceSet) {
			val module = ModuleProvider.findModule(resourceSet) 
			val searchScope = searchScopeFactory.createSearchScope(resourceSet)
			return new StubJvmTypeProvider(module, resourceSet, indexedJvmTypeAccess, services, psiModelAssociator, searchScope)
		}
		throw new IllegalArgumentException("resourceSet was "+resourceSet)
	}
	
}
