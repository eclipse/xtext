/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

@Data
@SuppressWarnings("all")
public class FileInfo {
  private final String _uri;
  
  private final String _contents;
  
  public FileInfo(final String uri, final String contents) {
    super();
    this._uri = uri;
    this._contents = contents;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._uri== null) ? 0 : this._uri.hashCode());
    result = prime * result + ((this._contents== null) ? 0 : this._contents.hashCode());
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
    FileInfo other = (FileInfo) obj;
    if (this._uri == null) {
      if (other._uri != null)
        return false;
    } else if (!this._uri.equals(other._uri))
      return false;
    if (this._contents == null) {
      if (other._contents != null)
        return false;
    } else if (!this._contents.equals(other._contents))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
  
  @Pure
  public String getUri() {
    return this._uri;
  }
  
  @Pure
  public String getContents() {
    return this._contents;
  }
}
