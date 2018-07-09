/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.wizard;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.15
 */
@Data
@SuppressWarnings("all")
public class SourceFolderDescriptor {
  private final String path;
  
  private final boolean test;
  
  public SourceFolderDescriptor(final String path, final boolean test) {
    super();
    this.path = path;
    this.test = test;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.path== null) ? 0 : this.path.hashCode());
    return prime * result + (this.test ? 1231 : 1237);
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
    SourceFolderDescriptor other = (SourceFolderDescriptor) obj;
    if (this.path == null) {
      if (other.path != null)
        return false;
    } else if (!this.path.equals(other.path))
      return false;
    if (other.test != this.test)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("path", this.path);
    b.add("test", this.test);
    return b.toString();
  }
  
  @Pure
  public String getPath() {
    return this.path;
  }
  
  @Pure
  public boolean isTest() {
    return this.test;
  }
}
