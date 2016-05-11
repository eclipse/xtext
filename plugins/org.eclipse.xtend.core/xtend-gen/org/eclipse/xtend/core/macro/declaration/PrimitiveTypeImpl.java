/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
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
    boolean _matched = false;
    if (Objects.equal(_simpleName, "boolean")) {
      _matched=true;
      _switchResult = PrimitiveType.Kind.BOOLEAN;
    }
    if (!_matched) {
      if (Objects.equal(_simpleName, "int")) {
        _matched=true;
        _switchResult = PrimitiveType.Kind.INT;
      }
    }
    if (!_matched) {
      if (Objects.equal(_simpleName, "char")) {
        _matched=true;
        _switchResult = PrimitiveType.Kind.CHAR;
      }
    }
    if (!_matched) {
      if (Objects.equal(_simpleName, "double")) {
        _matched=true;
        _switchResult = PrimitiveType.Kind.DOUBLE;
      }
    }
    if (!_matched) {
      if (Objects.equal(_simpleName, "long")) {
        _matched=true;
        _switchResult = PrimitiveType.Kind.LONG;
      }
    }
    if (!_matched) {
      if (Objects.equal(_simpleName, "short")) {
        _matched=true;
        _switchResult = PrimitiveType.Kind.SHORT;
      }
    }
    if (!_matched) {
      if (Objects.equal(_simpleName, "float")) {
        _matched=true;
        _switchResult = PrimitiveType.Kind.FLOAT;
      }
    }
    if (!_matched) {
      if (Objects.equal(_simpleName, "byte")) {
        _matched=true;
        _switchResult = PrimitiveType.Kind.BYTE;
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
