/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xtype.XComputedTypeReference;

@SuppressWarnings("all")
public class InferredTypeReferenceImpl extends AbstractElementImpl<XComputedTypeReference> implements TypeReference {
  public List<TypeReference> getActualTypeArguments() {
    String _message = this.message("getActualTypeArguments()");
    throw new UnsupportedOperationException(_message);
  }
  
  private String message(final String methodName) {
    return (("Cannot call method \'" + methodName) + "\' on a inferred type reference. Check isInferred() before calling any methods.");
  }
  
  public TypeReference getArrayComponentType() {
    String _message = this.message("getArrayComponentType()");
    throw new UnsupportedOperationException(_message);
  }
  
  public TypeReference getLowerBound() {
    String _message = this.message("getLowerBound()");
    throw new UnsupportedOperationException(_message);
  }
  
  public String getName() {
    String _message = this.message("getName()");
    throw new UnsupportedOperationException(_message);
  }
  
  public TypeReference getPrimitiveIfWrapper() {
    String _message = this.message("getPrimitiveIfWrapper()");
    throw new UnsupportedOperationException(_message);
  }
  
  public String getSimpleName() {
    String _message = this.message("getSimpleName()");
    throw new UnsupportedOperationException(_message);
  }
  
  public Type getType() {
    String _message = this.message("getType()");
    throw new UnsupportedOperationException(_message);
  }
  
  public TypeReference getUpperBound() {
    String _message = this.message("getUpperBound()");
    throw new UnsupportedOperationException(_message);
  }
  
  public TypeReference getWrapperIfPrimitive() {
    String _message = this.message("getWrapperIfPrimitive()");
    throw new UnsupportedOperationException(_message);
  }
  
  public boolean isAnyType() {
    String _message = this.message("isAnyType()");
    throw new UnsupportedOperationException(_message);
  }
  
  public boolean isArray() {
    String _message = this.message("isArray()");
    throw new UnsupportedOperationException(_message);
  }
  
  public boolean isAssignableFrom(final TypeReference typeReference) {
    String _message = this.message("isAssignableFrom()");
    throw new UnsupportedOperationException(_message);
  }
  
  public boolean isPrimitive() {
    String _message = this.message("isPrimitive()");
    throw new UnsupportedOperationException(_message);
  }
  
  public boolean isVoid() {
    String _message = this.message("isVoid()");
    throw new UnsupportedOperationException(_message);
  }
  
  public boolean isWildCard() {
    String _message = this.message("isWildCard()");
    throw new UnsupportedOperationException(_message);
  }
  
  public boolean isWrapper() {
    String _message = this.message("isWrapper()");
    throw new UnsupportedOperationException(_message);
  }
  
  public boolean isInferred() {
    return true;
  }
  
  public String toString() {
    XComputedTypeReference _delegate = this.getDelegate();
    return _delegate.toString();
  }
}
