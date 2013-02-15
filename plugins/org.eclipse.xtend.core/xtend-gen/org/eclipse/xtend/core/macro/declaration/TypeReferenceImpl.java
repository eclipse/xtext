/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.xtend.core.macro.declaration.AbstractDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class TypeReferenceImpl extends AbstractDeclarationImpl<LightweightTypeReference> implements TypeReference {
  public Type getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    JvmType _type = _delegate.getType();
    return _compilationUnit.toType(_type);
  }
  
  public String toString() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.toString();
  }
  
  public List<TypeReference> getActualTypeArguments() {
    LightweightTypeReference _delegate = this.getDelegate();
    List<LightweightTypeReference> _typeArguments = _delegate.getTypeArguments();
    final Function1<LightweightTypeReference,TypeReference> _function = new Function1<LightweightTypeReference,TypeReference>() {
        public TypeReference apply(final LightweightTypeReference it) {
          CompilationUnitImpl _compilationUnit = TypeReferenceImpl.this.getCompilationUnit();
          TypeReference _typeReference = _compilationUnit.toTypeReference(it);
          return _typeReference;
        }
      };
    List<TypeReference> _map = ListExtensions.<LightweightTypeReference, TypeReference>map(_typeArguments, _function);
    return _map;
  }
  
  public TypeReference getArrayComponentType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _componentType = _delegate.getComponentType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_componentType);
    return _typeReference;
  }
  
  public TypeReference getLowerBound() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _lowerBoundSubstitute = _delegate.getLowerBoundSubstitute();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_lowerBoundSubstitute);
    return _typeReference;
  }
  
  public TypeReference getPrimitiveIfWrapper() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _primitiveIfWrapperType = _delegate.getPrimitiveIfWrapperType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_primitiveIfWrapperType);
    return _typeReference;
  }
  
  public TypeReference getUpperBound() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _upperBoundSubstitute = _delegate.getUpperBoundSubstitute();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_upperBoundSubstitute);
    return _typeReference;
  }
  
  public TypeReference getWrapperIfPrimitive() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _wrapperTypeIfPrimitive = _delegate.getWrapperTypeIfPrimitive();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_wrapperTypeIfPrimitive);
    return _typeReference;
  }
  
  public boolean isAnyType() {
    LightweightTypeReference _delegate = this.getDelegate();
    boolean _isAny = _delegate.isAny();
    return _isAny;
  }
  
  public boolean isArray() {
    LightweightTypeReference _delegate = this.getDelegate();
    boolean _isArray = _delegate.isArray();
    return _isArray;
  }
  
  public boolean isAssignableFrom(final TypeReference typeReference) {
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _delegate_1 = ((TypeReferenceImpl) typeReference).getDelegate();
    boolean _isAssignableFrom = _delegate.isAssignableFrom(_delegate_1);
    return _isAssignableFrom;
  }
  
  public boolean isPrimitive() {
    LightweightTypeReference _delegate = this.getDelegate();
    boolean _isPrimitive = _delegate.isPrimitive();
    return _isPrimitive;
  }
  
  public boolean isVoid() {
    LightweightTypeReference _delegate = this.getDelegate();
    boolean _isPrimitiveVoid = _delegate.isPrimitiveVoid();
    return _isPrimitiveVoid;
  }
  
  public boolean isWildCard() {
    LightweightTypeReference _delegate = this.getDelegate();
    boolean _isWildcard = _delegate.isWildcard();
    return _isWildcard;
  }
  
  public boolean isWrapper() {
    LightweightTypeReference _delegate = this.getDelegate();
    boolean _isWrapper = _delegate.isWrapper();
    return _isWrapper;
  }
  
  public LightweightTypeReference getLightWeightTypeReference() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate;
  }
}
