/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.validation;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the validation service.
 */
@Data
@SuppressWarnings("all")
public class ValidationResult implements IServiceResult {
  @Data
  @ToString(skipNulls = true)
  public static class Issue {
    private final String description;
    
    private final String severity;
    
    /**
     * One based, the first line has the number 1.
     */
    private final Integer line;
    
    /**
     * One based, the first column in a line has the number 1.
     */
    private final Integer column;
    
    /**
     * Zero based, the first char in a document has the offset 0.
     */
    private final Integer offset;
    
    private final Integer length;
    
    public Issue(final String description, final String severity, final Integer line, final Integer column, final Integer offset, final Integer length) {
      super();
      this.description = description;
      this.severity = severity;
      this.line = line;
      this.column = column;
      this.offset = offset;
      this.length = length;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.description== null) ? 0 : this.description.hashCode());
      result = prime * result + ((this.severity== null) ? 0 : this.severity.hashCode());
      result = prime * result + ((this.line== null) ? 0 : this.line.hashCode());
      result = prime * result + ((this.column== null) ? 0 : this.column.hashCode());
      result = prime * result + ((this.offset== null) ? 0 : this.offset.hashCode());
      result = prime * result + ((this.length== null) ? 0 : this.length.hashCode());
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
      ValidationResult.Issue other = (ValidationResult.Issue) obj;
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
      if (this.column == null) {
        if (other.column != null)
          return false;
      } else if (!this.column.equals(other.column))
        return false;
      if (this.offset == null) {
        if (other.offset != null)
          return false;
      } else if (!this.offset.equals(other.offset))
        return false;
      if (this.length == null) {
        if (other.length != null)
          return false;
      } else if (!this.length.equals(other.length))
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
      b.add("column", this.column);
      b.add("offset", this.offset);
      b.add("length", this.length);
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
    public Integer getColumn() {
      return this.column;
    }
    
    @Pure
    public Integer getOffset() {
      return this.offset;
    }
    
    @Pure
    public Integer getLength() {
      return this.length;
    }
  }
  
  private final List<ValidationResult.Issue> issues = CollectionLiterals.<ValidationResult.Issue>newArrayList();
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.issues== null) ? 0 : this.issues.hashCode());
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
    ValidationResult other = (ValidationResult) obj;
    if (this.issues == null) {
      if (other.issues != null)
        return false;
    } else if (!this.issues.equals(other.issues))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("issues", this.issues);
    return b.toString();
  }
  
  @Pure
  public List<ValidationResult.Issue> getIssues() {
    return this.issues;
  }
}
