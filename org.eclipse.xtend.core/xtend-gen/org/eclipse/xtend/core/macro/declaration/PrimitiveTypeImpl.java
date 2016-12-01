/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.declaration.PrimitiveType;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.TypeReferenceProvider;
import org.eclipse.xtext.common.types.JvmPrimitiveType;

@SuppressWarnings("all")
public class PrimitiveTypeImpl extends AbstractElementImpl<JvmPrimitiveType> implements PrimitiveType {
  @Override
  public PrimitiveType.Kind getKind() {
    PrimitiveType.Kind _switchResult = null;
    String _simpleName = this.getSimpleName();
    if (_simpleName != null) {
      switch (_simpleName) {
        case "boolean":
          _switchResult = PrimitiveType.Kind.BOOLEAN;
          break;
        case "int":
          _switchResult = PrimitiveType.Kind.INT;
          break;
        case "char":
          _switchResult = PrimitiveType.Kind.CHAR;
          break;
        case "double":
          _switchResult = PrimitiveType.Kind.DOUBLE;
          break;
        case "long":
          _switchResult = PrimitiveType.Kind.LONG;
          break;
        case "short":
          _switchResult = PrimitiveType.Kind.SHORT;
          break;
        case "float":
          _switchResult = PrimitiveType.Kind.FLOAT;
          break;
        case "byte":
          _switchResult = PrimitiveType.Kind.BYTE;
          break;
      }
    }
    return _switchResult;
  }
  
  @Override
  public String getSimpleName() {
    JvmPrimitiveType _delegate = this.getDelegate();
    return _delegate.getIdentifier();
  }
  
  @Override
  public boolean isAssignableFrom(final Type otherType) {
    if ((otherType == null)) {
      return false;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider = _compilationUnit.getTypeReferenceProvider();
    final TypeReference thisTypeRef = _typeReferenceProvider.newTypeReference(this);
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    TypeReferenceProvider _typeReferenceProvider_1 = _compilationUnit_1.getTypeReferenceProvider();
    final TypeReference thatTypeRef = _typeReferenceProvider_1.newTypeReference(otherType);
    return thisTypeRef.isAssignableFrom(thatTypeRef);
  }
  
  @Override
  public String getQualifiedName() {
    return this.getSimpleName();
  }
}
