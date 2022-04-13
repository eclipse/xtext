/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.macro.declaration.ResolvedConstructor;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

@SuppressWarnings("all")
public class InferredTypeReferenceImpl extends AbstractElementImpl<XComputedTypeReferenceImplCustom> implements TypeReference {
  private LightweightTypeReference lightweightTypeReference;

  public LightweightTypeReference getLightweightTypeReference() {
    return this.lightweightTypeReference;
  }

  @Delegate
  public TypeReference throwInferredTypeException(final String methodName) {
    String _message = this.message(methodName);
    throw new IllegalStateException(_message);
  }

  private String message(final String methodName) {
    return (("Cannot call method \'" + methodName) + "\' on a inferred type reference before the compilation phase. Check isInferred() before calling any methods.");
  }

  @Override
  public boolean isInferred() {
    return true;
  }

  @Override
  public String toString() {
    return this.getDelegate().toString();
  }

  @Override
  public boolean equals(final Object obj) {
    if ((obj instanceof InferredTypeReferenceImpl)) {
      return this.getDelegate().equals(((InferredTypeReferenceImpl)obj).getDelegate());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return this.getDelegate().hashCode();
  }

  public List<TypeReference> getActualTypeArguments() {
    return this.throwInferredTypeException("getActualTypeArguments").getActualTypeArguments();
  }

  public Iterable<? extends ResolvedMethod> getAllResolvedMethods() {
    return this.throwInferredTypeException("getAllResolvedMethods").getAllResolvedMethods();
  }

  public TypeReference getArrayComponentType() {
    return this.throwInferredTypeException("getArrayComponentType").getArrayComponentType();
  }

  public Iterable<? extends ResolvedConstructor> getDeclaredResolvedConstructors() {
    return this.throwInferredTypeException("getDeclaredResolvedConstructors").getDeclaredResolvedConstructors();
  }

  public Iterable<? extends ResolvedMethod> getDeclaredResolvedMethods() {
    return this.throwInferredTypeException("getDeclaredResolvedMethods").getDeclaredResolvedMethods();
  }

  public Iterable<? extends TypeReference> getDeclaredSuperTypes() {
    return this.throwInferredTypeException("getDeclaredSuperTypes").getDeclaredSuperTypes();
  }

  public TypeReference getLowerBound() {
    return this.throwInferredTypeException("getLowerBound").getLowerBound();
  }

  public String getName() {
    return this.throwInferredTypeException("getName").getName();
  }

  public TypeReference getPrimitiveIfWrapper() {
    return this.throwInferredTypeException("getPrimitiveIfWrapper").getPrimitiveIfWrapper();
  }

  public String getSimpleName() {
    return this.throwInferredTypeException("getSimpleName").getSimpleName();
  }

  public Type getType() {
    return this.throwInferredTypeException("getType").getType();
  }

  public TypeReference getUpperBound() {
    return this.throwInferredTypeException("getUpperBound").getUpperBound();
  }

  public TypeReference getWrapperIfPrimitive() {
    return this.throwInferredTypeException("getWrapperIfPrimitive").getWrapperIfPrimitive();
  }

  public boolean isAnyType() {
    return this.throwInferredTypeException("isAnyType").isAnyType();
  }

  public boolean isArray() {
    return this.throwInferredTypeException("isArray").isArray();
  }

  public boolean isAssignableFrom(final TypeReference typeReference) {
    return this.throwInferredTypeException("isAssignableFrom").isAssignableFrom(typeReference);
  }

  public boolean isPrimitive() {
    return this.throwInferredTypeException("isPrimitive").isPrimitive();
  }

  public boolean isVoid() {
    return this.throwInferredTypeException("isVoid").isVoid();
  }

  public boolean isWildCard() {
    return this.throwInferredTypeException("isWildCard").isWildCard();
  }

  public boolean isWrapper() {
    return this.throwInferredTypeException("isWrapper").isWrapper();
  }
}
