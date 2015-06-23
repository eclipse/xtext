/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone.incremental

import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData

/**
 * 
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
class ChunkedResourceDescriptions extends AbstractCompoundSelectable implements IResourceDescriptions {
	
	protected volatile ConcurrentHashMap<String, ResourceDescriptionsData> chunk2resourceDescriptions = new ConcurrentHashMap;
	
	new() {}
	
	new(Map<String,ResourceDescriptionsData> initialData) {
		this.chunk2resourceDescriptions = new ConcurrentHashMap(initialData) 
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
