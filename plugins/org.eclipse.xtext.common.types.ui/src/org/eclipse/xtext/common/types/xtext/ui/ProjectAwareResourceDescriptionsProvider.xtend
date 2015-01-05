/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext.ui

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.CompilerPhases
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider

/**
 * This specialization of the {@link ResourceDescriptionsProvider} filters
 * locally defined elements from the resource descriptions that are made available
 * during the indexing phase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
class ProjectAwareResourceDescriptionsProvider extends ResourceDescriptionsProvider {
	
	@Inject IJavaProjectProvider projectProvider
	@Inject CompilerPhases compilerPhases
	
	/**
	 * In the builder we use the Java representation for any upstream resources, so we filter them out here.
	 * And if we are in the indexing phase, we don't even want to see the local resources.
	 */
	override getResourceDescriptions(ResourceSet resourceSet) {
		val result = super.getResourceDescriptions(resourceSet)
		if (compilerPhases.isIndexing(resourceSet)) {
			val javaProject = projectProvider.getJavaProject(resourceSet)
			// during indexing we don't want to see any local files
			val encodedProjectName = URI.encodeSegment(javaProject.elementName, true)
			return new FilteringResourceDescriptions(result) [ uri |
				// we expect platform:/resource URIs here, where the second segment denotes the project's name.
				if (uri == null || uri.segmentCount<2 || !uri.isPlatformResource)
					return false
				return uri.segment(1) != encodedProjectName
			]
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
		allResourceDescriptions.empty
	}
	
}

