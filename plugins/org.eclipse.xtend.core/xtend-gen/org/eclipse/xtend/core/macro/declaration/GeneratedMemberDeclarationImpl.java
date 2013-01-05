/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.GeneratedNamedElementImpl;
import org.eclipse.xtend.lib.macro.declaration.GeneratedMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmVisibility;

@SuppressWarnings("all")
public abstract class GeneratedMemberDeclarationImpl<T extends JvmMember> extends GeneratedNamedElementImpl<T> implements GeneratedMemberDeclaration {
  public String getDocComment() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmMember _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    Visibility _visibility_1 = _compilationUnit.toVisibility(_visibility);
    return _visibility_1;
  }
  
  public GeneratedTypeDeclaration getDeclaringType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmMember _delegate = this.getDelegate();
    JvmDeclaredType _declaringType = _delegate.getDeclaringType();
    TypeDeclaration _typeDeclaration = _compilationUnit.toTypeDeclaration(_declaringType);
    return ((GeneratedTypeDeclaration) _typeDeclaration);
  }
}
