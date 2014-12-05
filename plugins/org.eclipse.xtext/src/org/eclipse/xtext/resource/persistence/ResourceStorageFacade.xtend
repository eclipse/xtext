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
import org.eclipse.xtext.generator.AbstractFileSystemAccess2
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import java.io.InputStream
import java.io.OutputStream
import org.eclipse.xtext.generator.IFileSystemAccessExtension3
import java.io.ByteArrayOutputStream
import java.io.ByteArrayInputStream
import org.eclipse.emf.common.util.URI

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ResourceStorageFacade {
	
	@Inject(optional=true) IContextualOutputConfigurationProvider outputConfigurationProvider
	@Inject(optional=true) Provider<AbstractFileSystemAccess2> fileSystemAccessProvider
	
	/**
	 * @return whether the given resource should be loaded from stored resource state
	 */
	def boolean shouldLoadFromStorage(StorageAwareResource resource) {
		if (outputConfigurationProvider == null || fileSystemAccessProvider == null)
			return false;
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
	 * find resource storage for the given resource.
	 * @return an IResourceStrorage or <code>null</code> is no storage for this resource can be found.
	 */
	def ResourceStorageInputStream getExistingResourceStorageInputStream(StorageAwareResource resource) {
		val stateProvider = resource.resourceSet.eAdapters.filter(ResourceStorageProviderAdapter).head
		if (stateProvider != null) {
			val inputStream = stateProvider.getResourceStorageInputStream(resource)
			if (inputStream != null)
				return inputStream
		}
		val inputStream = if (resource.resourceSet.URIConverter.exists(resource.URI.getBinaryStrorageURI, emptyMap)) {
				resource.resourceSet.URIConverter.createInputStream(resource.URI.getBinaryStrorageURI)
			} else {
				val fsa = getFileSystemAccess(resource);
				val outputRelativePath = computeOutputPath(resource)
				fsa.readBinaryFile(outputRelativePath)
			}
		return createResourceStorageInputStream(inputStream)
	}
	
	def void saveResource(StorageAwareResource resource, IFileSystemAccessExtension3 fsa) {
		val path = computeOutputPath(resource)
		val bout = new MyByteArrayOutputStream()
		val outStream = createResourceStorageOutputStream(bout)
		outStream.writeResource(resource)
		fsa.generateFile(path, new ByteArrayInputStream(bout.toByteArray, 0, bout.length))
	}
	
	public def ResourceStorageInputStream createResourceStorageInputStream(InputStream in) {
		return new ResourceStorageInputStream(in)
	}
	
	public def ResourceStorageOutputStream createResourceStorageOutputStream(OutputStream out) {
		return new ResourceStorageOutputStream(out)
	}
	
	/**
	 * @return whether a stored resource state exists for the given resource
	 */
	protected def doesStorageExist(StorageAwareResource resource) {
		val stateProvider = resource.resourceSet.eAdapters.filter(ResourceStorageProviderAdapter).head
		if (stateProvider!=null && stateProvider.getResourceStorageInputStream(resource) != null)
			return true;
		// check for next to original location, i.e. jars
		if (resource.resourceSet.URIConverter.exists(resource.URI.getBinaryStrorageURI, emptyMap)) {
			return true
		}
		
		// check for source project locations, i.e. use generator config
		val fsa = getFileSystemAccess(resource);
		val outputRelativePath = computeOutputPath(resource)
		val uri = fsa.getURI(outputRelativePath)
		return resource.resourceSet.URIConverter.exists(uri, null)
	}
	
	protected def getFileSystemAccess(StorageAwareResource resource) {
		val fsa = fileSystemAccessProvider.get()
		fsa.context = resource
		fsa.outputConfigurations = outputConfigurationProvider.getOutputConfigurations(resource).toMap[name]
		return fsa
	}
	
	protected def computeOutputPath(StorageAwareResource resource) {
		val uri = resource.URI.getBinaryStrorageURI
		val srcFolderPath = uri.trimFileExtension.trimSegments(uri.segmentCount-3).toString
		val outputRelativePath = uri.toString.substring(srcFolderPath.length+1)
		return outputRelativePath
	}
	
	public def getBinaryStrorageURI(URI sourceURI) {
		return sourceURI.trimSegments(1).appendSegment("."+sourceURI.lastSegment).appendFileExtension('xbin')
	}
	
	private static class MyByteArrayOutputStream extends ByteArrayOutputStream {
		override toByteArray() { buf }
		def int length() { count }
	}
}