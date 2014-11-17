package org.eclipse.xtext.idea.types.access

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