/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class PsiTokenStreamState {
  private final String errorMessage;
  
  private final IElementType tokenType;
  
  private final PsiBuilder.Marker marker;
  
  public PsiTokenStreamState(final String errorMessage, final IElementType tokenType, final PsiBuilder.Marker marker) {
    super();
    this.errorMessage = errorMessage;
    this.tokenType = tokenType;
    this.marker = marker;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.errorMessage== null) ? 0 : this.errorMessage.hashCode());
    result = prime * result + ((this.tokenType== null) ? 0 : this.tokenType.hashCode());
    result = prime * result + ((this.marker== null) ? 0 : this.marker.hashCode());
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
    PsiTokenStreamState other = (PsiTokenStreamState) obj;
    if (this.errorMessage == null) {
      if (other.errorMessage != null)
        return false;
    } else if (!this.errorMessage.equals(other.errorMessage))
      return false;
    if (this.tokenType == null) {
      if (other.tokenType != null)
        return false;
    } else if (!this.tokenType.equals(other.tokenType))
      return false;
    if (this.marker == null) {
      if (other.marker != null)
        return false;
    } else if (!this.marker.equals(other.marker))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("errorMessage", this.errorMessage);
    b.add("tokenType", this.tokenType);
    b.add("marker", this.marker);
    return b.toString();
  }
  
  @Pure
  public String getErrorMessage() {
    return this.errorMessage;
  }
  
  @Pure
  public IElementType getTokenType() {
    return this.tokenType;
  }
  
  @Pure
  public PsiBuilder.Marker getMarker() {
    return this.marker;
  }
}
