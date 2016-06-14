/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.IFileSystemAccessExtension3;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @noimplement
 * @noextend
 * @since 2.8
 */
@SuppressWarnings("all")
public interface IResourceStorageFacade {
  /**
   * @return whether the given resource should and can be loaded from stored resource state
   */
  public abstract boolean shouldLoadFromStorage(final StorageAwareResource resource);
  
  /**
   * @return whether storage data exists for the given URI
   */
  public abstract boolean hasStorageFor(final URI uri);
  
  /**
   * Finds or creates a ResourceStorageLoadable for the given resource.
   * Clients should first call shouldLoadFromStorage to check whether there exists a storage version
   * of the given resource.
   * 
   * @return an IResourceStorageLoadable
   */
  public abstract ResourceStorageLoadable getOrCreateResourceStorageLoadable(final StorageAwareResource resource);
  
  /**
   * Saves the resource using the given file system access.
   */
  public abstract void saveResource(final StorageAwareResource resource, final IFileSystemAccessExtension3 fsa);
  
  /**
   * Creates a fresh ResourceStorageWritable wrapping the given OutputStream
   */
  public abstract ResourceStorageWritable createResourceStorageWritable(final OutputStream outputStream);
  
  /**
   * Creates a fresh ResourceStorageLoadable wrapping the given InputStream
   */
  public abstract ResourceStorageLoadable createResourceStorageLoadable(final InputStream inputStream);
}
