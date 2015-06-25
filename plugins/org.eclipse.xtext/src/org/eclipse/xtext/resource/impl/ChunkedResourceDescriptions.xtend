/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl

import com.google.common.annotations.Beta
import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager
import org.eclipse.xtext.util.internal.EmfAdaptable

/**
 * A IResourceDescriptions implementation that holds its resource description in chunks, each identified by a string.
 * The strings represent units such as projects, source sets, and libraries.
 * 
 * @see ProjectDescription
 * @see ProjectDescriptionBasedContainerManager
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
@EmfAdaptable class ChunkedResourceDescriptions extends AbstractCompoundSelectable implements IResourceDescriptions {
	
	protected ConcurrentHashMap<String, ResourceDescriptionsData> chunk2resourceDescriptions = new ConcurrentHashMap;
	
	protected ResourceSet resourceSet
	
	new() {}
	
	new(Map<String,ResourceDescriptionsData> initialData) {
		this.chunk2resourceDescriptions = new ConcurrentHashMap(initialData) 
	}
	
	new(Map<String,ResourceDescriptionsData> initialData, ResourceSet resourceSet) {
		this(initialData)
		setResourceSet(resourceSet)
	}
	
	/**
	 * Creates a shallow copy of the resource descriptions map and installs it with the given ResourceSet.
	 */
	def ChunkedResourceDescriptions createShallowCopyWith(ResourceSet resourceSet) {
		return new ChunkedResourceDescriptions(chunk2resourceDescriptions, resourceSet)
	}
	
	def ResourceSet getResourceSet() {
		resourceSet
	}
	
	protected def void setResourceSet(ResourceSet resourceSet) {
		if (this.resourceSet != null) {
			throw new IllegalStateException("This "+class.name+" is already associated with a different resource set.")
		}
		val index = findInEmfObject(resourceSet)
		if (index != null) {
			throw new IllegalStateException("There is already a different "+class.name+" installed in the given resource set.")
		}
		this.resourceSet = resourceSet
		attachToEmfObject(resourceSet)
	}
	
	def ResourceDescriptionsData setContainer(String name, ResourceDescriptionsData descriptions) {
		return chunk2resourceDescriptions.put(name, descriptions)
	}
	
	override protected getSelectables() {
		return chunk2resourceDescriptions.values
	}
	
	override getAllResourceDescriptions() {
		chunk2resourceDescriptions.values.map[it.getAllResourceDescriptions()].flatten
	}
	
	override getResourceDescription(URI uri) {
		for (selectable : chunk2resourceDescriptions.values) {
			val result = selectable.getResourceDescription(uri)
			if (result != null)
				return result
		}
		return null
	}
	
	def ResourceDescriptionsData getContainer(URI uri) {
		for (container : chunk2resourceDescriptions.values) {
			val result = container.getResourceDescription(uri)
			if (result != null)
				return container
		}
		return null
	}
	
	def ResourceDescriptionsData getContainer(String containerHandle) {
		return chunk2resourceDescriptions.get(containerHandle)
	}
	
}
