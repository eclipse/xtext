/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.XtendParameterDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class XtendConstructorDeclarationImpl extends XtendMemberDeclarationImpl<XtendConstructor> implements ConstructorDeclaration {
  public Expression getBody() {
    XtendConstructor _delegate = this.getDelegate();
    XExpression _expression = _delegate.getExpression();
    boolean _equals = Objects.equal(_expression, null);
    if (_equals) {
      return null;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendConstructor _delegate_1 = this.getDelegate();
    XExpression _expression_1 = _delegate_1.getExpression();
    return _compilationUnit.toExpression(_expression_1);
  }
  
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendConstructor _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    return _compilationUnit.toVisibility(_visibility);
  }
  
  public String getSimpleName() {
    TypeDeclaration _declaringType = this.getDeclaringType();
    return _declaringType.getSimpleName();
  }
  
  public boolean isVarArgs() {
    XtendConstructor _delegate = this.getDelegate();
    EList<XtendParameter> _parameters = _delegate.getParameters();
    final Function1<XtendParameter,Boolean> _function = new Function1<XtendParameter,Boolean>() {
      public Boolean apply(final XtendParameter it) {
        return Boolean.valueOf(XtendConstructorDeclarationImpl.this.isVarArgs());
      }
    };
    return IterableExtensions.<XtendParameter>exists(_parameters, _function);
  }
  
  public Iterable<? extends TypeReference> getExceptions() {
    XtendConstructor _delegate = this.getDelegate();
    EList<JvmTypeReference> _exceptions = _delegate.getExceptions();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
      public TypeReference apply(final JvmTypeReference it) {
        CompilationUnitImpl _compilationUnit = XtendConstructorDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeReference(it);
      }
    };
    return ListExtensions.<JvmTypeReference, TypeReference>map(_exceptions, _function);
  }
  
  public Iterable<? extends ParameterDeclaration> getParameters() {
    XtendConstructor _delegate = this.getDelegate();
    EList<XtendParameter> _parameters = _delegate.getParameters();
    final Function1<XtendParameter,XtendParameterDeclarationImpl> _function = new Function1<XtendParameter,XtendParameterDeclarationImpl>() {
      public XtendParameterDeclarationImpl apply(final XtendParameter it) {
        CompilationUnitImpl _compilationUnit = XtendConstructorDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toXtendParameterDeclaration(it);
      }
    };
    return ListExtensions.<XtendParameter, XtendParameterDeclarationImpl>map(_parameters, _function);
  }
  
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    return CollectionLiterals.<TypeParameterDeclaration>emptyList();
  }
}
