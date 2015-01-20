/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.ui.notification;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.8
 */
@Data
@SuppressWarnings("all")
public class PrimaryTypeToType {
  private final String primaryTypeName;
  
  private final String typeName;
  
  public PrimaryTypeToType(final String primaryTypeName, final String typeName) {
    super();
    this.primaryTypeName = primaryTypeName;
    this.typeName = typeName;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.primaryTypeName== null) ? 0 : this.primaryTypeName.hashCode());
    result = prime * result + ((this.typeName== null) ? 0 : this.typeName.hashCode());
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
    PrimaryTypeToType other = (PrimaryTypeToType) obj;
    if (this.primaryTypeName == null) {
      if (other.primaryTypeName != null)
        return false;
    } else if (!this.primaryTypeName.equals(other.primaryTypeName))
      return false;
    if (this.typeName == null) {
      if (other.typeName != null)
        return false;
    } else if (!this.typeName.equals(other.typeName))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("primaryTypeName", this.primaryTypeName);
    b.add("typeName", this.typeName);
    return b.toString();
  }
  
  @Pure
  public String getPrimaryTypeName() {
    return this.primaryTypeName;
  }
  
  @Pure
  public String getTypeName() {
    return this.typeName;
  }
}
