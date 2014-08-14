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
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

@SuppressWarnings("all")
public class InferredTypeReferenceImpl extends AbstractElementImpl<XComputedTypeReferenceImplCustom> implements TypeReference {
  @Accessors
  private TypeReference equivalent;
  
  private LightweightTypeReference lightweightTypeReference;
  
  public LightweightTypeReference getLightweightTypeReference() {
    return this.lightweightTypeReference;
  }
  
  public TypeReference getEquivalent() {
    TypeReference _xblockexpression = null;
    {
      boolean _tripleEquals = (this.equivalent == null);
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
          this.equivalent = _typeReference;
        }
      }
      _xblockexpression = this.equivalent;
    }
    return _xblockexpression;
  }
  
  @Delegate
  public TypeReference getEquivalent(final String methodName) {
    TypeReference _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        String _message = this.message(methodName);
        throw new IllegalStateException(_message);
      }
      _xblockexpression = this.getEquivalent();
    }
    return _xblockexpression;
  }
  
  private String message(final String methodName) {
    return (("Cannot call method \'" + methodName) + "\' on a inferred type reference before the compilation phase. Check isInferred() before calling any methods.");
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
  
  public void setEquivalent(final TypeReference equivalent) {
    this.equivalent = equivalent;
  }
  
  public List<TypeReference> getActualTypeArguments() {
    return this.getEquivalent("getActualTypeArguments").getActualTypeArguments();
  }
  
  public Iterable<? extends ResolvedMethod> getAllResolvedMethods() {
    return this.getEquivalent("getAllResolvedMethods").getAllResolvedMethods();
  }
  
  public TypeReference getArrayComponentType() {
    return this.getEquivalent("getArrayComponentType").getArrayComponentType();
  }
  
  public Iterable<? extends ResolvedConstructor> getDeclaredResolvedConstructors() {
    return this.getEquivalent("getDeclaredResolvedConstructors").getDeclaredResolvedConstructors();
  }
  
  public Iterable<? extends ResolvedMethod> getDeclaredResolvedMethods() {
    return this.getEquivalent("getDeclaredResolvedMethods").getDeclaredResolvedMethods();
  }
  
  public Iterable<? extends TypeReference> getDeclaredSuperTypes() {
    return this.getEquivalent("getDeclaredSuperTypes").getDeclaredSuperTypes();
  }
  
  public TypeReference getLowerBound() {
    return this.getEquivalent("getLowerBound").getLowerBound();
  }
  
  public String getName() {
    return this.getEquivalent("getName").getName();
  }
  
  public TypeReference getPrimitiveIfWrapper() {
    return this.getEquivalent("getPrimitiveIfWrapper").getPrimitiveIfWrapper();
  }
  
  public String getSimpleName() {
    return this.getEquivalent("getSimpleName").getSimpleName();
  }
  
  public Type getType() {
    return this.getEquivalent("getType").getType();
  }
  
  public TypeReference getUpperBound() {
    return this.getEquivalent("getUpperBound").getUpperBound();
  }
  
  public TypeReference getWrapperIfPrimitive() {
    return this.getEquivalent("getWrapperIfPrimitive").getWrapperIfPrimitive();
  }
  
  public boolean is(final TypeReference other) {
    return this.getEquivalent("is").is(other);
  }
  
  public boolean isAnyType() {
    return this.getEquivalent("isAnyType").isAnyType();
  }
  
  public boolean isArray() {
    return this.getEquivalent("isArray").isArray();
  }
  
  public boolean isAssignableFrom(final TypeReference typeReference) {
    return this.getEquivalent("isAssignableFrom").isAssignableFrom(typeReference);
  }
  
  public boolean isPrimitive() {
    return this.getEquivalent("isPrimitive").isPrimitive();
  }
  
  public boolean isVoid() {
    return this.getEquivalent("isVoid").isVoid();
  }
  
  public boolean isWildCard() {
    return this.getEquivalent("isWildCard").isWildCard();
  }
  
  public boolean isWrapper() {
    return this.getEquivalent("isWrapper").isWrapper();
  }
}
