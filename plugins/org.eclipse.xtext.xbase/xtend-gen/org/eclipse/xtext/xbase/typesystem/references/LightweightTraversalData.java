/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Data
@SuppressWarnings("all")
public class LightweightTraversalData {
  private final Set<JvmType> _visited = CollectionLiterals.<JvmType>newHashSet();
  
  private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> _typeParameterMapping = CollectionLiterals.<JvmTypeParameter, LightweightMergedBoundTypeArgument>newLinkedHashMap();
  
  public LightweightTraversalData() {
    super();
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._visited== null) ? 0 : this._visited.hashCode());
    result = prime * result + ((this._typeParameterMapping== null) ? 0 : this._typeParameterMapping.hashCode());
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
    LightweightTraversalData other = (LightweightTraversalData) obj;
    if (this._visited == null) {
      if (other._visited != null)
        return false;
    } else if (!this._visited.equals(other._visited))
      return false;
    if (this._typeParameterMapping == null) {
      if (other._typeParameterMapping != null)
        return false;
    } else if (!this._typeParameterMapping.equals(other._typeParameterMapping))
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
  public Set<JvmType> getVisited() {
    return this._visited;
  }
  
  @Pure
  public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
    return this._typeParameterMapping;
  }
}
