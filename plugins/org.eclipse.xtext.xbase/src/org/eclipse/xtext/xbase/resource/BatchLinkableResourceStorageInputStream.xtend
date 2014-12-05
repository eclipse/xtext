/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource

import com.google.common.collect.Sets
import java.io.InputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.util.Map
import java.util.Set
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade
import org.eclipse.xtext.resource.persistence.ResourceStorageInputStream
import org.eclipse.xtext.resource.persistence.ResourceStorageOutputStream
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class BatchLinkableResourceStorageFacade extends ResourceStorageFacade {
	
	override createResourceStorageInputStream(InputStream in) {
		return new BatchLinkableResourceStorageInputStream(in)
	}
	
	override createResourceStorageOutputStream(OutputStream out) {
		return new BatchLinkableResourceStorageOutputStream(out)
	}
	
} 

class BatchLinkableResourceStorageInputStream extends ResourceStorageInputStream {
	
	new(InputStream in) {
		super(in)
	}
	
	override protected loadEntries(StorageAwareResource resource, ZipInputStream zipIn) {
		super.loadEntries(resource, zipIn)
		if (resource instanceof BatchLinkableResource) {
			readAssociationsAdapter(resource, zipIn)
		}
	}
	
	protected def void readAssociationsAdapter(BatchLinkableResource resource, ZipInputStream stream) {
		val existing = resource.eAdapters.filter(JvmModelAssociator.Adapter).head
		val adapter = existing
			?: (new JvmModelAssociator.Adapter()=> [
				resource.eAdapters += it
			]) 
		
		stream.nextEntry
		val objIn = new ObjectInputStream(stream)
		val logicalMap = objIn.readObject as Map<String,String>
		logicalMap.entrySet.forEach [
			adapter.logicalContainerMap.put(resource.getEObject(key), resource.getEObject(value) as JvmIdentifiableElement)
		]
		val sourceToTargetMap = objIn.readObject as Map<String,Set<String>>
		sourceToTargetMap.entrySet.forEach [
			adapter.sourceToTargetMap.put(resource.getEObject(key), Sets.newHashSet(value.map[resource.getEObject(it)]))
		]
		val targetToSourceMap = objIn.readObject as Map<String,Set<String>>
		targetToSourceMap.entrySet.forEach [
			adapter.targetToSourceMap.put(resource.getEObject(key), Sets.newHashSet(value.map[resource.getEObject(it)]))
		]
	}
	
}

class BatchLinkableResourceStorageOutputStream extends ResourceStorageOutputStream {
	
	private final static Logger LOG = Logger.getLogger(BatchLinkableResourceStorageOutputStream)
	
	new(OutputStream out) {
		super(out)
	}

	override protected writeEntries(StorageAwareResource resource, ZipOutputStream zipOut) {
		super.writeEntries(resource, zipOut)
		if (resource instanceof BatchLinkableResource) {
			writeAssociationsAdapter(resource, zipOut)
		}
	}
	
	protected def void writeAssociationsAdapter(BatchLinkableResource resource, ZipOutputStream zipOut) {
		val adapter = resource.eAdapters.filter(JvmModelAssociator.Adapter).head
		zipOut.putNextEntry(new ZipEntry("associations"))
		val objOut = new ObjectOutputStream(zipOut);
		
		// logicalMap
		val logicalMap = newHashMap()
		for (entry : adapter.logicalContainerMap.entrySet) {
			if (entry.key.eResource != resource) {
				LOG.error("entry "+entry+" not from resource "+resource.URI + " but from "+entry.key.eResource.URI)
			} else {
				logicalMap.put(entry.key.fragment, entry.value.fragment)
			}
		}
		objOut.writeObject(logicalMap)
		
		// sourceToTarget
		val sourceToTarget = newHashMap()
		for (entry : adapter.sourceToTargetMap.entrySet) {
			if (entry.key.eResource != resource) {
				LOG.error("entry not from resource "+resource.URI + " but from "+entry.key.eResource.URI)
			} else {
				sourceToTarget.put(entry.key.fragment, Sets.newHashSet(entry.value.map[fragment]))
			}
		}
		objOut.writeObject(sourceToTarget)
		
		// targetToSource
		val targetToSource = newHashMap()
		for (entry : adapter.targetToSourceMap.entrySet) {
			if (entry.key.eResource != resource) {
				LOG.error("entry not from resource "+resource?.URI + " but from "+entry?.key?.eResource?.URI)
			} else {
				targetToSource.put(entry.key.fragment, Sets.newHashSet(entry.value.map[fragment]))
			}
		}
		objOut.writeObject(targetToSource)
		
		zipOut.closeEntry
	}

	protected def String getFragment(EObject obj) {
		if (obj==null || obj.eIsProxy || obj.eResource == null) {
			return "none"
		}
		obj.eResource.getURIFragment(obj)
	}
}