package org.eclipse.xtend.ide.builder

import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.builder.clustering.CurrentDescriptions
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider

class XtendResourceDescriptionsProvider extends ResourceDescriptionsProvider {
	
	override getResourceDescriptions(ResourceSet resourceSet) {
		val result = super.getResourceDescriptions(resourceSet)
		switch result {
			CurrentDescriptions$ResourceSetAware : {
				switch d:result.delegate {
					CurrentDescriptions : {
						return new FilteringResourceDescriptions(result,(d.buildData.toBeDeleted?:#[] + d.buildData.toBeUpdated?:#[]).toSet)
					}
				}
			}
		}
		return result
	}
}

@Data class FilteringResourceDescriptions implements IResourceDescriptions {
	
	IResourceDescriptions delegate
	Set<URI> allowedUris
	
	override getAllResourceDescriptions() {
		delegate.allResourceDescriptions.filter[allowedUris.contains(URI)]
	}
	
	override getResourceDescription(URI normalizedURI) {
		if (allowedUris.contains(normalizedURI)) {
			return delegate.getResourceDescription(normalizedURI);
		}
		return null
	}
	
	override getExportedObjects() {
		delegate.exportedObjects.filter[allowedUris.contains(it.EObjectURI.trimFragment)]
	}
	
	override getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		delegate.getExportedObjects(type,name,ignoreCase).filter[allowedUris.contains(it.EObjectURI.trimFragment)]
	}
	
	override getExportedObjectsByObject(EObject object) {
		delegate.getExportedObjectsByObject(object).filter[allowedUris.contains(it.EObjectURI.trimFragment)]
	}
	
	override getExportedObjectsByType(EClass type) {
		delegate.getExportedObjectsByType(type).filter[allowedUris.contains(it.EObjectURI.trimFragment)]
	}
	
	override isEmpty() {
		delegate.empty
	}
	
}