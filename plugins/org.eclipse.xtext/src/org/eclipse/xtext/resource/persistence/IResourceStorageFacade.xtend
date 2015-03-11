/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.persistence

import org.eclipse.xtext.generator.IFileSystemAccessExtension3
import java.io.OutputStream
import java.io.InputStream
import org.eclipse.emf.common.util.URI

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @noimplement
 * @noextend
 * @since 2.8
 */
interface IResourceStorageFacade {
	
	/**
	 * @return whether the given resource should and can be loaded from stored resource state
	 */
	def boolean shouldLoadFromStorage(StorageAwareResource resource)
	
	/**
	 * @return whether storage data exists for the given URI
	 */
	def boolean hasStorageFor(URI uri)
	
	/**
	 * Finds or creates a ResourceStorageLoadable for the given resource.
	 * Clients should first call shouldLoadFromStorage to check whether there exists a storage version
	 * of the given resource.
	 * 
	 * @return an IResourceStorageLoadable
	 */
	def ResourceStorageLoadable getOrCreateResourceStorageLoadable(StorageAwareResource resource)
	
	/**
	 * Saves the resource using the given file system access.
	 */
	def void saveResource(StorageAwareResource resource, IFileSystemAccessExtension3 fsa)
	
	/**
	 * Creates a fresh ResourceStorageWritable wrapping the given OutputStream 
	 */
	def ResourceStorageWritable createResourceStorageWritable(OutputStream outputStream)
	
	/**
	 * Creates a fresh ResourceStorageLoadable wrapping the given InputStream 
	 */
	def ResourceStorageLoadable createResourceStorageLoadable(InputStream inputStream)
	
}