/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.typesystem.references;

import com.google.common.base.Objects;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentSource;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
@SuppressWarnings("all")
public class LightweightBoundTypeArgument {
  private final LightweightTypeReference _typeReference;
  
  public LightweightTypeReference getTypeReference() {
    return this._typeReference;
  }
  
  private final BoundTypeArgumentSource _source;
  
  public BoundTypeArgumentSource getSource() {
    return this._source;
  }
  
  private final Object _origin;
  
  public Object getOrigin() {
    return this._origin;
  }
  
  private final VarianceInfo _declaredVariance;
  
  public VarianceInfo getDeclaredVariance() {
    return this._declaredVariance;
  }
  
  private final VarianceInfo _actualVariance;
  
  public VarianceInfo getActualVariance() {
    return this._actualVariance;
  }
  
  public boolean isValidVariancePair() {
    VarianceInfo _declaredVariance = this.getDeclaredVariance();
    VarianceInfo _actualVariance = this.getActualVariance();
    VarianceInfo _mergeDeclaredWithActual = _declaredVariance.mergeDeclaredWithActual(_actualVariance);
    return (!Objects.equal(_mergeDeclaredWithActual, null));
  }
  
  public LightweightBoundTypeArgument(final LightweightTypeReference typeReference, final BoundTypeArgumentSource source, final Object origin, final VarianceInfo declaredVariance, final VarianceInfo actualVariance) {
    super();
    this._typeReference = typeReference;
    this._source = source;
    this._origin = origin;
    this._declaredVariance = declaredVariance;
    this._actualVariance = actualVariance;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_typeReference== null) ? 0 : _typeReference.hashCode());
    result = prime * result + ((_source== null) ? 0 : _source.hashCode());
    result = prime * result + ((_origin== null) ? 0 : _origin.hashCode());
    result = prime * result + ((_declaredVariance== null) ? 0 : _declaredVariance.hashCode());
    result = prime * result + ((_actualVariance== null) ? 0 : _actualVariance.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LightweightBoundTypeArgument other = (LightweightBoundTypeArgument) obj;
    if (_typeReference == null) {
      if (other._typeReference != null)
        return false;
    } else if (!_typeReference.equals(other._typeReference))
      return false;
    if (_source == null) {
      if (other._source != null)
        return false;
    } else if (!_source.equals(other._source))
      return false;
    if (_origin == null) {
      if (other._origin != null)
        return false;
    } else if (!_origin.equals(other._origin))
      return false;
    if (_declaredVariance == null) {
      if (other._declaredVariance != null)
        return false;
    } else if (!_declaredVariance.equals(other._declaredVariance))
      return false;
    if (_actualVariance == null) {
      if (other._actualVariance != null)
        return false;
    } else if (!_actualVariance.equals(other._actualVariance))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
