/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmExecutableDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class JvmMethodDeclarationImpl extends JvmExecutableDeclarationImpl<JvmOperation> implements MutableMethodDeclaration {
  public boolean isAbstract() {
    JvmOperation _delegate = this.getDelegate();
    boolean _isAbstract = _delegate.isAbstract();
    return _isAbstract;
  }
  
  public boolean isFinal() {
    JvmOperation _delegate = this.getDelegate();
    boolean _isFinal = _delegate.isFinal();
    return _isFinal;
  }
  
  public boolean isOverride() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isStatic() {
    JvmOperation _delegate = this.getDelegate();
    boolean _isStatic = _delegate.isStatic();
    return _isStatic;
  }
  
  public TypeReference getReturnType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmOperation _delegate = this.getDelegate();
    JvmTypeReference _returnType = _delegate.getReturnType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_returnType);
    return _typeReference;
  }
  
  public void setReturnType(final TypeReference type) {
    JvmOperation _delegate = this.getDelegate();
    LightweightTypeReference _lightWeightTypeReference = ((TypeReferenceImpl) type).getLightWeightTypeReference();
    JvmTypeReference _javaCompliantTypeReference = _lightWeightTypeReference.toJavaCompliantTypeReference();
    _delegate.setReturnType(_javaCompliantTypeReference);
  }
}
