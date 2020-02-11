/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.refactoring;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
@SuppressWarnings("all")
public class RenameChange {
  private final String newName;
  
  private final URI targetURI;
  
  public RenameChange(final String newName, final URI targetURI) {
    super();
    this.newName = newName;
    this.targetURI = targetURI;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.newName== null) ? 0 : this.newName.hashCode());
    return prime * result + ((this.targetURI== null) ? 0 : this.targetURI.hashCode());
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
    RenameChange other = (RenameChange) obj;
    if (this.newName == null) {
      if (other.newName != null)
        return false;
    } else if (!this.newName.equals(other.newName))
      return false;
    if (this.targetURI == null) {
      if (other.targetURI != null)
        return false;
    } else if (!this.targetURI.equals(other.targetURI))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("newName", this.newName);
    b.add("targetURI", this.targetURI);
    return b.toString();
  }
  
  @Pure
  public String getNewName() {
    return this.newName;
  }
  
  @Pure
  public URI getTargetURI() {
    return this.targetURI;
  }
}
