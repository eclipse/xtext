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
import java.io.ObjectInputStream
import java.util.zip.ZipInputStream
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.nodemodel.impl.SerializableNodeModel
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext
import java.io.InputStreamReader
import com.google.common.io.CharStreams
import java.io.DataInputStream
import org.eclipse.xtext.parser.ParseResult

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Data class ResourceStorageLoadable {
	
	static val LOG = Logger.getLogger(ResourceStorageLoadable)
	
	InputStream in
	
	protected def void loadIntoResource(StorageAwareResource resource) {
		try {
			if (!resource.isLoadedFromStorage) {
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
		zipIn.nextEntry
		readContents(resource, zipIn)

		zipIn.nextEntry
		readResourceDescription(resource, zipIn)

		zipIn.nextEntry
		readNodeModel(resource, zipIn)
	}
	
	protected def void readContents(StorageAwareResource resource, InputStream inputStream) {
		val in = new BinaryResourceImpl.EObjectInputStream(inputStream, emptyMap) {
			
			override readCompressedInt() throws IOException {
				//HACK! null resource set, to avoid usage of resourceSet's package registry
				resourceSet = null
				super.readCompressedInt()
			}
			
		}
		in.loadResource(resource)
	}
	
	protected def void readResourceDescription(StorageAwareResource resource, InputStream inputStream) {
		val objectIn = new ObjectInputStream(inputStream)
		val description = objectIn.readObject as SerializableResourceDescription
		description.updateResourceURI(resource.URI)
		resource.resourceDescription = description
	}
	
	protected def void readNodeModel(StorageAwareResource resource, InputStream inputStream) {
		try {
			val serializableNodeModel = new SerializableNodeModel(resource)
			// if this is a synthetic resource (i.e. tests or so, don't load the node model)
			if (!resource.resourceSet.URIConverter.exists(resource.URI, resource.resourceSet.loadOptions)) {
				LOG.info("Skipping loading node model for synthetic resource "+resource.URI)
				return;
			}
			val stream = resource.resourceSet.URIConverter.createInputStream(resource.URI)
			val in = new InputStreamReader(stream, resource.encoding)
			val completeContent = CharStreams.toString(in)
			val deserializationContext = new DeserializationConversionContext(resource, completeContent)
			val dataIn = new DataInputStream(inputStream)
			serializableNodeModel.readObjectData(dataIn, deserializationContext)
			resource.parseResult = new ParseResult(resource.contents.head,serializableNodeModel.root, deserializationContext.hasErrors)
		} catch (IOException e) {
			LOG.error(e.message, e)
		}
	}
	
}