/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import java.io.IOException
import java.io.ObjectOutputStream
import java.io.OutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import org.apache.log4j.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl
import org.eclipse.xtend.lib.annotations.Data

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Data class ResourceStorageWritable {
	
	static val LOG = Logger.getLogger(ResourceStorageWritable)
	
	OutputStream out
	
	def void writeResource(StorageAwareResource resource) {
		if (resource.isLoadedFromStorage) {
			throw new IllegalStateException("cannot write resources loaded from storage. URI was "+resource.URI)
		}
		val zipOut = new ZipOutputStream(out)
		try {
			writeEntries(resource, zipOut)
		} catch (IOException e) {
			LOG.error(e.message, e)
		} finally {
			zipOut.close
		}
	}
	
	/**
	 * Write entries into the storage.
	 * Overriding methods should first delegate to super before adding their own entries.
	 */
	protected def void writeEntries(StorageAwareResource resource, ZipOutputStream zipOut) {
		writeContents(resource, zipOut)
		writeResourceDescription(resource, zipOut)
	}
	
	protected def void writeContents(StorageAwareResource storageAwareResource, ZipOutputStream zipOut) {
		zipOut.putNextEntry(new ZipEntry("emf-contents"))
		val out = new BinaryResourceImpl.EObjectOutputStream(zipOut, emptyMap) {
			override writeURI(URI uri, String fragment) throws IOException {
				val portableURI = storageAwareResource.portableURIs.toPortableURI(storageAwareResource, uri, fragment)
				super.writeURI(portableURI.trimFragment, portableURI.fragment)
			}
		}
		try {
			out.saveResource(storageAwareResource)
		} finally {
			out.flush
		}
		zipOut.closeEntry
	}
	
	
	
	protected def void writeResourceDescription(StorageAwareResource resource, ZipOutputStream zipOut) {
		zipOut.putNextEntry(new ZipEntry("resource-description"))
		val description = resource.resourceServiceProvider.resourceDescriptionManager.getResourceDescription(resource);
		val serializableDescription = SerializableResourceDescription.createCopy(description) 
		val out = new ObjectOutputStream(zipOut);
		try {
			out.writeObject(serializableDescription);
		} finally {
			out.flush
		}
		zipOut.closeEntry
	}
}