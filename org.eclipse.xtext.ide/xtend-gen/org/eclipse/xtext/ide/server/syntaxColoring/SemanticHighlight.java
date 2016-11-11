/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server.syntaxColoring;

import java.util.List;
import org.eclipse.xtext.ide.server.syntaxColoring.SemanticHighlightInformation;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Representation of a computed mapping from ranges to the appropriate
 * highlighting style.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@SuppressWarnings("all")
public class SemanticHighlight {
  /**
   * A list of semantic highlight information.
   */
  private List<? extends SemanticHighlightInformation> infos;
  
  /**
   * A list of semantic highlight information.
   */
  @Pure
  public List<? extends SemanticHighlightInformation> getInfos() {
    return this.infos;
  }
  
  /**
   * A list of semantic highlight information.
   */
  public void setInfos(final List<? extends SemanticHighlightInformation> infos) {
    this.infos = infos;
  }
  
  public SemanticHighlight() {
    
  }
  
  public SemanticHighlight(final List<? extends SemanticHighlightInformation> infos) {
    this.infos = infos;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("infos", this.infos);
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
    SemanticHighlight other = (SemanticHighlight) obj;
    if (this.infos == null) {
      if (other.infos != null)
        return false;
    } else if (!this.infos.equals(other.infos))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.infos== null) ? 0 : this.infos.hashCode());
    return result;
  }
}
