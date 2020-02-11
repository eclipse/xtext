/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.scoping.batch.TypeBucket;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;

/**
 * A type bucket that 'exports' only a subset of all named features of
 * the contained types.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class TypeWithRestrictedNamesBucket extends TypeBucket {
  private final Map<? extends JvmType, ? extends Set<String>> typesToNames;
  
  public TypeWithRestrictedNamesBucket(final int id, final Map<? extends JvmType, ? extends Set<String>> types, final IResolvedFeatures.Provider resolvedFeaturesProvider) {
    super(id, null, resolvedFeaturesProvider);
    this.typesToNames = types;
  }
  
  @Override
  public boolean isRestrictingNames() {
    return true;
  }
  
  @Override
  public List<? extends JvmType> getTypes() {
    Set<? extends JvmType> _keySet = this.typesToNames.keySet();
    return new ArrayList<JvmType>(_keySet);
  }
  
  @Override
  @Pure
  public int hashCode() {
    return 31 * super.hashCode() + ((this.typesToNames== null) ? 0 : this.typesToNames.hashCode());
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
    TypeWithRestrictedNamesBucket other = (TypeWithRestrictedNamesBucket) obj;
    if (this.typesToNames == null) {
      if (other.typesToNames != null)
        return false;
    } else if (!this.typesToNames.equals(other.typesToNames))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    return new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
  }
  
  @Pure
  public Map<? extends JvmType, ? extends Set<String>> getTypesToNames() {
    return this.typesToNames;
  }
}
