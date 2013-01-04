/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.MemberDeclarationXtendImpl;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class ConstructorDeclarationXtendImpl extends MemberDeclarationXtendImpl<XtendConstructor> implements ConstructorDeclaration {
  public Expression getBody() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendConstructor _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    Visibility _visibility_1 = _compilationUnit.toVisibility(_visibility);
    return _visibility_1;
  }
  
  public String getName() {
    XtendConstructor _delegate = this.getDelegate();
    String _name = _delegate.getName();
    return _name;
  }
  
  public boolean isVarArgs() {
    XtendConstructor _delegate = this.getDelegate();
    EList<XtendParameter> _parameters = _delegate.getParameters();
    final Function1<XtendParameter,Boolean> _function = new Function1<XtendParameter,Boolean>() {
        public Boolean apply(final XtendParameter it) {
          boolean _isVarArgs = ConstructorDeclarationXtendImpl.this.isVarArgs();
          return Boolean.valueOf(_isVarArgs);
        }
      };
    boolean _exists = IterableExtensions.<XtendParameter>exists(_parameters, _function);
    return _exists;
  }
  
  public TypeReference getType() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public List<TypeParameterDeclaration> getFormalTypeParameters() {
    XtendConstructor _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,TypeParameterDeclaration> _function = new Function1<JvmTypeParameter,TypeParameterDeclaration>() {
        public TypeParameterDeclaration apply(final JvmTypeParameter it) {
          CompilationUnitImpl _compilationUnit = ConstructorDeclarationXtendImpl.this.getCompilationUnit();
          TypeParameterDeclaration _typeParameterDeclaration = _compilationUnit.toTypeParameterDeclaration(it);
          return _typeParameterDeclaration;
        }
      };
    List<TypeParameterDeclaration> _map = ListExtensions.<JvmTypeParameter, TypeParameterDeclaration>map(_typeParameters, _function);
    return _map;
  }
}
