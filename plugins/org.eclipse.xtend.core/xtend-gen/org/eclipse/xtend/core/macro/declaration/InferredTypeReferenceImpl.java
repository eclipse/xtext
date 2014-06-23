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
import org.eclipse.xtend.lib.Delegate;
import org.eclipse.xtend.lib.Getter;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

@SuppressWarnings("all")
public class InferredTypeReferenceImpl extends AbstractElementImpl<XComputedTypeReferenceImplCustom> implements TypeReference {
  private TypeReference equivalent;
  
  @Getter
  private LightweightTypeReference lightweightTypeReference;
  
  @Delegate
  private TypeReference getEquivalent(final String methodName) {
    TypeReference _xblockexpression = null;
    {
      TypeReference _equivalent = this.getEquivalent();
      boolean _equals = Objects.equal(_equivalent, null);
      if (_equals) {
        throw new UnsupportedOperationException((("Cannot call method \'" + methodName) + "()\' on a inferred type reference before the compilation phase. Check isInferred() before calling any methods."));
      }
      _xblockexpression = this.getEquivalent();
    }
    return _xblockexpression;
  }
  
  public TypeReference getEquivalent() {
    TypeReference _xblockexpression = null;
    {
      boolean _equals = Objects.equal(this.equivalent, null);
      if (_equals) {
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
  
  public boolean isInferred() {
    return true;
  }
  
  public String toString() {
    XComputedTypeReferenceImplCustom _delegate = this.getDelegate();
    return _delegate.toString();
  }
  
  @Pure
  public LightweightTypeReference getLightweightTypeReference() {
    return this.lightweightTypeReference;
  }
  
  public List<TypeReference> getActualTypeArguments() {
    return this.getEquivalent("getActualTypeArguments").getActualTypeArguments();
  }
  
  public TypeReference getArrayComponentType() {
    return this.getEquivalent("getArrayComponentType").getArrayComponentType();
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
