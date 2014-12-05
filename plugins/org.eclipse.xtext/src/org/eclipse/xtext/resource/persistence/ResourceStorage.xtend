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
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl
import org.eclipse.xtext.generator.AbstractFileSystemAccess2
import org.eclipse.xtext.generator.IContextualOutputConfigurationProvider
import org.eclipse.xtext.generator.IFileSystemAccessExtension3

/**
 * Service for storing and reading computed resource state
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class ResourceStorage {
	
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
	 * @return whether a stored resource state exists for the given resource
	 */
	def doesStorageExist(StorageAwareResource resource) {
		val stateProviders = resource.resourceSet.eAdapters.filter(ResourceStateProviderAdapter)
		if (stateProviders.exists[hasStateFor(resource.URI)])
			return true;
		// check for next to original location, i.e. jars
		if (resource.resourceSet.URIConverter.exists(resource.binURI, emptyMap)) {
			return true
		}
		
		// check for source project locations, i.e. use generator config
		val fsa = getFileSystemAccess(resource);
		val outputRelativePath = computeOutputPath(resource)
		val uri = fsa.getURI(outputRelativePath)
		return resource.resourceSet.URIConverter.exists(uri, null)
	}
	
	/**
	 * loads the given resource from stored resource state
	 */
	def void loadResource(StorageAwareResource resource) {
		val stateProviders = resource.resourceSet.eAdapters.filter(ResourceStateProviderAdapter)
		for (stateProvider : stateProviders) {
			if (stateProvider.hasStateFor(resource.URI)) {
				stateProvider.installState(resource)
				return;
			}
		}
		val inputStream = if (resource.resourceSet.URIConverter.exists(resource.binURI, emptyMap)) {
				resource.resourceSet.URIConverter.createInputStream(resource.binURI)
			} else {
				val fsa = getFileSystemAccess(resource);
				val outputRelativePath = computeOutputPath(resource)
				fsa.readBinaryFile(outputRelativePath)
			}
		val in = new BinaryResourceImpl.EObjectInputStream(inputStream, emptyMap)
		in.loadResource(resource)
	}
	
	protected def getFileSystemAccess(StorageAwareResource resource) {
		val fsa = fileSystemAccessProvider.get()
		fsa.context = resource
		fsa.outputConfigurations = outputConfigurationProvider.getOutputConfigurations(resource).toMap[name]
		fsa
	}
	
	protected def computeOutputPath(StorageAwareResource resource) {
		val uri = resource.getBinURI
		val srcFolderPath = uri.trimFileExtension.trimSegments(uri.segmentCount-3).toString
		val outputRelativePath = uri.toString.substring(srcFolderPath.length+1)
		return outputRelativePath
	}
	
	protected def getBinURI(StorageAwareResource resource) {
		resource.URI.appendFileExtension('.bin')
	}
	
	/**
	 * safes the given resource's state
	 */
	def void safeResource(StorageAwareResource resource, IFileSystemAccessExtension3 fsa) {
		val path = computeOutputPath(resource)
		val bout = new ByteArrayOutputStream
		val out = new BinaryResourceImpl.EObjectOutputStream(bout, emptyMap)
		try {
			out.saveResource(resource)
		} finally {
			out.flush
		}
		fsa.generateFile(path, new ByteArrayInputStream(bout.toByteArray))
	}
	
}
