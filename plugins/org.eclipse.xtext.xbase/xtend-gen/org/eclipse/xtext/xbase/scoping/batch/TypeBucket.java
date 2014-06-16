/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;

/**
 * A type bucket collects a number of types that originate in the
 * very same source, e.g. all imported types are contained in the
 * same bucket where all types that are available via wildcard imports
 * are contained in a different bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class TypeBucket {
  private final int _id;
  
  private final List<? extends JvmType> _types;
  
  private final IResolvedFeatures.Provider _resolvedFeaturesProvider;
  
  public EnumSet<ConformanceHint> getHints() {
    return EnumSet.<ConformanceHint>of(ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
  }
  
  public Map<? extends JvmType, ? extends Set<String>> getTypesToNames() {
    return CollectionLiterals.<JvmType, Set<String>>emptyMap();
  }
  
  public boolean isRestrictingNames() {
    return false;
  }
  
  public TypeBucket(final int id, final List<? extends JvmType> types, final IResolvedFeatures.Provider resolvedFeaturesProvider) {
    super();
    this._id = id;
    this._types = types;
    this._resolvedFeaturesProvider = resolvedFeaturesProvider;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this._id;
    result = prime * result + ((this._types== null) ? 0 : this._types.hashCode());
    result = prime * result + ((this._resolvedFeaturesProvider== null) ? 0 : this._resolvedFeaturesProvider.hashCode());
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
    TypeBucket other = (TypeBucket) obj;
    if (other._id != this._id)
      return false;
    if (this._types == null) {
      if (other._types != null)
        return false;
    } else if (!this._types.equals(other._types))
      return false;
    if (this._resolvedFeaturesProvider == null) {
      if (other._resolvedFeaturesProvider != null)
        return false;
    } else if (!this._resolvedFeaturesProvider.equals(other._resolvedFeaturesProvider))
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
  public int getId() {
    return this._id;
  }
  
  @Pure
  public List<? extends JvmType> getTypes() {
    return this._types;
  }
  
  @Pure
  public IResolvedFeatures.Provider getResolvedFeaturesProvider() {
    return this._resolvedFeaturesProvider;
  }
}
