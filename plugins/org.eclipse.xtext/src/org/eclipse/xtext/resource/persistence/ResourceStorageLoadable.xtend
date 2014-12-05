/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import java.io.IOException
import java.io.InputStream
import java.util.zip.ZipInputStream
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl
import org.eclipse.xtend.lib.annotations.Data
import java.io.ObjectInputStream

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Data class ResourceStorageLoadable {
	
	static val LOG = Logger.getLogger(ResourceStorageLoadable)
	
	InputStream in
	
	protected def void loadIntoResource(StorageAwareResource resource) {
		try {
			if (!resource.isIsLoadedFromStorage) {
				throw new IllegalStateException("Please use StorageAwareResource#load(ResourceStorageLoadable).");
			}
			val zin = new ZipInputStream(in)
			try {
				loadEntries(resource, zin)
			} finally {
				zin.close
			}
		} catch (IOException e) {
			LOG.error("Problem loading storage for "+resource.URI+". Error was:"+e.message, e)
		}
	}
	
	/**
	 * Load entries from the storage.
	 * Overriding methods should first delegate to super before adding their own entries.
	 */
	protected def void loadEntries(StorageAwareResource resource, ZipInputStream zipIn) {
		readContents(resource, zipIn)
		readResourceDescription(resource, zipIn)
	}
	
	protected def void readResourceDescription(StorageAwareResource resource, ZipInputStream zipIn) {
		zipIn.nextEntry
		val objectIn = new ObjectInputStream(zipIn)
		try {
			val description = objectIn.readObject as SerializableResourceDescription
			description.updateResourceURI(resource.URI)
			resource.resourceDescription = description
		} finally {
			objectIn.close
		}
	}
	
	protected def void readContents(StorageAwareResource resource, ZipInputStream zipIn) {
		zipIn.nextEntry
		val in = new BinaryResourceImpl.EObjectInputStream(zipIn, emptyMap) {
			
			override readCompressedInt() throws IOException {
				//HACK! null resource set, to avoid usage of resourceSet's package registry
				resourceSet = null
				super.readCompressedInt()
			}
			
		}
		in.loadResource(resource)
	}
	
}