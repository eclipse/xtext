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
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import org.eclipse.xtext.xtype.XComputedTypeReference

/**
 * @author Sven Efftinge 
 */
class BatchLinkableResourceStorageWritable extends ResourceStorageWritable {
	
	private final static Logger LOG = Logger.getLogger(BatchLinkableResourceStorageWritable)
	
	new(OutputStream out) {
		super(out)
	}

	override protected writeEntries(StorageAwareResource resource, ZipOutputStream zipOut) {
		// make sure lazy type references are computed
		resource.allContents.filter(XComputedTypeReference).forEach[ type ]
		super.writeEntries(resource, zipOut)
		if (resource instanceof BatchLinkableResource) {
			writeAssociationsAdapter(resource, zipOut)
		}
	}
	
	protected def void writeAssociationsAdapter(BatchLinkableResource resource, ZipOutputStream zipOut) {
		val adapter = resource.eAdapters.filter(JvmModelAssociator.Adapter).head
		zipOut.putNextEntry(new ZipEntry("associations"))
		val objOut = new ObjectOutputStream(zipOut);
		try {
			// logicalMap
			val logicalMap = newHashMap()
			for (entry : adapter.logicalContainerMap.entrySet) {
				if (entry.key.eResource != resource) {
					LOG.info("entry "+entry+" not from resource "+resource.URI + " but from "+entry.key.eResource?.URI)
				} else {
					logicalMap.put(entry.key.fragment, entry.value.fragment)
				}
			}
			objOut.writeObject(logicalMap)
			
			// sourceToTarget
			val sourceToTarget = newHashMap()
			for (entry : adapter.sourceToTargetMap.entrySet) {
				if (entry.key.eResource != resource) {
					LOG.info("entry not from resource "+resource.URI + " but from "+entry.key.eResource?.URI)
				} else {
					sourceToTarget.put(entry.key.fragment, Sets.newHashSet(entry.value.map[fragment]))
				}
			}
			objOut.writeObject(sourceToTarget)
			
			// targetToSource
			val targetToSource = newHashMap()
			for (entry : adapter.targetToSourceMap.entrySet) {
				if (entry.key.eResource != resource) {
					LOG.info("entry not from resource "+resource.URI + " but from "+entry.key.eResource?.URI)
				} else {
					targetToSource.put(entry.key.fragment, Sets.newHashSet(entry.value.map[fragment]))
				}
			}
			objOut.writeObject(targetToSource)
		} finally {
			objOut.close
		}
		
		zipOut.closeEntry
	}

	protected def String getFragment(EObject obj) {
		if (obj==null || obj.eIsProxy || obj.eResource == null) {
			return "none"
		}
		obj.eResource.getURIFragment(obj)
	}
}