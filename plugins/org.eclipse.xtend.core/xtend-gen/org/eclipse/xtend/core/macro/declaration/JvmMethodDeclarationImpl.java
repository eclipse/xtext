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
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;

@SuppressWarnings("all")
public class JvmMethodDeclarationImpl extends JvmExecutableDeclarationImpl<JvmOperation> implements MethodDeclaration {
  public boolean isAbstract() {
    JvmOperation _delegate = this.getDelegate();
    return _delegate.isAbstract();
  }
  
  public boolean isFinal() {
    JvmOperation _delegate = this.getDelegate();
    return _delegate.isFinal();
  }
  
  public boolean isStatic() {
    JvmOperation _delegate = this.getDelegate();
    return _delegate.isStatic();
  }
  
  public boolean isSynchronized() {
    JvmOperation _delegate = this.getDelegate();
    return _delegate.isSynchronized();
  }
  
  public boolean isDefault() {
    JvmOperation _delegate = this.getDelegate();
    return _delegate.isDefault();
  }
  
  public boolean isStrictFloatingPoint() {
    JvmOperation _delegate = this.getDelegate();
    return _delegate.isStrictFloatingPoint();
  }
  
  public boolean isNative() {
    JvmOperation _delegate = this.getDelegate();
    return _delegate.isNative();
  }
  
  public TypeReference getReturnType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmOperation _delegate = this.getDelegate();
    JvmTypeReference _returnType = _delegate.getReturnType();
    return _compilationUnit.toTypeReference(_returnType);
  }
}
