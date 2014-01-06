/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendAnnotationTargetImpl;
import org.eclipse.xtend.core.macro.declaration.XtendTypeDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;

@SuppressWarnings("all")
public abstract class XtendMemberDeclarationImpl<T extends XtendMember> extends XtendAnnotationTargetImpl<T> implements MemberDeclaration {
  public String getDocComment() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    IEObjectDocumentationProvider _documentationProvider = _compilationUnit.getDocumentationProvider();
    T _delegate = this.getDelegate();
    return _documentationProvider.getDocumentation(_delegate);
  }
  
  public TypeDeclaration getDeclaringType() {
    XtendTypeDeclarationImpl<? extends XtendTypeDeclaration> _switchResult = null;
    T _delegate = this.getDelegate();
    EObject _eContainer = _delegate.eContainer();
    final EObject container = _eContainer;
    boolean _matched = false;
    if (!_matched) {
      if (container instanceof XtendTypeDeclaration) {
        _matched=true;
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        _switchResult = _compilationUnit.toXtendTypeDeclaration(((XtendTypeDeclaration)container));
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }
  
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    T _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    return _compilationUnit.toVisibility(_visibility);
  }
}
