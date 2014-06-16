/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
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
  private final Map<? extends JvmType, ? extends Set<String>> _typesToNames;
  
  public TypeWithRestrictedNamesBucket(final int id, final Map<? extends JvmType, ? extends Set<String>> types, final IResolvedFeatures.Provider resolvedFeaturesProvider) {
    super(id, null, resolvedFeaturesProvider);
    this._typesToNames = types;
  }
  
  public boolean isRestrictingNames() {
    return true;
  }
  
  public List<? extends JvmType> getTypes() {
    Map<? extends JvmType, ? extends Set<String>> _typesToNames = this.getTypesToNames();
    Set<? extends JvmType> _keySet = _typesToNames.keySet();
    return new ArrayList<JvmType>(_keySet);
  }
  
  public TypeWithRestrictedNamesBucket(final int id, final List<? extends JvmType> types, final IResolvedFeatures.Provider resolvedFeaturesProvider, final Map<? extends JvmType, ? extends Set<String>> typesToNames) {
    super(id, types, resolvedFeaturesProvider);
    this._typesToNames = typesToNames;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this._typesToNames== null) ? 0 : this._typesToNames.hashCode());
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
    if (!super.equals(obj))
      return false;
    TypeWithRestrictedNamesBucket other = (TypeWithRestrictedNamesBucket) obj;
    if (this._typesToNames == null) {
      if (other._typesToNames != null)
        return false;
    } else if (!this._typesToNames.equals(other._typesToNames))
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
  public Map<? extends JvmType, ? extends Set<String>> getTypesToNames() {
    return this._typesToNames;
  }
}
