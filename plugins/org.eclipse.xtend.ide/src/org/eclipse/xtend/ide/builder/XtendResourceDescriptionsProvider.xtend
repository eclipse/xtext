package org.eclipse.xtend.ide.builder

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtext.builder.clustering.CurrentDescriptions
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.eclipse.xtext.resource.CompilerPhases

class XtendResourceDescriptionsProvider extends ResourceDescriptionsProvider {
	
	@Inject IJavaProjectProvider projectProvider
	@Inject CompilerPhases compilerPhases
	
	/**
	 * In the builder we use the Java representation for any upstream resources, so we filter them out here.
	 * And if we are in the indexing phase, we don't even want to see the local resources.
	 */
	override getResourceDescriptions(ResourceSet resourceSet) {
		val result = super.getResourceDescriptions(resourceSet)
		switch result {
			CurrentDescriptions.ResourceSetAware : {
				switch d:result.delegate {
					CurrentDescriptions : {
						// during indexing we don't want to see any local xtend files.
						if (compilerPhases.isIndexing(resourceSet)) {
							return new IResourceDescriptions.NullImpl();
						}
						return new FilteringResourceDescriptions(result, projectProvider.getJavaProject(resourceSet))
					}
				}
			}
		}
		return result
	}
}

@Data class FilteringResourceDescriptions implements IResourceDescriptions {
	
	IResourceDescriptions delegate
	IJavaProject project
	
	override getAllResourceDescriptions() {
		delegate.allResourceDescriptions.filter[isContainedUri(URI)]
	}
	
	override getResourceDescription(URI normalizedURI) {
		if (isContainedUri(normalizedURI)) { 
			return delegate.getResourceDescription(normalizedURI);
		}
		return null
	}
	
	def private boolean isContainedUri(URI uri) {
		// we expect platform://resource URIs here, where the second segment denotes the project's name.
		if (uri == null || uri.segmentCount<2)
			return false
		return uri.segment(1) == project.project.name
	}
	
	override getExportedObjects() {
		delegate.exportedObjects.filter[isContainedUri(EObjectURI)]
	}
	
	override getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		delegate.getExportedObjects(type,name,ignoreCase).filter[isContainedUri(EObjectURI)]
	}
	
	override getExportedObjectsByObject(EObject object) {
		delegate.getExportedObjectsByObject(object).filter[isContainedUri(EObjectURI)]
	}
	
	override getExportedObjectsByType(EClass type) {
		delegate.getExportedObjectsByType(type).filter[isContainedUri(EObjectURI)]
	}
	
	override isEmpty() {
		delegate.empty
	}
	
}