/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class JvmFieldDeclarationImpl extends JvmMemberDeclarationImpl<JvmField> implements MutableFieldDeclaration {
  public Expression getInitializer() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public void setInitializer(final Expression initializer) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isFinal() {
    JvmField _delegate = this.getDelegate();
    boolean _isFinal = _delegate.isFinal();
    return _isFinal;
  }
  
  public boolean isStatic() {
    JvmField _delegate = this.getDelegate();
    boolean _isStatic = _delegate.isStatic();
    return _isStatic;
  }
  
  public TypeReference getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    JvmTypeReference _type = _delegate.getType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_type);
    return _typeReference;
  }
  
  public MutableClassDeclaration getDeclaringType() {
    MutableTypeDeclaration _declaringType = super.getDeclaringType();
    return ((MutableClassDeclaration) _declaringType);
  }
  
  public void setFinal(final boolean isFinal) {
    JvmField _delegate = this.getDelegate();
    _delegate.setFinal(isFinal);
  }
  
  public void setStatic(final boolean isStatic) {
    JvmField _delegate = this.getDelegate();
    _delegate.setStatic(isStatic);
  }
  
  public void setType(final TypeReference type) {
    JvmField _delegate = this.getDelegate();
    LightweightTypeReference _lightWeightTypeReference = ((TypeReferenceImpl) type).getLightWeightTypeReference();
    JvmTypeReference _javaCompliantTypeReference = _lightWeightTypeReference.toJavaCompliantTypeReference();
    _delegate.setType(_javaCompliantTypeReference);
  }
}
