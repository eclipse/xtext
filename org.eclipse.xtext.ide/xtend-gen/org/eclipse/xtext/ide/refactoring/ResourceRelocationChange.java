/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * URIs can also refer to folders and non-Xtext resources.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
@SuppressWarnings("all")
public class ResourceRelocationChange {
  private final URI fromURI;
  
  private final URI toURI;
  
  private final boolean isFile;
  
  public ResourceRelocationChange(final URI fromURI, final URI toURI, final boolean isFile) {
    super();
    this.fromURI = fromURI;
    this.toURI = toURI;
    this.isFile = isFile;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.fromURI== null) ? 0 : this.fromURI.hashCode());
    result = prime * result + ((this.toURI== null) ? 0 : this.toURI.hashCode());
    result = prime * result + (this.isFile ? 1231 : 1237);
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
    ResourceRelocationChange other = (ResourceRelocationChange) obj;
    if (this.fromURI == null) {
      if (other.fromURI != null)
        return false;
    } else if (!this.fromURI.equals(other.fromURI))
      return false;
    if (this.toURI == null) {
      if (other.toURI != null)
        return false;
    } else if (!this.toURI.equals(other.toURI))
      return false;
    if (other.isFile != this.isFile)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("fromURI", this.fromURI);
    b.add("toURI", this.toURI);
    b.add("isFile", this.isFile);
    return b.toString();
  }
  
  @Pure
  public URI getFromURI() {
    return this.fromURI;
  }
  
  @Pure
  public URI getToURI() {
    return this.toURI;
  }
  
  @Pure
  public boolean isFile() {
    return this.isFile;
  }
}
