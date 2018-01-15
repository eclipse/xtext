/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import com.google.common.io.CharStreams
import java.io.BufferedInputStream
import java.io.DataInputStream
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.ObjectInputStream
import java.util.zip.ZipInputStream
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectInputStream
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.nodemodel.impl.SerializableNodeModel
import org.eclipse.xtext.nodemodel.serialization.DeserializationConversionContext
import org.eclipse.xtext.parser.ParseResult

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@FinalFieldsConstructor class ResourceStorageLoadable {
	
	static val LOG = Logger.getLogger(ResourceStorageLoadable)
	
	val InputStream in
	val boolean storeNodeModel
	
	protected def void loadIntoResource(StorageAwareResource resource) throws IOException {
		if (!resource.isLoadedFromStorage) {
			throw new IllegalStateException("Please use StorageAwareResource#load(ResourceStorageLoadable).");
		}
		val zin = new ZipInputStream(in)
		try {
			loadEntries(resource, zin)
		} finally {
			zin.close
		}
	}
	
	/**
	 * Load entries from the storage.
	 * Overriding methods should first delegate to super before adding their own entries.
	 */
	protected def void loadEntries(StorageAwareResource resource, ZipInputStream zipIn) throws IOException {
		zipIn.nextEntry
		readContents(resource, new BufferedInputStream(zipIn))

		zipIn.nextEntry
		readResourceDescription(resource, new BufferedInputStream(zipIn))

		if (storeNodeModel) {
			zipIn.nextEntry
			readNodeModel(resource, new BufferedInputStream(zipIn))
		}
	}
	
	protected def void readContents(StorageAwareResource resource, InputStream inputStream) throws IOException {
		val in = new BinaryResourceImpl.EObjectInputStream(inputStream, emptyMap) {
			
			override readCompressedInt() throws IOException {
				//HACK! null resource set, to avoid usage of resourceSet's package registry
				resourceSet = null
				super.readCompressedInt()
			}
			
			override loadEObject() throws IOException {
				val result = super.loadEObject()
				handleLoadEObject(result, this)
				return result
			}
	
			
		}
		in.loadResource(resource)
	}
	
	protected def handleLoadEObject(InternalEObject loaded, EObjectInputStream input) throws IOException {
	}
	
	protected def void readResourceDescription(StorageAwareResource resource, InputStream inputStream) throws IOException {
		val objectIn = new ObjectInputStream(inputStream)
		val description = objectIn.readObject as SerializableResourceDescription
		description.updateResourceURI(resource.URI)
		resource.resourceDescription = description
	}
	
	protected def void readNodeModel(StorageAwareResource resource, InputStream inputStream) throws IOException {
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
	}
	
}
