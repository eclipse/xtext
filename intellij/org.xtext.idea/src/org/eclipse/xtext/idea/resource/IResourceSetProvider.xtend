package org.eclipse.xtext.idea.resource

import org.eclipse.emf.ecore.resource.ResourceSet
import com.google.inject.ImplementedBy

@ImplementedBy(ProjectBasedResourceSetProvider)
interface IResourceSetProvider {
	
	def ResourceSet get(Object context)
	
}