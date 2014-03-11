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
    return _delegate.getJavaIdentifier();
  }
  
  public String getSimpleName() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.getSimpleName();
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
        _switchResult = new UnknownType(_compilationUnit, _plus_1);
      }
    }
    if (!_matched) {
      CompilationUnitImpl _compilationUnit_2 = this.getCompilationUnit();
      JvmType _type = it.getType();
      _switchResult = _compilationUnit_2.toType(_type);
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
    final Function1<LightweightTypeReference, TypeReference> _function = new Function1<LightweightTypeReference, TypeReference>() {
      public TypeReference apply(final LightweightTypeReference it) {
        CompilationUnitImpl _compilationUnit = TypeReferenceImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeReference(it);
      }
    };
    return ListExtensions.<LightweightTypeReference, TypeReference>map(_typeArguments, _function);
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
    return _compilationUnit.toTypeReference(_lowerBoundSubstitute);
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
      _xblockexpression = _compilationUnit.toTypeReference(_primitiveIfWrapperType);
    }
    return _xblockexpression;
  }
  
  public TypeReference getUpperBound() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _upperBoundSubstitute = _delegate.getUpperBoundSubstitute();
    return _compilationUnit.toTypeReference(_upperBoundSubstitute);
  }
  
  public TypeReference getWrapperIfPrimitive() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    LightweightTypeReference _delegate = this.getDelegate();
    LightweightTypeReference _wrapperTypeIfPrimitive = _delegate.getWrapperTypeIfPrimitive();
    return _compilationUnit.toTypeReference(_wrapperTypeIfPrimitive);
  }
  
  public boolean isAnyType() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isAny();
  }
  
  public boolean isArray() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isArray();
  }
  
  public boolean isAssignableFrom(final TypeReference typeReference) {
    boolean _xblockexpression = false;
    {
      boolean _isInferred = typeReference.isInferred();
      if (_isInferred) {
        throw new UnsupportedOperationException("Cannot check assignability with an inferred type reference.");
      }
      LightweightTypeReference _delegate = this.getDelegate();
      LightweightTypeReference _delegate_1 = ((TypeReferenceImpl) typeReference).getDelegate();
      _xblockexpression = _delegate.isAssignableFrom(_delegate_1);
    }
    return _xblockexpression;
  }
  
  public boolean isPrimitive() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isPrimitive();
  }
  
  public boolean isVoid() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isPrimitiveVoid();
  }
  
  public boolean isWildCard() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isWildcard();
  }
  
  public boolean isWrapper() {
    LightweightTypeReference _delegate = this.getDelegate();
    return _delegate.isWrapper();
  }
  
  public LightweightTypeReference getLightWeightTypeReference() {
    return this.getDelegate();
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
        _and = _isAssignableFrom_1;
      }
      return _and;
    }
    return false;
  }
  
  public int hashCode() {
    LightweightTypeReference _delegate = this.getDelegate();
    JvmType _type = _delegate.getType();
    String _qualifiedName = _type.getQualifiedName();
    return _qualifiedName.hashCode();
  }
  
  public boolean isInferred() {
    return false;
  }
}
