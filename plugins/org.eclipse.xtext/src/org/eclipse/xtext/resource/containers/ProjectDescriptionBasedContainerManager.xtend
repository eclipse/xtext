/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
	
	public def boolean shouldUseProjectDescriptionBasedContainers(IResourceDescriptions resourceDescriptions) {
		if (resourceDescriptions instanceof ChunkedResourceDescriptions) {
			if (ProjectDescription.findInEmfObject(resourceDescriptions.resourceSet) != null) {
				return true
			}
		}
		return false 
	}
	
	override getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		if (resourceDescriptions instanceof ChunkedResourceDescriptions) {
			val resourceSet = resourceDescriptions.resourceSet
			val projectDescription = ProjectDescription.findInEmfObject(resourceSet)
			val container = resourceDescriptions.getContainer(projectDescription.name)
			return new ResourceDescriptionsBasedContainer(container)
		}
		throw new IllegalArgumentException("expected "+ChunkedResourceDescriptions.name)
	}
	
	override getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		if (resourceDescriptions instanceof ChunkedResourceDescriptions) {
			val resourceSet = resourceDescriptions.resourceSet
			val projectDescription = ProjectDescription.findInEmfObject(resourceSet)
			val allContainers = <IContainer>newArrayList
			val container = resourceDescriptions.getContainer(projectDescription.name) ?: new ResourceDescriptionsData(emptySet)
			allContainers.add(new ResourceDescriptionsBasedContainer(container))
			for (name : projectDescription.dependencies) {
				val containerDep = resourceDescriptions.getContainer(name) ?: new ResourceDescriptionsData(emptySet)
				allContainers.add(new ResourceDescriptionsBasedContainer(containerDep))
			}
			return allContainers
		}
		throw new IllegalArgumentException("expected "+ChunkedResourceDescriptions.name)
	}
	
}
