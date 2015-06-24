/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl

import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import com.google.common.annotations.Beta
import org.eclipse.xtext.util.internal.EmfAdaptable
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager

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
@EmfAdaptable class ChunkedResourceDescriptions extends AbstractCompoundSelectable implements IResourceDescriptions, IResourceDescriptions.IContextAware {
	
	protected ConcurrentHashMap<String, ResourceDescriptionsData> chunk2resourceDescriptions = new ConcurrentHashMap;
	
	protected ResourceSet resourceSet
	
	override void setContext(Notifier context) {
		val newResourceSet = EcoreUtil2.getResourceSet(context)
		if (this.resourceSet != null && this.resourceSet != newResourceSet) {
			throw new IllegalStateException("This "+class.name+" is already associated with a different resource set.")
		}
		val index = findInEmfObject(newResourceSet)
		if (index != null && index != this) {
			throw new IllegalStateException("There is already a different "+class.name+" installed in the given resource set.")
		}
		this.resourceSet = newResourceSet
	}
	
	def ResourceSet getResourceSet() {
		resourceSet
	}
	
	new() {}
	
	new(Map<String,ResourceDescriptionsData> initialData) {
		this.chunk2resourceDescriptions = new ConcurrentHashMap(initialData) 
	}
	
	/**
	 * Creates a flat copy of the resource descriptions. i.e. the inner ResourceDescriptionsData objects are not copied.
	 * Also doesn't copy over the referenced ResourceSet
	 */
	def ChunkedResourceDescriptions createFreshFlatCopy() {
		new ChunkedResourceDescriptions(chunk2resourceDescriptions) 
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
