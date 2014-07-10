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
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

@SuppressWarnings("all")
public class InferredTypeReferenceImpl extends AbstractElementImpl<XComputedTypeReferenceImplCustom> implements TypeReference {
  @Property
  private TypeReference _equivalent;
  
  private LightweightTypeReference lightweightTypeReference;
  
  public LightweightTypeReference getLightweightTypeReference() {
    return this.lightweightTypeReference;
  }
  
  public TypeReference getEquivalent() {
    TypeReference _xblockexpression = null;
    {
      boolean _tripleEquals = (this._equivalent == null);
      if (_tripleEquals) {
        XComputedTypeReferenceImplCustom _delegate = this.getDelegate();
        boolean _isEquivalentComputed = _delegate.isEquivalentComputed();
        if (_isEquivalentComputed) {
          CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
          OwnedConverter _typeRefConverter = _compilationUnit.getTypeRefConverter();
          XComputedTypeReferenceImplCustom _delegate_1 = this.getDelegate();
          LightweightTypeReference _lightweightReference = _typeRefConverter.toLightweightReference(_delegate_1);
          this.lightweightTypeReference = _lightweightReference;
          CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
          TypeReference _typeReference = _compilationUnit_1.toTypeReference(this.lightweightTypeReference);
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
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
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
        String _message = this.message("isWrapper()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.isWrapper();
    }
    return _xblockexpression;
  }
  
  public Iterable<? extends TypeReference> getDeclaredSuperTypes() {
    Iterable<? extends TypeReference> _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
        String _message = this.message("getDeclaredSuperTypes()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getDeclaredSuperTypes();
    }
    return _xblockexpression;
  }
  
  public Iterable<? extends ResolvedMethod> getDeclaredResolvedMethods() {
    Iterable<? extends ResolvedMethod> _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
        String _message = this.message("getDeclaredResolvedMethods()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getDeclaredResolvedMethods();
    }
    return _xblockexpression;
  }
  
  public Iterable<? extends ResolvedConstructor> getDeclaredResolvedConstructors() {
    Iterable<? extends ResolvedConstructor> _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
        String _message = this.message("getDeclaredResolvedConstructors()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getDeclaredResolvedConstructors();
    }
    return _xblockexpression;
  }
  
  public Iterable<? extends ResolvedMethod> getAllResolvedMethods() {
    Iterable<? extends ResolvedMethod> _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
        String _message = this.message("getAllResolvedMethods()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.getAllResolvedMethods();
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
  
  public boolean equals(final Object obj) {
    if ((obj instanceof InferredTypeReferenceImpl)) {
      XComputedTypeReferenceImplCustom _delegate = this.getDelegate();
      XComputedTypeReferenceImplCustom _delegate_1 = ((InferredTypeReferenceImpl)obj).getDelegate();
      return _delegate.equals(_delegate_1);
    }
    return false;
  }
  
  public int hashCode() {
    XComputedTypeReferenceImplCustom _delegate = this.getDelegate();
    return _delegate.hashCode();
  }
  
  public boolean is(final TypeReference other) {
    boolean _xblockexpression = false;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _tripleEquals = (_equivalent == null);
      if (_tripleEquals) {
        String _message = this.message("is()");
        throw new UnsupportedOperationException(_message);
      }
      TypeReference _equivalent_1 = this.getEquivalent();
      _xblockexpression = _equivalent_1.is(other);
    }
    return _xblockexpression;
  }
  
  public boolean operator_equals(final Object other) {
    return Objects.equal(this, other);
  }
  
  public void setEquivalent(final TypeReference equivalent) {
    this._equivalent = equivalent;
  }
}
