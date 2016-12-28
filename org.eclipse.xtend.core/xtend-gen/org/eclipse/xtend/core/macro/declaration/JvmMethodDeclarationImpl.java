/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.JvmExecutableDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmOperation;

@SuppressWarnings("all")
public class JvmMethodDeclarationImpl extends JvmExecutableDeclarationImpl<JvmOperation> implements MethodDeclaration {
  @Override
  public boolean isAbstract() {
    return this.getDelegate().isAbstract();
  }
  
  @Override
  public boolean isFinal() {
    return this.getDelegate().isFinal();
  }
  
  @Override
  public boolean isStatic() {
    return this.getDelegate().isStatic();
  }
  
  @Override
  public boolean isSynchronized() {
    return this.getDelegate().isSynchronized();
  }
  
  @Override
  public boolean isDefault() {
    return this.getDelegate().isDefault();
  }
  
  @Override
  public boolean isStrictFloatingPoint() {
    return this.getDelegate().isStrictFloatingPoint();
  }
  
  @Override
  public boolean isNative() {
    return this.getDelegate().isNative();
  }
  
  @Override
  public TypeReference getReturnType() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getReturnType());
  }
}
