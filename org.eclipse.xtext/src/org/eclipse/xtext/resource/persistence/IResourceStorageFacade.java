/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.persistence;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.IFileSystemAccessExtension3;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @noimplement
 * @noextend
 * @since 2.8
 */
public interface IResourceStorageFacade {
  /**
   * @return whether the given resource should and can be loaded from stored resource state
   */
  boolean shouldLoadFromStorage(StorageAwareResource resource);
  
  /**
   * @return whether storage data exists for the given URI
   */
  boolean hasStorageFor(URI uri);
  
  /**
   * Finds or creates a ResourceStorageLoadable for the given resource.
   * Clients should first call shouldLoadFromStorage to check whether there exists a storage version
   * of the given resource.
   * 
   * @return an IResourceStorageLoadable
   */
  ResourceStorageLoadable getOrCreateResourceStorageLoadable(StorageAwareResource resource);
  
  /**
   * Saves the resource using the given file system access.
   */
  void saveResource(StorageAwareResource resource, IFileSystemAccessExtension3 fsa);
  
  /**
   * Creates a fresh ResourceStorageWritable wrapping the given OutputStream
   */
  ResourceStorageWritable createResourceStorageWritable(OutputStream outputStream);
  
  /**
   * Creates a fresh ResourceStorageLoadable wrapping the given InputStream
   */
  ResourceStorageLoadable createResourceStorageLoadable(InputStream inputStream);
}
