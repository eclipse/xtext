/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import java.io.IOException
import java.io.OutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl
import org.eclipse.xtend.lib.annotations.Data

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Data class ResourceStorageOutputStream {
	
	static val LOG = Logger.getLogger(ResourceStorageOutputStream)
	
	OutputStream out
	
	def void writeResource(StorageAwareResource resource) {
		try {
			val zipOut = new ZipOutputStream(out)
			writeEntries(resource, zipOut)
		} catch (IOException e) {
			LOG.error(e.message, e)
		}
	}
	
	/**
	 * Write entries into the storage.
	 * Overriding methods should first delegate to super before adding their own entries.
	 */
	protected def void writeEntries(StorageAwareResource resource, ZipOutputStream zipOut) {
		zipOut.putNextEntry(new ZipEntry("emf-contents"))
		val out = new BinaryResourceImpl.EObjectOutputStream(zipOut, emptyMap)
		try {
			out.saveResource(resource)
		} finally {
			out.flush
		}
		zipOut.closeEntry
	}
}