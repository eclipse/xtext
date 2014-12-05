/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.SerializableResourceDescription;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class ResourceStorageOutputStream {
  private final static Logger LOG = Logger.getLogger(ResourceStorageOutputStream.class);
  
  private final OutputStream out;
  
  public void writeResource(final StorageAwareResource resource) {
    try {
      final ZipOutputStream zipOut = new ZipOutputStream(this.out);
      this.writeEntries(resource, zipOut);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        String _message = e.getMessage();
        ResourceStorageOutputStream.LOG.error(_message, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Write entries into the storage.
   * Overriding methods should first delegate to super before adding their own entries.
   */
  protected void writeEntries(final StorageAwareResource resource, final ZipOutputStream zipOut) {
    this.writeContents(resource, zipOut);
    this.writeResourceDescription(resource, zipOut);
  }
  
  protected void writeContents(final StorageAwareResource resource, final ZipOutputStream zipOut) {
    try {
      ZipEntry _zipEntry = new ZipEntry("emf-contents");
      zipOut.putNextEntry(_zipEntry);
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      final BinaryResourceImpl.EObjectOutputStream out = new BinaryResourceImpl.EObjectOutputStream(zipOut, _emptyMap);
      try {
        out.saveResource(resource);
      } finally {
        out.flush();
      }
      zipOut.closeEntry();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void writeResourceDescription(final StorageAwareResource resource, final ZipOutputStream zipOut) {
    try {
      ZipEntry _zipEntry = new ZipEntry("resource-description");
      zipOut.putNextEntry(_zipEntry);
      IResourceServiceProvider _resourceServiceProvider = resource.getResourceServiceProvider();
      IResourceDescription.Manager _resourceDescriptionManager = _resourceServiceProvider.getResourceDescriptionManager();
      final IResourceDescription description = _resourceDescriptionManager.getResourceDescription(resource);
      final SerializableResourceDescription serializableDescription = SerializableResourceDescription.createCopy(description);
      final ObjectOutputStream out = new ObjectOutputStream(zipOut);
      out.writeObject(serializableDescription);
      zipOut.closeEntry();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResourceStorageOutputStream(final OutputStream out) {
    super();
    this.out = out;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.out== null) ? 0 : this.out.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ResourceStorageOutputStream other = (ResourceStorageOutputStream) obj;
    if (this.out == null) {
      if (other.out != null)
        return false;
    } else if (!this.out.equals(other.out))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("out", this.out);
    return b.toString();
  }
  
  @Pure
  public OutputStream getOut() {
    return this.out;
  }
}
