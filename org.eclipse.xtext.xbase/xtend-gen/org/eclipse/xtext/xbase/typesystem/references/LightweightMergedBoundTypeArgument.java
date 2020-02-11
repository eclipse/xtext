/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * The result of a merge operation where different type bound type arguments are incorporated into
 * a result.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class LightweightMergedBoundTypeArgument {
  private final LightweightTypeReference typeReference;
  
  private final VarianceInfo variance;
  
  public LightweightMergedBoundTypeArgument(final LightweightTypeReference typeReference, final VarianceInfo variance) {
    super();
    this.typeReference = typeReference;
    this.variance = variance;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.typeReference== null) ? 0 : this.typeReference.hashCode());
    return prime * result + ((this.variance== null) ? 0 : this.variance.hashCode());
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
    if (this.typeReference == null) {
      if (other.typeReference != null)
        return false;
    } else if (!this.typeReference.equals(other.typeReference))
      return false;
    if (this.variance == null) {
      if (other.variance != null)
        return false;
    } else if (!this.variance.equals(other.variance))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("typeReference", this.typeReference);
    b.add("variance", this.variance);
    return b.toString();
  }
  
  @Pure
  public LightweightTypeReference getTypeReference() {
    return this.typeReference;
  }
  
  @Pure
  public VarianceInfo getVariance() {
    return this.variance;
  }
}
