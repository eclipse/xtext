/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;
import org.eclipse.xtend.lib.Data;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringHelper;

/**
 * A type bucket collects a number of types that originate in the
 * very same source, e.g. all implicit receiver types are contained
 * in the very same bucket.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class TypeReferenceBucket {
  private final int _id;
  
  private final List<JvmTypeReference> _types;
  
  public TypeReferenceBucket(final int id, final List<JvmTypeReference> types) {
    super();
    this._id = id;
    this._types = types;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this._id;
    result = prime * result + ((this._types== null) ? 0 : this._types.hashCode());
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
    TypeReferenceBucket other = (TypeReferenceBucket) obj;
    if (other._id != this._id)
      return false;
    if (this._types == null) {
      if (other._types != null)
        return false;
    } else if (!this._types.equals(other._types))
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
  public List<JvmTypeReference> getTypes() {
    return this._types;
  }
}
