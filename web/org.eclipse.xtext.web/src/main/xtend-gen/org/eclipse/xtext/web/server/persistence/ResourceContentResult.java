/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.persistence;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by load and revert services.
 */
@Data
@SuppressWarnings("all")
public class ResourceContentResult implements IServiceResult {
  private final String fullText;
  
  private final String stateId;
  
  private final boolean dirty;
  
  public ResourceContentResult(final String fullText, final String stateId, final boolean dirty) {
    super();
    this.fullText = fullText;
    this.stateId = stateId;
    this.dirty = dirty;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.fullText== null) ? 0 : this.fullText.hashCode());
    result = prime * result + ((this.stateId== null) ? 0 : this.stateId.hashCode());
    result = prime * result + (this.dirty ? 1231 : 1237);
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
    ResourceContentResult other = (ResourceContentResult) obj;
    if (this.fullText == null) {
      if (other.fullText != null)
        return false;
    } else if (!this.fullText.equals(other.fullText))
      return false;
    if (this.stateId == null) {
      if (other.stateId != null)
        return false;
    } else if (!this.stateId.equals(other.stateId))
      return false;
    if (other.dirty != this.dirty)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("fullText", this.fullText);
    b.add("stateId", this.stateId);
    b.add("dirty", this.dirty);
    return b.toString();
  }
  
  @Pure
  public String getFullText() {
    return this.fullText;
  }
  
  @Pure
  public String getStateId() {
    return this.stateId;
  }
  
  @Pure
  public boolean isDirty() {
    return this.dirty;
  }
}
