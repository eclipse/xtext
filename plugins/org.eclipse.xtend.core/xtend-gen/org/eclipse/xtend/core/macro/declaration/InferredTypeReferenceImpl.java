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
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

@SuppressWarnings("all")
public class InferredTypeReferenceImpl extends AbstractElementImpl<XComputedTypeReferenceImplCustom> implements TypeReference {
  @Property
  private TypeReference _equivalent;
  
  @Property
  private LightweightTypeReference _lightweightTypeReference;
  
  public TypeReference getEquivalent() {
    TypeReference _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this._equivalent, null);
      if (_equals) {
        XComputedTypeReferenceImplCustom _delegate = this.getDelegate();
        boolean _isEquivalentComputed = _delegate.isEquivalentComputed();
        if (_isEquivalentComputed) {
          CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
          OwnedConverter _typeRefConverter = _compilationUnit.getTypeRefConverter();
          XComputedTypeReferenceImplCustom _delegate_1 = this.getDelegate();
          LightweightTypeReference _lightweightReference = _typeRefConverter.toLightweightReference(_delegate_1);
          this._lightweightTypeReference = _lightweightReference;
          CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
          TypeReference _typeReference = _compilationUnit_1.toTypeReference(this._lightweightTypeReference);
          this._equivalent = _typeReference;
        }
      }
      _xblockexpression = this._equivalent;
    }
    return _xblockexpression;
  }
  
  private String message(final String methodName) {
    return (("Cannot call method \'" + methodName) + "\' on a inferred type reference before the compilation phase. Check isInferred() before calling any methods.");
  }
  
  public List<TypeReference> getActualTypeArguments() {
    List<TypeReference> _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("getActualTypeArguments()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getActualTypeArguments();
    }
    return _xblockexpression;
  }
  
  public TypeReference getArrayComponentType() {
    TypeReference _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("getArrayComponentType()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getArrayComponentType();
    }
    return _xblockexpression;
  }
  
  public TypeReference getLowerBound() {
    TypeReference _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("getLowerBound()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getLowerBound();
    }
    return _xblockexpression;
  }
  
  public String getName() {
    String _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("getName()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getName();
    }
    return _xblockexpression;
  }
  
  public TypeReference getPrimitiveIfWrapper() {
    TypeReference _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("getPrimitiveIfWrapper()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getPrimitiveIfWrapper();
    }
    return _xblockexpression;
  }
  
  public String getSimpleName() {
    String _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("getSimpleName()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getSimpleName();
    }
    return _xblockexpression;
  }
  
  public Type getType() {
    Type _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("getType()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getType();
    }
    return _xblockexpression;
  }
  
  public TypeReference getUpperBound() {
    TypeReference _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("getUpperBound()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getUpperBound();
    }
    return _xblockexpression;
  }
  
  public TypeReference getWrapperIfPrimitive() {
    TypeReference _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("getWrapperIfPrimitive()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getWrapperIfPrimitive();
    }
    return _xblockexpression;
  }
  
  public boolean isAnyType() {
    boolean _xblockexpression = false;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("isAnyType()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.isAnyType();
    }
    return _xblockexpression;
  }
  
  public boolean isArray() {
    boolean _xblockexpression = false;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("isArray()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.isArray();
    }
    return _xblockexpression;
  }
  
  public boolean isAssignableFrom(final TypeReference typeReference) {
    boolean _xblockexpression = false;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("isAssignableFrom()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.isAssignableFrom(typeReference);
    }
    return _xblockexpression;
  }
  
  public boolean isPrimitive() {
    boolean _xblockexpression = false;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("isPrimitive()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.isPrimitive();
    }
    return _xblockexpression;
  }
  
  public boolean isVoid() {
    boolean _xblockexpression = false;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("isVoid()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.isVoid();
    }
    return _xblockexpression;
  }
  
  public boolean isWildCard() {
    boolean _xblockexpression = false;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("isWildCard()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.isWildCard();
    }
    return _xblockexpression;
  }
  
  public boolean isWrapper() {
    boolean _xblockexpression = false;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message("isWrapper()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.isWrapper();
    }
    return _xblockexpression;
  }
  
  public boolean isInferred() {
    return true;
  }
  
  public String toString() {
    XComputedTypeReferenceImplCustom _delegate = this.getDelegate();
    return _delegate.toString();
  }
  
  public void setEquivalent(final TypeReference equivalent) {
    this._equivalent = equivalent;
  }
  
  @Pure
  public LightweightTypeReference getLightweightTypeReference() {
    return this._lightweightTypeReference;
  }
  
  public void setLightweightTypeReference(final LightweightTypeReference lightweightTypeReference) {
    this._lightweightTypeReference = lightweightTypeReference;
  }
}
