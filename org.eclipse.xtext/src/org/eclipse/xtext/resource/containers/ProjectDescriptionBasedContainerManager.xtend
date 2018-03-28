/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers

import com.google.common.annotations.Beta
import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions
import org.eclipse.xtext.resource.impl.ProjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
class ProjectDescriptionBasedContainerManager implements IContainer.Manager {
	
	def boolean shouldUseProjectDescriptionBasedContainers(IResourceDescriptions resourceDescriptions) {
		val chunkedResourceDescriptions = resourceDescriptions.chunkedResourceDescriptions
		return chunkedResourceDescriptions !== null 
			&& chunkedResourceDescriptions.resourceSet !== null
			&& ProjectDescription.findInEmfObject(chunkedResourceDescriptions.resourceSet) !== null 
	}
	
	override getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		val chunkedResourceDescriptions = resourceDescriptions.chunkedResourceDescriptions
		if (chunkedResourceDescriptions === null)
			throw new IllegalArgumentException("expected "+ChunkedResourceDescriptions.name)
		
		val resourceSet = chunkedResourceDescriptions.resourceSet
		val projectDescription = ProjectDescription.findInEmfObject(resourceSet)
		val container = createContainer(resourceDescriptions, chunkedResourceDescriptions, projectDescription.name)
		return container
	}
	
	override getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		val chunkedResourceDescriptions = resourceDescriptions.chunkedResourceDescriptions
		if (chunkedResourceDescriptions === null)
			throw new IllegalArgumentException("expected "+ChunkedResourceDescriptions.name)
		val resourceSet = chunkedResourceDescriptions.resourceSet
		val projectDescription = ProjectDescription.findInEmfObject(resourceSet)
		val allContainers = <IContainer>newArrayList
		allContainers.add(createContainer(resourceDescriptions, chunkedResourceDescriptions, projectDescription.name))
		for (name : projectDescription.dependencies) {
			allContainers.add(createContainer(resourceDescriptions, chunkedResourceDescriptions, name))
		}
		return allContainers
	
	}
	
	protected def ChunkedResourceDescriptions getChunkedResourceDescriptions(IResourceDescriptions resourceDescriptions) {
		switch resourceDescriptions {
			ChunkedResourceDescriptions: resourceDescriptions
			LiveShadowedChunkedResourceDescriptions: resourceDescriptions.globalDescriptions.chunkedResourceDescriptions
			default: null
		}
	}
	
	protected def createContainer(IResourceDescriptions resourceDescriptions, ChunkedResourceDescriptions chunkedResourceDescriptions, String projectName) {
		if(resourceDescriptions instanceof LiveShadowedChunkedResourceDescriptions) 
			new LiveShadowedChunkedContainer(resourceDescriptions, projectName)
		else
			new ResourceDescriptionsBasedContainer(chunkedResourceDescriptions.getContainer(projectName) ?: new ResourceDescriptionsData(emptySet))
	}
}
