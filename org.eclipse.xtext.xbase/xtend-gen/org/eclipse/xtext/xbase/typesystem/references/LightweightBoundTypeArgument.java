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
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * Encapsulates the information that is collected as a type hint to later resolve an
 * unbound type reference.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class LightweightBoundTypeArgument {
  private final LightweightTypeReference typeReference;
  
  private final BoundTypeArgumentSource source;
  
  private final Object origin;
  
  private final VarianceInfo declaredVariance;
  
  private final VarianceInfo actualVariance;
  
  public boolean isValidVariancePair() {
    VarianceInfo _mergeDeclaredWithActual = this.declaredVariance.mergeDeclaredWithActual(this.actualVariance);
    return (_mergeDeclaredWithActual != null);
  }
  
  public LightweightBoundTypeArgument(final LightweightTypeReference typeReference, final BoundTypeArgumentSource source, final Object origin, final VarianceInfo declaredVariance, final VarianceInfo actualVariance) {
    super();
    this.typeReference = typeReference;
    this.source = source;
    this.origin = origin;
    this.declaredVariance = declaredVariance;
    this.actualVariance = actualVariance;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.typeReference== null) ? 0 : this.typeReference.hashCode());
    result = prime * result + ((this.source== null) ? 0 : this.source.hashCode());
    result = prime * result + ((this.origin== null) ? 0 : this.origin.hashCode());
    result = prime * result + ((this.declaredVariance== null) ? 0 : this.declaredVariance.hashCode());
    return prime * result + ((this.actualVariance== null) ? 0 : this.actualVariance.hashCode());
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
    LightweightBoundTypeArgument other = (LightweightBoundTypeArgument) obj;
    if (this.typeReference == null) {
      if (other.typeReference != null)
        return false;
    } else if (!this.typeReference.equals(other.typeReference))
      return false;
    if (this.source == null) {
      if (other.source != null)
        return false;
    } else if (!this.source.equals(other.source))
      return false;
    if (this.origin == null) {
      if (other.origin != null)
        return false;
    } else if (!this.origin.equals(other.origin))
      return false;
    if (this.declaredVariance == null) {
      if (other.declaredVariance != null)
        return false;
    } else if (!this.declaredVariance.equals(other.declaredVariance))
      return false;
    if (this.actualVariance == null) {
      if (other.actualVariance != null)
        return false;
    } else if (!this.actualVariance.equals(other.actualVariance))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("typeReference", this.typeReference);
    b.add("source", this.source);
    b.add("origin", this.origin);
    b.add("declaredVariance", this.declaredVariance);
    b.add("actualVariance", this.actualVariance);
    return b.toString();
  }
  
  @Pure
  public LightweightTypeReference getTypeReference() {
    return this.typeReference;
  }
  
  @Pure
  public BoundTypeArgumentSource getSource() {
    return this.source;
  }
  
  @Pure
  public Object getOrigin() {
    return this.origin;
  }
  
  @Pure
  public VarianceInfo getDeclaredVariance() {
    return this.declaredVariance;
  }
  
  @Pure
  public VarianceInfo getActualVariance() {
    return this.actualVariance;
  }
}
