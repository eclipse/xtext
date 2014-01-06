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
import org.eclipse.xtend.core.macro.declaration.XtendTypeParameterDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class XtendMethodDeclarationImpl extends XtendMemberDeclarationImpl<XtendFunction> implements MethodDeclaration {
  public boolean isAbstract() {
    XtendFunction _delegate = this.getDelegate();
    XExpression _expression = _delegate.getExpression();
    return Objects.equal(_expression, null);
  }
  
  public boolean isFinal() {
    XtendFunction _delegate = this.getDelegate();
    return _delegate.isFinal();
  }
  
  public boolean isOverride() {
    XtendFunction _delegate = this.getDelegate();
    return _delegate.isOverride();
  }
  
  public boolean isStatic() {
    XtendFunction _delegate = this.getDelegate();
    return _delegate.isStatic();
  }
  
  public boolean isSynchronized() {
    return false;
  }
  
  public boolean isDefault() {
    return false;
  }
  
  public boolean isStrictFloatingPoint() {
    return false;
  }
  
  public boolean isNative() {
    return false;
  }
  
  public TypeReference getReturnType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendFunction _delegate = this.getDelegate();
    JvmTypeReference _returnType = _delegate.getReturnType();
    return _compilationUnit.toTypeReference(_returnType);
  }
  
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendFunction _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    return _compilationUnit.toVisibility(_visibility);
  }
  
  public String getSimpleName() {
    XtendFunction _delegate = this.getDelegate();
    return _delegate.getName();
  }
  
  public Expression getBody() {
    XtendFunction _delegate = this.getDelegate();
    XExpression _expression = _delegate.getExpression();
    boolean _equals = Objects.equal(_expression, null);
    if (_equals) {
      return null;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendFunction _delegate_1 = this.getDelegate();
    XExpression _expression_1 = _delegate_1.getExpression();
    return _compilationUnit.toExpression(_expression_1);
  }
  
  public boolean isVarArgs() {
    XtendFunction _delegate = this.getDelegate();
    EList<XtendParameter> _parameters = _delegate.getParameters();
    final Function1<XtendParameter,Boolean> _function = new Function1<XtendParameter,Boolean>() {
      public Boolean apply(final XtendParameter it) {
        return Boolean.valueOf(XtendMethodDeclarationImpl.this.isVarArgs());
      }
    };
    return IterableExtensions.<XtendParameter>exists(_parameters, _function);
  }
  
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    XtendFunction _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,XtendTypeParameterDeclarationImpl> _function = new Function1<JvmTypeParameter,XtendTypeParameterDeclarationImpl>() {
      public XtendTypeParameterDeclarationImpl apply(final JvmTypeParameter it) {
        CompilationUnitImpl _compilationUnit = XtendMethodDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toXtendTypeParameterDeclaration(it);
      }
    };
    return ListExtensions.<JvmTypeParameter, XtendTypeParameterDeclarationImpl>map(_typeParameters, _function);
  }
  
  public Iterable<? extends TypeReference> getExceptions() {
    XtendFunction _delegate = this.getDelegate();
    EList<JvmTypeReference> _exceptions = _delegate.getExceptions();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
      public TypeReference apply(final JvmTypeReference it) {
        CompilationUnitImpl _compilationUnit = XtendMethodDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeReference(it);
      }
    };
    return ListExtensions.<JvmTypeReference, TypeReference>map(_exceptions, _function);
  }
  
  public Iterable<? extends ParameterDeclaration> getParameters() {
    XtendFunction _delegate = this.getDelegate();
    EList<XtendParameter> _parameters = _delegate.getParameters();
    final Function1<XtendParameter,XtendParameterDeclarationImpl> _function = new Function1<XtendParameter,XtendParameterDeclarationImpl>() {
      public XtendParameterDeclarationImpl apply(final XtendParameter it) {
        CompilationUnitImpl _compilationUnit = XtendMethodDeclarationImpl.this.getCompilationUnit();
        return _compilationUnit.toXtendParameterDeclaration(it);
      }
    };
    return ListExtensions.<XtendParameter, XtendParameterDeclarationImpl>map(_parameters, _function);
  }
}
