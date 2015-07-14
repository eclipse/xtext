/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.contentassist;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the content assist service.
 */
@Data
@ToString(skipNulls = true)
@SuppressWarnings("all")
public class ContentAssistResult implements IServiceResult {
  private final String stateId;
  
  private final List<ContentAssistEntry> entries = CollectionLiterals.<ContentAssistEntry>newArrayList();
  
  public ContentAssistResult(final String stateId) {
    super();
    this.stateId = stateId;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.stateId== null) ? 0 : this.stateId.hashCode());
    result = prime * result + ((this.entries== null) ? 0 : this.entries.hashCode());
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
    ContentAssistResult other = (ContentAssistResult) obj;
    if (this.stateId == null) {
      if (other.stateId != null)
        return false;
    } else if (!this.stateId.equals(other.stateId))
      return false;
    if (this.entries == null) {
      if (other.entries != null)
        return false;
    } else if (!this.entries.equals(other.entries))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.skipNulls();
    b.add("stateId", this.stateId);
    b.add("entries", this.entries);
    return b.toString();
  }
  
  @Pure
  public String getStateId() {
    return this.stateId;
  }
  
  @Pure
  public List<ContentAssistEntry> getEntries() {
    return this.entries;
  }
}
