/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.build;

import com.intellij.openapi.vfs.VirtualFile;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author koehnlein - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class BuildEvent {
  public enum Type {
    DELETED,
    
    MODIFIED,
    
    ADDED;
  }
  
  private final VirtualFile file;
  
  private final BuildEvent.Type type;
  
  public BuildEvent(final VirtualFile file, final BuildEvent.Type type) {
    super();
    this.file = file;
    this.type = type;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.file== null) ? 0 : this.file.hashCode());
    result = prime * result + ((this.type== null) ? 0 : this.type.hashCode());
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
    BuildEvent other = (BuildEvent) obj;
    if (this.file == null) {
      if (other.file != null)
        return false;
    } else if (!this.file.equals(other.file))
      return false;
    if (this.type == null) {
      if (other.type != null)
        return false;
    } else if (!this.type.equals(other.type))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("file", this.file);
    b.add("type", this.type);
    return b.toString();
  }
  
  @Pure
  public VirtualFile getFile() {
    return this.file;
  }
  
  @Pure
  public BuildEvent.Type getType() {
    return this.type;
  }
}
