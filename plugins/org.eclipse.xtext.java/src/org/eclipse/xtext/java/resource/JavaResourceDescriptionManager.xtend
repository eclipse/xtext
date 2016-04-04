package org.eclipse.xtext.java.resource

import com.google.inject.Inject
import java.util.Collection
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescription.Delta
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.DefaultResourceDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta
import org.eclipse.xtext.util.IResourceScopeCache

class JavaResourceDescriptionManager implements IResourceDescription.Manager {
	
	@Inject JvmTypesResourceDescriptionStrategy descriptionStrategy
	@Inject IResourceScopeCache cache

	override createDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new DefaultResourceDescriptionDelta(oldDescription, newDescription)
	}

	override getResourceDescription(Resource resource) {
		if (resource instanceof JavaResource) {
			val initialized = resource.isInitialized || resource.isInitializing
			try {
				if (!initialized) {
					resource.eSetDeliver(false)
					resource.installStubs
				}
				val result = new DefaultResourceDescription(resource, descriptionStrategy, cache)
				if (!initialized) {
					for (it : result.exportedObjects)
						EObjectURI
				}
				return result
			} finally {
				if (!initialized) {
					resource.discardDerivedState
					resource.eSetDeliver(true)
				}
			}
		}
		throw new IllegalArgumentException("Can only handle JavaResources")
	}

	override isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

	override isAffected(Collection<Delta> deltas, IResourceDescription candidate,
		IResourceDescriptions context) throws IllegalArgumentException {
		var Collection<QualifiedName> importedNames = candidate.importedNames.toSet
		for (IResourceDescription.Delta delta : deltas) {
			if (hasChanges(delta, candidate)) {
				if (isAffected(importedNames, delta.getNew()) || isAffected(importedNames, delta.getOld())) {
					return true
				}
			}
		}
		return false
	}
	
	

	/** 
	 * Whether the given delta is considered to have changed from the candidate's perspective. By default this will just call{@link Delta#haveEObjectDescriptionsChanged() Delta#haveEObjectDescriptionsChanged()}. 
	 * But in some cases even "internal" changes (that are not visible in the EObjectDescriptions) could be interesting. 
	 * @since 2.7
	 */
	def protected boolean hasChanges(IResourceDescription.Delta delta, IResourceDescription candidate) {
		return delta.haveEObjectDescriptionsChanged()
	}

	def protected boolean isAffected(Collection<QualifiedName> importedNames, IResourceDescription description) {
		if (description !== null) {
			for (IEObjectDescription desc : description.getExportedObjects())
				if(importedNames.contains(desc.getName().toLowerCase())) return true
		}
		return false
	}

}