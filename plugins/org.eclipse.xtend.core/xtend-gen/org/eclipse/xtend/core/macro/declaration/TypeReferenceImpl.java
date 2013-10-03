/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.UnknownType;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class TypeReferenceImpl extends AbstractElementImpl<LightweightTypeReference> implements TypeReference {
  public String getName() {
    LightweightTypeReference _delegate = this.getDelegate();
    String _javaIdentifier = _delegate.getJavaIdentifier();
    return _javaIdentifier;
  }
  
  public String getSimpleName() {
    LightweightTypeReference _delegate = this.getDelegate();
    String _simpleName = _delegate.getSimpleName();
    return _simpleName;
  }
  
  public Type getType() {
    Type _switchResult = null;
    LightweightTypeReference _delegate = this.getDelegate();
    final LightweightTypeReference it = _delegate;
    boolean _matched = false;
    if (!_matched) {
      boolean _isUnknown = it.isUnknown();
      if (_isUnknown) {
        _matched=true;
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
        String _packageName = _compilationUnit_1.getPackageName();
        String _plus = (_packageName + ".");
        String _simpleName = it.getSimpleName();
        String _plus_1 = (_plus + _simpleName);
        UnknownType _unknownType = new UnknownType(_compilationUnit, _plus_1);
        _switchResult = _unknownType;
      }
    }
    if (!_matched) {
      CompilationUnitImpl _compilationUnit_2 = this.getCompilationUnit();
      JvmType _type = it.getType();
      Type _type_1 = _compilationUnit_2.toType(_type);
      _switchResult = _type_1;
    }
    return _switchResult;
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
    LightweightTypeReference _delegate = this.getDelegate();
    final LightweightTypeReference componentType = _delegate.getComponentType();
    boolean _equals = Objects.equal(componentType, null);
    if (_equals) {
      return null;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    return _compilationUnit.toTypeReference(componentType);
  }
  
  public TypeReference getLowerBound() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _lowerBoundSubstitute = _delegate.getLowerBoundSubstitute();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_lowerBoundSubstitute);
    return _typeReference;
  }
  
  public TypeReference getPrimitiveIfWrapper() {
    TypeReference _xblockexpression = null;
    {
      boolean _isWrapper = this.isWrapper();
      boolean _not = (!_isWrapper);
      if (_not) {
        return this;
      }
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      LightweightTypeReference _delegate = this.getDelegate();
      LightweightTypeReference _primitiveIfWrapperType = _delegate.getPrimitiveIfWrapperType();
      TypeReference _typeReference = _compilationUnit.toTypeReference(_primitiveIfWrapperType);
      _xblockexpression = (_typeReference);
    }
    return _xblockexpression;
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
  
  public boolean equals(final Object obj) {
    boolean _tripleEquals = (obj == this);
    if (_tripleEquals) {
      return true;
    }
    if ((obj instanceof TypeReference)) {
      boolean _and = false;
      boolean _isAssignableFrom = ((TypeReference)obj).isAssignableFrom(this);
      if (!_isAssignableFrom) {
        _and = false;
      } else {
        boolean _isAssignableFrom_1 = this.isAssignableFrom(((TypeReference)obj));
        _and = (_isAssignableFrom && _isAssignableFrom_1);
      }
      return _and;
    }
    return false;
  }
  
  public int hashCode() {
    LightweightTypeReference _delegate = this.getDelegate();
    JvmType _type = _delegate.getType();
    String _qualifiedName = _type.getQualifiedName();
    int _hashCode = _qualifiedName.hashCode();
    return _hashCode;
  }
}
