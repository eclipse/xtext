/**
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;

/**
 * Small utility data structure to carry around in the type reference visitors.
 * May help to guard against infinite recursion and to collect type parameter data.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class LightweightTraversalData {
  private final Set<JvmType> visited = CollectionLiterals.<JvmType>newHashSet();
  
  private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = CollectionLiterals.<JvmTypeParameter, LightweightMergedBoundTypeArgument>newLinkedHashMap();
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.visited== null) ? 0 : this.visited.hashCode());
    return prime * result + ((this.typeParameterMapping== null) ? 0 : this.typeParameterMapping.hashCode());
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
    if (this.visited == null) {
      if (other.visited != null)
        return false;
    } else if (!this.visited.equals(other.visited))
      return false;
    if (this.typeParameterMapping == null) {
      if (other.typeParameterMapping != null)
        return false;
    } else if (!this.typeParameterMapping.equals(other.typeParameterMapping))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("visited", this.visited);
    b.add("typeParameterMapping", this.typeParameterMapping);
    return b.toString();
  }
  
  @Pure
  public Set<JvmType> getVisited() {
    return this.visited;
  }
  
  @Pure
  public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
    return this.typeParameterMapping;
  }
}
