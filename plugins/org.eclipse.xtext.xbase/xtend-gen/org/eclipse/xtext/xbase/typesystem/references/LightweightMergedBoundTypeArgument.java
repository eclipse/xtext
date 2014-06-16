/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
@SuppressWarnings("all")
public class LightweightMergedBoundTypeArgument {
  private final LightweightTypeReference _typeReference;
  
  private final VarianceInfo _variance;
  
  public LightweightMergedBoundTypeArgument(final LightweightTypeReference typeReference, final VarianceInfo variance) {
    super();
    this._typeReference = typeReference;
    this._variance = variance;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._typeReference== null) ? 0 : this._typeReference.hashCode());
    result = prime * result + ((this._variance== null) ? 0 : this._variance.hashCode());
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
    LightweightMergedBoundTypeArgument other = (LightweightMergedBoundTypeArgument) obj;
    if (this._typeReference == null) {
      if (other._typeReference != null)
        return false;
    } else if (!this._typeReference.equals(other._typeReference))
      return false;
    if (this._variance == null) {
      if (other._variance != null)
        return false;
    } else if (!this._variance.equals(other._variance))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
  
  @Pure
  public LightweightTypeReference getTypeReference() {
    return this._typeReference;
  }
  
  @Pure
  public VarianceInfo getVariance() {
    return this._variance;
  }
}
