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
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

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
  private final int id;
  
  private final List<JvmTypeReference> types;
  
  public TypeReferenceBucket(final int id, final List<JvmTypeReference> types) {
    super();
    this.id = id;
    this.types = types;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.id;
    return prime * result + ((this.types== null) ? 0 : this.types.hashCode());
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
    if (other.id != this.id)
      return false;
    if (this.types == null) {
      if (other.types != null)
        return false;
    } else if (!this.types.equals(other.types))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("id", this.id);
    b.add("types", this.types);
    return b.toString();
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  @Pure
  public List<JvmTypeReference> getTypes() {
    return this.types;
  }
}
