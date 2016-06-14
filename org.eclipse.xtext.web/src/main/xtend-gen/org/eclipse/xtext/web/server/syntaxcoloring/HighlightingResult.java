/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.syntaxcoloring;

import java.util.Arrays;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.annotations.ToString;
import org.eclipse.xtext.web.server.IServiceResult;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Result object returned by the highlighting service.
 */
@Data
@SuppressWarnings("all")
public class HighlightingResult implements IServiceResult {
  @Data
  @ToString(singleLine = true)
  public static class Region {
    private final int offset;
    
    private final int length;
    
    private final String[] styleClasses;
    
    public Region(final int offset, final int length, final String[] styleClasses) {
      super();
      this.offset = offset;
      this.length = length;
      this.styleClasses = styleClasses;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + this.offset;
      result = prime * result + this.length;
      result = prime * result + ((this.styleClasses== null) ? 0 : Arrays.deepHashCode(this.styleClasses));
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
      HighlightingResult.Region other = (HighlightingResult.Region) obj;
      if (other.offset != this.offset)
        return false;
      if (other.length != this.length)
        return false;
      if (this.styleClasses == null) {
        if (other.styleClasses != null)
          return false;
      } else if (!Arrays.deepEquals(this.styleClasses, other.styleClasses))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.singleLine();
      b.add("offset", this.offset);
      b.add("length", this.length);
      b.add("styleClasses", this.styleClasses);
      return b.toString();
    }
    
    @Pure
    public int getOffset() {
      return this.offset;
    }
    
    @Pure
    public int getLength() {
      return this.length;
    }
    
    @Pure
    public String[] getStyleClasses() {
      return this.styleClasses;
    }
  }
  
  private final List<HighlightingResult.Region> regions = CollectionLiterals.<HighlightingResult.Region>newArrayList();
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.regions== null) ? 0 : this.regions.hashCode());
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
    HighlightingResult other = (HighlightingResult) obj;
    if (this.regions == null) {
      if (other.regions != null)
        return false;
    } else if (!this.regions.equals(other.regions))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("regions", this.regions);
    return b.toString();
  }
  
  @Pure
  public List<HighlightingResult.Region> getRegions() {
    return this.regions;
  }
}
