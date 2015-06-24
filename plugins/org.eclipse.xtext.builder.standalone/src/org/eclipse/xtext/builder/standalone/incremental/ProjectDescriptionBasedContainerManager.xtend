/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import org.eclipse.xtext.resource.IContainer
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
class ProjectDescriptionBasedContainerManager implements IContainer.Manager {
	
	override getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		if (resourceDescriptions instanceof ContextualChunkedResourceDescriptions) {
			val resourceSet = resourceDescriptions.resourceSet
			val projectDescription = ProjectDescription.findInEmfObject(resourceSet)
			val container = resourceDescriptions.getContainer(projectDescription.name)
			return new ResourceDescriptionsBasedContainer(container)
		}
		throw new IllegalArgumentException("expected "+ContextualChunkedResourceDescriptions.name)
	}
	
	override getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		if (resourceDescriptions instanceof ContextualChunkedResourceDescriptions) {
			val resourceSet = resourceDescriptions.resourceSet
			val projectDescription = ProjectDescription.findInEmfObject(resourceSet)
			val allContainers = <IContainer>newArrayList
			allContainers.add(new ResourceDescriptionsBasedContainer(resourceDescriptions.getContainer(projectDescription.name)))
			allContainers.addAll(projectDescription.dependencies.map[ uri |
				val container = resourceDescriptions.getContainer(uri.toString)
				return new ResourceDescriptionsBasedContainer(container)
			])
			return allContainers
		}
		throw new IllegalArgumentException("expected "+ContextualChunkedResourceDescriptions.name)
	}
	
}
