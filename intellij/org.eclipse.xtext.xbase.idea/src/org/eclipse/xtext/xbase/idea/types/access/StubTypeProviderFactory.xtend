/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.types.access

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory
import org.eclipse.xtext.idea.resource.ProjectAdapter
import org.eclipse.xtext.psi.IPsiModelAssociator

class StubTypeProviderFactory extends AbstractTypeProviderFactory {
	
	@Inject
	IPsiModelAssociator psiModelAssociator
	
	override createTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.")
		val project = ProjectAdapter.getProject(resourceSet)
		if (project == null)
			throw new IllegalArgumentException("project may not be null.")
		new StubJvmTypeProvider(project, resourceSet, indexedJvmTypeAccess, services, psiModelAssociator)
	}
	
}