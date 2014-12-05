/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource

import com.google.common.collect.Sets
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.persistence.ResourceStorageOutputStream
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import java.io.IOException
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream.Check
import org.eclipse.xtext.xtype.XComputedTypeReference

/**
 * @author Sven Efftinge 
 */
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
	
	override protected writeContents(StorageAwareResource storageAwareResource, ZipOutputStream zipOut) {
		zipOut.putNextEntry(new ZipEntry("emf-contents"))
		val out = new BinaryResourceImpl.EObjectOutputStream(zipOut, emptyMap) {
			
			override writeURI(URI uri, String fragment) throws IOException {
				val indieURI = storageAwareResource.portableURIs.toPortableURI(storageAwareResource, uri, fragment)
				super.writeURI(indieURI.trimFragment, indieURI.fragment)
			}
			
			override saveEObject(InternalEObject internalEObject, Check check) throws IOException {
				var toBeSaved = internalEObject
				while (toBeSaved instanceof XComputedTypeReference) {
					toBeSaved = toBeSaved.equivalent as InternalEObject
				}
				super.saveEObject(toBeSaved, check)
			}
			
		}
		try {
			out.saveResource(storageAwareResource)
		} finally {
			out.flush
		}
		zipOut.closeEntry
	}
	
	protected def void writeAssociationsAdapter(BatchLinkableResource resource, ZipOutputStream zipOut) {
		val adapter = resource.eAdapters.filter(JvmModelAssociator.Adapter).head
		zipOut.putNextEntry(new ZipEntry("associations"))
		val objOut = new ObjectOutputStream(zipOut);
		
		// logicalMap
		val logicalMap = newHashMap()
		for (entry : adapter.logicalContainerMap.entrySet) {
			if (entry.key.eResource != resource) {
				LOG.info("entry "+entry+" not from resource "+resource.URI + " but from "+entry.key.eResource.URI)
			} else {
				logicalMap.put(entry.key.fragment, entry.value.fragment)
			}
		}
		objOut.writeObject(logicalMap)
		
		// sourceToTarget
		val sourceToTarget = newHashMap()
		for (entry : adapter.sourceToTargetMap.entrySet) {
			if (entry.key.eResource != resource) {
				LOG.info("entry not from resource "+resource.URI + " but from "+entry.key.eResource.URI)
			} else {
				sourceToTarget.put(entry.key.fragment, Sets.newHashSet(entry.value.map[fragment]))
			}
		}
		objOut.writeObject(sourceToTarget)
		
		// targetToSource
		val targetToSource = newHashMap()
		for (entry : adapter.targetToSourceMap.entrySet) {
			if (entry.key.eResource != resource) {
				LOG.info("entry not from resource "+resource?.URI + " but from "+entry?.key?.eResource?.URI)
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