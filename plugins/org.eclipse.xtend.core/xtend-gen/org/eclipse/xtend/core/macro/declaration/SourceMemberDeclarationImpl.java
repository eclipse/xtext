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
import org.eclipse.xtend.lib.macro.declaration.SourceMemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceTypeDeclaration;

@SuppressWarnings("all")
public abstract class SourceMemberDeclarationImpl<T extends XtendMember> extends AbstractDeclarationImpl<T> implements SourceMemberDeclaration {
  public String getDocComment() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public SourceTypeDeclaration getDeclaringType() {
    SourceTypeDeclaration _switchResult = null;
    EObject _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    final EObject container = _eContainer;
    boolean _matched = false;
    if (!_matched) {
      if (container instanceof XtendTypeDeclaration) {
        final XtendTypeDeclaration _xtendTypeDeclaration = (XtendTypeDeclaration)container;
        _matched=true;
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        SourceTypeDeclaration _sourceTypeDeclaration = _compilationUnit.toSourceTypeDeclaration(_xtendTypeDeclaration);
        _switchResult = _sourceTypeDeclaration;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
}
