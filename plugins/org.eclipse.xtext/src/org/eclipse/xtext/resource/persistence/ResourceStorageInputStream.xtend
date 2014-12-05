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
@Data class ResourceStorageInputStream {
	
	static val LOG = Logger.getLogger(ResourceStorageInputStream)
	
	InputStream in
	
	def void loadIntoResource(StorageAwareResource resource) {
		try {
			val zin = new ZipInputStream(in)
			loadEntries(resource, zin)
		} catch (IOException e) {
			LOG.error(e.message, e)
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
		val description = objectIn.readObject as SerializableResourceDescription
		description.updateResourceURI(resource.URI)
		resource.resourceDescription = description
	}
	
	protected def void readContents(StorageAwareResource resource, ZipInputStream zipIn) {
		zipIn.nextEntry
		val in = new BinaryResourceImpl.EObjectInputStream(zipIn, emptyMap)
		in.loadResource(resource)
	}
	
}