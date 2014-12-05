/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.persistence;

import java.io.InputStream;
import java.util.Map;
import java.util.zip.ZipInputStream;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.xtend.lib.annotations.Data;
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
public class ResourceStorageInputStream {
  private final InputStream in;
  
  public void loadIntoResource(final StorageAwareResource resource) {
    final ZipInputStream zin = new ZipInputStream(this.in);
    this.loadEntries(resource, zin);
  }
  
  /**
   * Load entries from the storage.
   * Overriding methods should first delegate to super before adding their own entries.
   */
  protected void loadEntries(final StorageAwareResource resource, final ZipInputStream zipIn) {
    try {
      zipIn.getNextEntry();
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      final BinaryResourceImpl.EObjectInputStream in = new BinaryResourceImpl.EObjectInputStream(zipIn, _emptyMap);
      in.loadResource(resource);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ResourceStorageInputStream(final InputStream in) {
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
    ResourceStorageInputStream other = (ResourceStorageInputStream) obj;
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
