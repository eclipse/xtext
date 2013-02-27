/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmNamedElementImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmVisibility;

@SuppressWarnings("all")
public abstract class JvmMemberDeclarationImpl<T extends JvmMember> extends JvmNamedElementImpl<T> implements MutableMemberDeclaration {
  public String getDocComment() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public void setDocComment(final String docComment) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    T _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    Visibility _visibility_1 = _compilationUnit.toVisibility(_visibility);
    return _visibility_1;
  }
  
  public void setVisibility(final Visibility visibility) {
    T _delegate = this.getDelegate();
    JvmVisibility _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(visibility,Visibility.DEFAULT)) {
        _matched=true;
        _switchResult = JvmVisibility.DEFAULT;
      }
    }
    if (!_matched) {
      if (Objects.equal(visibility,Visibility.PUBLIC)) {
        _matched=true;
        _switchResult = JvmVisibility.PUBLIC;
      }
    }
    if (!_matched) {
      if (Objects.equal(visibility,Visibility.PRIVATE)) {
        _matched=true;
        _switchResult = JvmVisibility.PRIVATE;
      }
    }
    if (!_matched) {
      if (Objects.equal(visibility,Visibility.PROTECTED)) {
        _matched=true;
        _switchResult = JvmVisibility.PROTECTED;
      }
    }
    _delegate.setVisibility(_switchResult);
  }
  
  public MutableTypeDeclaration getDeclaringType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    T _delegate = this.getDelegate();
    JvmDeclaredType _declaringType = _delegate.getDeclaringType();
    MutableTypeDeclaration _typeDeclaration = _compilationUnit.toTypeDeclaration(_declaringType);
    return ((MutableTypeDeclaration) _typeDeclaration);
  }
  
  public void setName(final String name) {
    T _delegate = this.getDelegate();
    _delegate.setSimpleName(name);
  }
}
