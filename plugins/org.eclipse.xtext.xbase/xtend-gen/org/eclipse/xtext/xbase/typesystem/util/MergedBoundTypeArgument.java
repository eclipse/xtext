package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
@SuppressWarnings("all")
public class MergedBoundTypeArgument {
  private final JvmTypeReference _typeReference;
  
  public JvmTypeReference getTypeReference() {
    return this._typeReference;
  }
  
  private final VarianceInfo _variance;
  
  public VarianceInfo getVariance() {
    return this._variance;
  }
  
  public MergedBoundTypeArgument(final JvmTypeReference typeReference, final VarianceInfo variance) {
    super();
    this._typeReference = typeReference;
    this._variance = variance;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((_typeReference== null) ? 0 : _typeReference.hashCode());
    result = prime * result + ((_variance== null) ? 0 : _variance.hashCode());
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
    MergedBoundTypeArgument other = (MergedBoundTypeArgument) obj;
    if (_typeReference == null) {
      if (other._typeReference != null)
        return false;
    } else if (!_typeReference.equals(other._typeReference))
      return false;
    if (_variance == null) {
      if (other._variance != null)
        return false;
    } else if (!_variance.equals(other._variance))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
