/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.validation;

import java.util.ArrayList;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the validation service.
 */
@Accessors
@ToString(skipNulls = true)
@SuppressWarnings("all")
public class ValidationResult implements IServiceResult {
  @Data
  @ToString(skipNulls = true)
  public static class Entry {
    private final String description;
    
    private final String severity;
    
    private final Integer line;
    
    private final Integer startOffset;
    
    private final Integer endOffset;
    
    public Entry(final String description, final String severity, final Integer line, final Integer startOffset, final Integer endOffset) {
      super();
      this.description = description;
      this.severity = severity;
      this.line = line;
      this.startOffset = startOffset;
      this.endOffset = endOffset;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.description== null) ? 0 : this.description.hashCode());
      result = prime * result + ((this.severity== null) ? 0 : this.severity.hashCode());
      result = prime * result + ((this.line== null) ? 0 : this.line.hashCode());
      result = prime * result + ((this.startOffset== null) ? 0 : this.startOffset.hashCode());
      result = prime * result + ((this.endOffset== null) ? 0 : this.endOffset.hashCode());
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
      ValidationResult.Entry other = (ValidationResult.Entry) obj;
      if (this.description == null) {
        if (other.description != null)
          return false;
      } else if (!this.description.equals(other.description))
        return false;
      if (this.severity == null) {
        if (other.severity != null)
          return false;
      } else if (!this.severity.equals(other.severity))
        return false;
      if (this.line == null) {
        if (other.line != null)
          return false;
      } else if (!this.line.equals(other.line))
        return false;
      if (this.startOffset == null) {
        if (other.startOffset != null)
          return false;
      } else if (!this.startOffset.equals(other.startOffset))
        return false;
      if (this.endOffset == null) {
        if (other.endOffset != null)
          return false;
      } else if (!this.endOffset.equals(other.endOffset))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.skipNulls();
      b.add("description", this.description);
      b.add("severity", this.severity);
      b.add("line", this.line);
      b.add("startOffset", this.startOffset);
      b.add("endOffset", this.endOffset);
      return b.toString();
    }
    
    @Pure
    public String getDescription() {
      return this.description;
    }
    
    @Pure
    public String getSeverity() {
      return this.severity;
    }
    
    @Pure
    public Integer getLine() {
      return this.line;
    }
    
    @Pure
    public Integer getStartOffset() {
      return this.startOffset;
    }
    
    @Pure
    public Integer getEndOffset() {
      return this.endOffset;
    }
  }
  
  private final ArrayList<ValidationResult.Entry> entries = new ArrayList<ValidationResult.Entry>();
  
  @Pure
  public ArrayList<ValidationResult.Entry> getEntries() {
    return this.entries;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.skipNulls();
    b.add("entries", this.entries);
    return b.toString();
  }
}
