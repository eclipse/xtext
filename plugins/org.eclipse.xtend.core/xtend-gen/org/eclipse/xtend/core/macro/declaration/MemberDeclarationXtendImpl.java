/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.AbstractDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;

@SuppressWarnings("all")
public abstract class MemberDeclarationXtendImpl<T extends XtendMember> extends AbstractDeclarationImpl<T> implements MemberDeclaration {
  public String getDocComment() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public TypeDeclaration getDeclaringType() {
    TypeDeclaration _switchResult = null;
    EObject _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    final EObject container = _eContainer;
    boolean _matched = false;
    if (!_matched) {
      if (container instanceof XtendTypeDeclaration) {
        final XtendTypeDeclaration _xtendTypeDeclaration = (XtendTypeDeclaration)container;
        _matched=true;
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        TypeDeclaration _typeDeclaration = _compilationUnit.toTypeDeclaration(_xtendTypeDeclaration);
        _switchResult = _typeDeclaration;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
}
