/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers

import com.google.common.annotations.Beta
import java.util.Set
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions
import org.eclipse.xtext.workspace.IProjectConfig
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.14
 */
@Beta 
@FinalFieldsConstructor
class LiveShadowedChunkedContainer implements IContainer {
	
	val LiveShadowedChunkedResourceDescriptions descriptions

	val String containerName
	
	IProjectConfig projectConfig
	
	boolean isProjectConfigSet = false
	
	
	protected def getChunkedResourceDescriptions() {
		descriptions.globalDescriptions as ChunkedResourceDescriptions
	}

	protected def getProjectConfig() {
		if (!isProjectConfigSet) {
			projectConfig = descriptions.workspaceConfig?.findProjectByName(containerName)
			isProjectConfigSet = true	
		} 
		return projectConfig 
	}
	
	protected def getChunk() {
		chunkedResourceDescriptions.getContainer(containerName) ?: new ResourceDescriptionsData(#[])
	}
	
	protected def getContainedLocalDescriptions() {
		descriptions.localDescriptions.allResourceDescriptions.filter[URI.contained]
	}
	
	protected def boolean isContained(URI uri) {
		chunk.getResourceDescription(uri) !== null || getProjectConfig?.findSourceFolderContaining(uri) !== null
	}
	
	override getResourceDescription(URI uri) {
		if(uri.contained) 
			descriptions.getResourceDescription(uri)
		else
			null
	}
	
	override getResourceDescriptionCount() {
		resourceDescriptions.size
	}
	
	override getResourceDescriptions() {
		val localURIs = existingOrRenamedResourceURIs
		return containedLocalDescriptions
			+ chunk.allResourceDescriptions.filter[!localURIs.contains(URI)]
	}
	
	override hasResourceDescription(URI uri) {
		chunk.getResourceDescription(uri) !== null
	}
	
	override getExportedObjects() {
		val localURIs = existingOrRenamedResourceURIs
		val flatten = containedLocalDescriptions.map[exportedObjects].flatten
		return flatten 
			+ chunk.exportedObjects.filter[!localURIs.contains(EObjectURI.trimFragment)]
	}
	
	override getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		val localURIs = existingOrRenamedResourceURIs
		return containedLocalDescriptions.map[getExportedObjects(type, name, ignoreCase)].flatten
			+ chunk.getExportedObjects(type, name, ignoreCase).filter[!localURIs.contains(EObjectURI.trimFragment)]
	}
	
	override getExportedObjectsByObject(EObject object) {
		val localURIs = existingOrRenamedResourceURIs
		return containedLocalDescriptions.map[getExportedObjectsByObject(object)].flatten
			+ chunk.getExportedObjectsByObject(object).filter[!localURIs.contains(EObjectURI.trimFragment)]
	}
	
	override getExportedObjectsByType(EClass type) {
		val localURIs = existingOrRenamedResourceURIs
		return containedLocalDescriptions.map[getExportedObjectsByType(type)].flatten
			+ chunk.getExportedObjectsByType(type).filter[!localURIs.contains(EObjectURI.trimFragment)]
	}
	
	override isEmpty() {
		containedLocalDescriptions.empty && chunk.empty
	}

	def protected Set<URI> getExistingOrRenamedResourceURIs() {
		val resourceSet = descriptions.resourceSet 
		if (resourceSet instanceof ResourceSetImpl) 
			return resourceSet.URIResourceMap.keySet 
		throw new IllegalStateException("ResourceSet is not a ResourceSetImpl")
	}
}