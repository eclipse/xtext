/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource

import com.google.common.collect.Sets
import java.io.IOException
import java.io.ObjectInputStream
import java.util.Map
import java.util.Set
import java.util.zip.ZipInputStream
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectInputStream
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter
import org.eclipse.xtext.xbase.jvmmodel.JvmIdentifiableMetaData
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator

@FinalFieldsConstructor class BatchLinkableResourceStorageLoadable extends ResourceStorageLoadable {
	
	override protected loadEntries(StorageAwareResource resource, ZipInputStream zipIn) throws IOException {
		super.loadEntries(resource, zipIn)
		if (resource instanceof BatchLinkableResource) {
			readAssociationsAdapter(resource, zipIn)
		}
	}
	
	override protected handleLoadEObject(InternalEObject loaded, EObjectInputStream input) throws IOException {
		super.handleLoadEObject(loaded, input)
		// load documentation adapters
		if (input.readBoolean) {
			val doc = input.readString
			loaded.eAdapters += new DocumentationAdapter => [
				documentation = doc
			]
		}
		// load additional meta data
		if (input.readBoolean) {
			loaded.eAdapters += new JvmIdentifiableMetaData => [
				synthetic = input.readBoolean
			]
		}
	}
	
	protected def void readAssociationsAdapter(BatchLinkableResource resource, ZipInputStream stream) throws IOException {
		val existing = resource.eAdapters.filter(JvmModelAssociator.Adapter).head
		val adapter = existing
			?: (new JvmModelAssociator.Adapter()=> [
				resource.eAdapters += it
			]) 
		
		stream.nextEntry
		val objIn = new ObjectInputStream(stream)
		val logicalMap = objIn.readObject as Map<String,String>
		for (it : logicalMap.entrySet)
			adapter.logicalContainerMap.put(resource.getEObject(key), resource.getEObject(value) as JvmIdentifiableElement)
		val sourceToTargetMap = objIn.readObject as Map<String,Set<String>>
		for (it : sourceToTargetMap.entrySet)
			adapter.sourceToTargetMap.put(resource.getEObject(key), Sets.newHashSet(value.map[resource.getEObject(it)]))
		val targetToSourceMap = objIn.readObject as Map<String,Set<String>>
		for (it : targetToSourceMap.entrySet)
			adapter.targetToSourceMap.put(resource.getEObject(key), Sets.newHashSet(value.map[resource.getEObject(it)]))
	}
	
}

