/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.syntaxColoring;

import java.util.List;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Representation of a range and highlighting style identifiers that should be
 * highlighted based on semantic information of the underlying model.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@SuppressWarnings("all")
public class SemanticHighlightInformation {
  /**
   * The range that should be highlighted on the client-side.
   */
  private Range range;
  
  /**
   * A list of highlighting style identifiers, that should be applied on
   * the range. Several styles could be merged on the client-side by
   * applying all styles on the range.
   */
  private List<String> ids;
  
  /**
   * The range that should be highlighted on the client-side.
   */
  @Pure
  public Range getRange() {
    return this.range;
  }
  
  /**
   * The range that should be highlighted on the client-side.
   */
  public void setRange(final Range range) {
    this.range = range;
  }
  
  /**
   * A list of highlighting style identifiers, that should be applied on
   * the range. Several styles could be merged on the client-side by
   * applying all styles on the range.
   */
  @Pure
  public List<String> getIds() {
    return this.ids;
  }
  
  /**
   * A list of highlighting style identifiers, that should be applied on
   * the range. Several styles could be merged on the client-side by
   * applying all styles on the range.
   */
  public void setIds(final List<String> ids) {
    this.ids = ids;
  }
  
  public SemanticHighlightInformation() {
    
  }
  
  public SemanticHighlightInformation(final Range range, final List<String> ids) {
    this.range = range;
    this.ids = ids;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("range", this.range);
    b.add("ids", this.ids);
    return b.toString();
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
    if (!super.equals(obj))
      return false;
    SemanticHighlightInformation other = (SemanticHighlightInformation) obj;
    if (this.range == null) {
      if (other.range != null)
        return false;
    } else if (!this.range.equals(other.range))
      return false;
    if (this.ids == null) {
      if (other.ids != null)
        return false;
    } else if (!this.ids.equals(other.ids))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.range== null) ? 0 : this.range.hashCode());
    result = prime * result + ((this.ids== null) ? 0 : this.ids.hashCode());
    return result;
  }
}
