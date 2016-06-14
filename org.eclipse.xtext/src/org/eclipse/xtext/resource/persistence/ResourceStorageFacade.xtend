/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import com.google.inject.Inject
import com.google.inject.Provider
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl
import org.eclipse.xtext.generator.AbstractFileSystemAccess2
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.generator.IFileSystemAccessExtension3
import org.eclipse.xtend.lib.annotations.Accessors
import java.io.IOException
import org.apache.log4j.Logger

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ResourceStorageFacade implements IResourceStorageFacade {
	
	static val Logger LOG = Logger.getLogger(ResourceStorageFacade)
	
	@Inject IContextualOutputConfigurationProvider outputConfigurationProvider
	@Inject Provider<AbstractFileSystemAccess2> fileSystemAccessProvider
	
	@Accessors boolean storeNodeModel = false
	
	/**
	 * @return whether the given resource should be loaded from stored resource state
	 */
	override boolean shouldLoadFromStorage(StorageAwareResource resource) {
		val adapter = SourceLevelURIsAdapter.findInstalledAdapter(resource.resourceSet)
		if (adapter == null) {
			return false;
		} else {
			if (adapter.sourceLevelURIs.contains(resource.URI))
				return false;
		}
		return doesStorageExist(resource)
	}
	
	/**
	 * Finds or creates a ResourceStorageLoadable for the given resource.
	 * Clients should first call shouldLoadFromStorage to check whether there exists a storage version
	 * of the given resource.
	 * 
	 * @return an IResourceStorageLoadable
	 */
	override ResourceStorageLoadable getOrCreateResourceStorageLoadable(StorageAwareResource resource) {
		val stateProvider = resource.resourceSet.eAdapters.filter(ResourceStorageProviderAdapter).head
		if (stateProvider != null) {
			val inputStream = stateProvider.getResourceStorageLoadable(resource)
			if (inputStream != null)
				return inputStream
		}
		val inputStream = if (resource.resourceSet.URIConverter.exists(resource.URI.getBinaryStorageURI, emptyMap)) {
				resource.resourceSet.URIConverter.createInputStream(resource.URI.getBinaryStorageURI)
			} else {
				val fsa = getFileSystemAccess(resource);
				val outputRelativePath = computeOutputPath(resource)
				fsa.readBinaryFile(outputRelativePath)
			}
		return createResourceStorageLoadable(inputStream)
	}
	
	override void saveResource(StorageAwareResource resource, IFileSystemAccessExtension3 fsa) {
		val path = computeOutputPath(resource)
		val bout = new MyByteArrayOutputStream()
		val outStream = createResourceStorageWritable(bout)
		try {
			outStream.writeResource(resource)
		} catch(IOException e) {
			// something went wrong when writing the resource - stream's content is bogus and not written to disk
			LOG.warn("Cannot write storage for " + resource.URI, e)
			return;
		}
		fsa.generateFile(path, new ByteArrayInputStream(bout.toByteArray, 0, bout.length))
	}
	
	override def ResourceStorageLoadable createResourceStorageLoadable(InputStream in) {
		return new ResourceStorageLoadable(in, isStoreNodeModel)
	}
	
	override def ResourceStorageWritable createResourceStorageWritable(OutputStream out) {
		return new ResourceStorageWritable(out, isStoreNodeModel)
	}
	
	/**
	 * @return whether a stored resource state exists for the given resource
	 */
	protected def doesStorageExist(StorageAwareResource resource) {
		val stateProvider = resource.resourceSet.eAdapters.filter(ResourceStorageProviderAdapter).head
		if (stateProvider!=null && stateProvider.getResourceStorageLoadable(resource) != null)
			return true;
		// check for next to original location, i.e. jars
		if (resource.resourceSet.URIConverter.exists(resource.URI.getBinaryStorageURI, emptyMap)) {
			return true
		}
		// if it's an archive URI, we don't need to look up the source folder-output folder scheme
		if (resource.URI.isArchive) {
			return false
		}
		
		// check for source project locations, i.e. use generator config
		val fsa = getFileSystemAccess(resource)
		val outputRelativePath = computeOutputPath(resource)
		val uri = fsa.getURI(outputRelativePath)
		return uri !== null && resource.resourceSet.URIConverter.exists(uri, null)
	}
	
	protected def getFileSystemAccess(StorageAwareResource resource) {
		val fsa = fileSystemAccessProvider.get()
		fsa.context = resource
		fsa.outputConfigurations = outputConfigurationProvider.getOutputConfigurations(resource).toMap[name]
		return fsa
	}
	
	protected def computeOutputPath(StorageAwareResource resource) {
		val srcContainerURI = getSourceContainerURI(resource)
		val uri = resource.URI.getBinaryStorageURI
		val outputRelativePath = uri.deresolve(srcContainerURI, false, false, true).path
		return outputRelativePath
	}
	
	def protected getSourceContainerURI(StorageAwareResource resource) {
		return resource.URI.trimSegments(1).appendSegment("")
	}
	
	override hasStorageFor(URI uri) {
		return new ExtensibleURIConverterImpl().exists(getBinaryStorageURI(uri), emptyMap())
	}
	
	protected def getBinaryStorageURI(URI sourceURI) {
		return sourceURI.trimSegments(1).appendSegment("."+sourceURI.lastSegment+'bin')
	}
	
	private static class MyByteArrayOutputStream extends ByteArrayOutputStream {
		override toByteArray() { buf }
		def int length() { count }
	}
}