package org.eclipse.xtend.ide.builder

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.builder.clustering.CurrentDescriptions
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider

class XtendResourceDescriptionsProvider extends ResourceDescriptionsProvider {
	
	@Inject IJavaProjectProvider projectProvider
	@Inject CompilerPhases compilerPhases
	
	/**
	 * In the builder we use the Java representation for any upstream resources, so we filter them out here.
	 * And if we are in the indexing phase, we don't even want to see the local resources.
	 */
	override getResourceDescriptions(ResourceSet resourceSet) {
		val result = super.getResourceDescriptions(resourceSet)
		val project = projectProvider.getJavaProject(resourceSet)
		switch result {
			CurrentDescriptions.ResourceSetAware : {
				switch d:result.delegate {
					// in the builder we don't want to see any non-local xtend files.
					CurrentDescriptions : {
						// during indexing we don't want to see any local xtend files either.
						if (compilerPhases.isIndexing(resourceSet)) {
							return new IResourceDescriptions.NullImpl();
						}
						val encodedProjectName = URI.encodeSegment(project.project.name, true)
						return new FilteringResourceDescriptions(result, [ uri |
							// we expect platform:/resource URIs here, where the second segment denotes the project's name.
							if (uri == null || uri.segmentCount<2)
								return false
							return uri.segment(1) == encodedProjectName 
						])
					}
				}
			}
		}
		if (compilerPhases.isIndexing(resourceSet)) {
			// during indexing we don't want to see any local xtend files
			val encodedProjectName = URI.encodeSegment(project.project.name, true)
			return new FilteringResourceDescriptions(result, [ uri |
				// we expect platform://resource URIs here, where the second segment denotes the project's name.
				if (uri == null || uri.segmentCount<2)
					return false
				return uri.segment(1) != encodedProjectName
			])
		} else {
			return result
		}
	}
}

@Data class FilteringResourceDescriptions implements IResourceDescriptions {
	
	IResourceDescriptions delegate
	(URI)=>boolean filter
	
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
		return filter.apply(uri)
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