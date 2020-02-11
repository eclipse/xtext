/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
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
  private final int id;
  
  private final List<? extends JvmType> types;
  
  private final IResolvedFeatures.Provider resolvedFeaturesProvider;
  
  public int getFlags() {
    return ConformanceFlags.CHECKED_SUCCESS;
  }
  
  public Map<? extends JvmType, ? extends Set<String>> getTypesToNames() {
    return CollectionLiterals.<JvmType, Set<String>>emptyMap();
  }
  
  public boolean isRestrictingNames() {
    return false;
  }
  
  public TypeBucket(final int id, final List<? extends JvmType> types, final IResolvedFeatures.Provider resolvedFeaturesProvider) {
    super();
    this.id = id;
    this.types = types;
    this.resolvedFeaturesProvider = resolvedFeaturesProvider;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.id;
    result = prime * result + ((this.types== null) ? 0 : this.types.hashCode());
    return prime * result + ((this.resolvedFeaturesProvider== null) ? 0 : this.resolvedFeaturesProvider.hashCode());
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
    if (other.id != this.id)
      return false;
    if (this.types == null) {
      if (other.types != null)
        return false;
    } else if (!this.types.equals(other.types))
      return false;
    if (this.resolvedFeaturesProvider == null) {
      if (other.resolvedFeaturesProvider != null)
        return false;
    } else if (!this.resolvedFeaturesProvider.equals(other.resolvedFeaturesProvider))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("id", this.id);
    b.add("types", this.types);
    b.add("resolvedFeaturesProvider", this.resolvedFeaturesProvider);
    return b.toString();
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  @Pure
  public List<? extends JvmType> getTypes() {
    return this.types;
  }
  
  @Pure
  public IResolvedFeatures.Provider getResolvedFeaturesProvider() {
    return this.resolvedFeaturesProvider;
  }
}
