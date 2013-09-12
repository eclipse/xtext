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
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

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
  
  public int getId() {
    return this._id;
  }
  
  private final List<? extends JvmType> _types;
  
  public List<? extends JvmType> getTypes() {
    return this._types;
  }
  
  private final CommonTypeComputationServices _commonServices;
  
  public CommonTypeComputationServices getCommonServices() {
    return this._commonServices;
  }
  
  public EnumSet<ConformanceHint> getHints() {
    EnumSet<ConformanceHint> _of = EnumSet.<ConformanceHint>of(ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
    return _of;
  }
  
  public TypeBucket(final int id, final List<? extends JvmType> types, final CommonTypeComputationServices commonServices) {
    super();
    this._id = id;
    this._types = types;
    this._commonServices = commonServices;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + _id;
    result = prime * result + ((_types== null) ? 0 : _types.hashCode());
    result = prime * result + ((_commonServices== null) ? 0 : _commonServices.hashCode());
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
    TypeBucket other = (TypeBucket) obj;
    if (other._id != _id)
      return false;
    if (_types == null) {
      if (other._types != null)
        return false;
    } else if (!_types.equals(other._types))
      return false;
    if (_commonServices == null) {
      if (other._commonServices != null)
        return false;
    } else if (!_commonServices.equals(other._commonServices))
      return false;
    return true;
  }
  
  @Override
  public String toString() {
    String result = new ToStringHelper().toString(this);
    return result;
  }
}
