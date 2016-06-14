/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.scoping.batch.TypeBucket;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;

/**
 * A type bucket that was produced from the synonym of a type.
 * It tracks the conformance flags for a synonym, e.g. boxing or unboxing information.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class SynonymTypeBucket extends TypeBucket {
  private final int flags;
  
  public SynonymTypeBucket(final int id, final List<? extends JvmType> types, final IResolvedFeatures.Provider resolvedFeaturesProvider, final int flags) {
    super(id, types, resolvedFeaturesProvider);
    this.flags = flags;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + this.flags;
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
    SynonymTypeBucket other = (SynonymTypeBucket) obj;
    if (other.flags != this.flags)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
    return result;
  }
  
  @Pure
  public int getFlags() {
    return this.flags;
  }
}
