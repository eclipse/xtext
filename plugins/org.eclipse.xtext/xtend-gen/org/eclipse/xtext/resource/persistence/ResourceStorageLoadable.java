/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Map;
import java.util.zip.ZipInputStream;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
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
public class ResourceStorageLoadable {
  private final static Logger LOG = Logger.getLogger(ResourceStorageLoadable.class);
  
  private final InputStream in;
  
  protected void loadIntoResource(final StorageAwareResource resource) {
    try {
      boolean _isLoadedFromStorage = resource.isLoadedFromStorage();
      boolean _not = (!_isLoadedFromStorage);
      if (_not) {
        throw new IllegalStateException("Please use StorageAwareResource#load(ResourceStorageLoadable).");
      }
      final ZipInputStream zin = new ZipInputStream(this.in);
      try {
        this.loadEntries(resource, zin);
      } finally {
        zin.close();
      }
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        URI _uRI = resource.getURI();
        String _plus = ("Problem loading storage for " + _uRI);
        String _plus_1 = (_plus + ". Error was:");
        String _message = e.getMessage();
        String _plus_2 = (_plus_1 + _message);
        ResourceStorageLoadable.LOG.error(_plus_2, e);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * Load entries from the storage.
   * Overriding methods should first delegate to super before adding their own entries.
   */
  protected void loadEntries(final StorageAwareResource resource, final ZipInputStream zipIn) {
    this.readContents(resource, zipIn);
    this.readResourceDescription(resource, zipIn);
  }
  
  protected void readResourceDescription(final StorageAwareResource resource, final ZipInputStream zipIn) {
    try {
      zipIn.getNextEntry();
      final ObjectInputStream objectIn = new ObjectInputStream(zipIn);
      Object _readObject = objectIn.readObject();
      final SerializableResourceDescription description = ((SerializableResourceDescription) _readObject);
      URI _uRI = resource.getURI();
      description.updateResourceURI(_uRI);
      resource.setResourceDescription(description);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void readContents(final StorageAwareResource resource, final ZipInputStream zipIn) {
    try {
      zipIn.getNextEntry();
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      final BinaryResourceImpl.EObjectInputStream in = new BinaryResourceImpl.EObjectInputStream(zipIn, _emptyMap) {
        public int readCompressedInt() throws IOException {
          int _xblockexpression = (int) 0;
          {
            this.resourceSet = null;
            _xblockexpression = super.readCompressedInt();
          }
          return _xblockexpression;
        }
      };
      in.loadResource(resource);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResourceStorageLoadable(final InputStream in) {
    super();
    this.in = in;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.in== null) ? 0 : this.in.hashCode());
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
    ResourceStorageLoadable other = (ResourceStorageLoadable) obj;
    if (this.in == null) {
      if (other.in != null)
        return false;
    } else if (!this.in.equals(other.in))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("in", this.in);
    return b.toString();
  }
  
  @Pure
  public InputStream getIn() {
    return this.in;
  }
}
