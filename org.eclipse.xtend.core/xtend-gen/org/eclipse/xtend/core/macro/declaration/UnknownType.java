/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class UnknownType implements Type {
  private final CompilationUnit compilationUnit;

  private final String qualifiedName;

  @Override
  public boolean isAssignableFrom(final Type otherType) {
    return false;
  }

  @Override
  public String getSimpleName() {
    String _xblockexpression = null;
    {
      final int idx = this.qualifiedName.lastIndexOf(".");
      String _xifexpression = null;
      if ((idx > 0)) {
        _xifexpression = this.qualifiedName.substring(idx);
      } else {
        _xifexpression = this.qualifiedName;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public UnknownType(final CompilationUnit compilationUnit, final String qualifiedName) {
    super();
    this.compilationUnit = compilationUnit;
    this.qualifiedName = qualifiedName;
  }

  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.compilationUnit== null) ? 0 : this.compilationUnit.hashCode());
    return prime * result + ((this.qualifiedName== null) ? 0 : this.qualifiedName.hashCode());
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
    UnknownType other = (UnknownType) obj;
    if (this.compilationUnit == null) {
      if (other.compilationUnit != null)
        return false;
    } else if (!this.compilationUnit.equals(other.compilationUnit))
      return false;
    if (this.qualifiedName == null) {
      if (other.qualifiedName != null)
        return false;
    } else if (!this.qualifiedName.equals(other.qualifiedName))
      return false;
    return true;
  }

  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("compilationUnit", this.compilationUnit);
    b.add("qualifiedName", this.qualifiedName);
    return b.toString();
  }

  @Pure
  @Override
  public CompilationUnit getCompilationUnit() {
    return this.compilationUnit;
  }

  @Pure
  @Override
  public String getQualifiedName() {
    return this.qualifiedName;
  }
}
