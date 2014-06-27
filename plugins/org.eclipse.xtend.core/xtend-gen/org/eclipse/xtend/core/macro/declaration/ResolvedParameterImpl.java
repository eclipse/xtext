/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.Data;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Pure;

@Data
@SuppressWarnings("all")
public class ResolvedParameterImpl implements ResolvedParameter {
  private final ParameterDeclaration _declaration;
  
  private final TypeReference _resolvedType;
  
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    TypeReference _resolvedType = this.getResolvedType();
    _builder.append(_resolvedType, "");
    _builder.append(" ");
    ParameterDeclaration _declaration = this.getDeclaration();
    String _simpleName = _declaration.getSimpleName();
    _builder.append(_simpleName, "");
    return _builder.toString();
  }
  
  public ResolvedParameterImpl(final ParameterDeclaration declaration, final TypeReference resolvedType) {
    super();
    this._declaration = declaration;
    this._resolvedType = resolvedType;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this._declaration== null) ? 0 : this._declaration.hashCode());
    result = prime * result + ((this._resolvedType== null) ? 0 : this._resolvedType.hashCode());
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
    ResolvedParameterImpl other = (ResolvedParameterImpl) obj;
    if (this._declaration == null) {
      if (other._declaration != null)
        return false;
    } else if (!this._declaration.equals(other._declaration))
      return false;
    if (this._resolvedType == null) {
      if (other._resolvedType != null)
        return false;
    } else if (!this._resolvedType.equals(other._resolvedType))
      return false;
    return true;
  }
  
  @Pure
  public ParameterDeclaration getDeclaration() {
    return this._declaration;
  }
  
  @Pure
  public TypeReference getResolvedType() {
    return this._resolvedType;
  }
}
