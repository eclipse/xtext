/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource

import com.google.common.collect.Sets
import java.io.BufferedInputStream
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
		val objIn = new ObjectInputStream(new BufferedInputStream(stream))
		val logicalMap = objIn.readObject as Map<String,String>
		logicalMap.entrySet.forEach [
			adapter.logicalContainerMap.put(resource.getEObject(key), resource.getEObject(value) as JvmIdentifiableElement)
		]
		val sourceToTargetMap = objIn.readObject as Map<String,Set<String>>
		sourceToTargetMap.entrySet.forEach [
			adapter.sourceToTargetMap.put(resource.getEObject(key), Sets.newLinkedHashSet(value.map[resource.getEObject(it)]))
		]
		val targetToSourceMap = objIn.readObject as Map<String,Set<String>>
		targetToSourceMap.entrySet.forEach [
			adapter.targetToSourceMap.put(resource.getEObject(key), Sets.newLinkedHashSet(value.map[resource.getEObject(it)]))
		]
	}
	
}

