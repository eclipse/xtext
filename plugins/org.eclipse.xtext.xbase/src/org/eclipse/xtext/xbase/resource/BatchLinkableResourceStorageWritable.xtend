/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.resource

import com.google.common.collect.Sets
import java.io.BufferedOutputStream
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.xbase.compiler.DocumentationAdapter
import org.eclipse.xtext.xbase.jvmmodel.JvmIdentifiableMetaData
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator
import org.eclipse.xtext.xtype.XComputedTypeReference

/**
 * @author Sven Efftinge 
 */
@FinalFieldsConstructor class BatchLinkableResourceStorageWritable extends ResourceStorageWritable {
	
	private final static Logger LOG = Logger.getLogger(BatchLinkableResourceStorageWritable)
	
	override protected writeEntries(StorageAwareResource resource, ZipOutputStream zipOut) {
		super.writeEntries(resource, zipOut)
		if (resource instanceof BatchLinkableResource) {
			zipOut.putNextEntry(new ZipEntry("associations"))
			val buffOut = new BufferedOutputStream(zipOut)
			try {
				writeAssociationsAdapter(resource, buffOut)
			} finally {
				buffOut.flush
				zipOut.closeEntry
			}
		}
	}
	
	override protected beforeSaveEObject(InternalEObject object, EObjectOutputStream writable_1) {
		super.beforeSaveEObject(object, writable_1)
		// make sure lazy type references are computed
		if (object instanceof XComputedTypeReference) {
			object.type
		}
	}
	
	override protected handleSaveEObject(InternalEObject object, BinaryResourceImpl.EObjectOutputStream out) {
		super.handleSaveEObject(object, out)
		
		var DocumentationAdapter documentationAdapter = null;
		var JvmIdentifiableMetaData metaDataAdapter = null;
		for (adapter : object.eAdapters) {
			if (adapter instanceof DocumentationAdapter) {
				documentationAdapter = adapter;
			}
			if (adapter instanceof JvmIdentifiableMetaData) {
				metaDataAdapter = adapter
			}
		}
		
		// store Documentation adapters
		if (documentationAdapter!=null) {
			out.writeBoolean(true)
			out.writeString(documentationAdapter.documentation)
		} else {
			out.writeBoolean(false)
		}
		// store additional meta data
		if (metaDataAdapter != null) {
			out.writeBoolean(true)
			out.writeBoolean(metaDataAdapter.synthetic)
		} else {
			out.writeBoolean(false)
		}
	}
	
	protected def void writeAssociationsAdapter(BatchLinkableResource resource, OutputStream zipOut) {
		val adapter = resource.eAdapters.filter(JvmModelAssociator.Adapter).head
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
			objOut.flush
		}
	}

	protected def String getFragment(EObject obj) {
		if (obj==null || obj.eIsProxy || obj.eResource == null) {
			return "none"
		}
		obj.eResource.getURIFragment(obj)
	}
}