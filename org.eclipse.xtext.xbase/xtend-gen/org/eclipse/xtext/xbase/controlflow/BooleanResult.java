/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.controlflow;

import com.google.common.base.Optional;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.controlflow.IConstantEvaluationResult;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class BooleanResult implements IConstantEvaluationResult<Boolean> {
  @Accessors(AccessorType.NONE)
  private final Boolean value;
  
  private final boolean compileTimeConstant;
  
  @Override
  public Optional<Boolean> getValue() {
    return Optional.<Boolean>fromNullable(this.value);
  }
  
  public BooleanResult(final Boolean value, final boolean compileTimeConstant) {
    super();
    this.value = value;
    this.compileTimeConstant = compileTimeConstant;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.value== null) ? 0 : this.value.hashCode());
    return prime * result + (this.compileTimeConstant ? 1231 : 1237);
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
    BooleanResult other = (BooleanResult) obj;
    if (this.value == null) {
      if (other.value != null)
        return false;
    } else if (!this.value.equals(other.value))
      return false;
    if (other.compileTimeConstant != this.compileTimeConstant)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("value", this.value);
    b.add("compileTimeConstant", this.compileTimeConstant);
    return b.toString();
  }
  
  @Pure
  public boolean isCompileTimeConstant() {
    return this.compileTimeConstant;
  }
}
