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
import org.eclipse.xtend.core.macro.declaration.SourceMemberDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.declaration.SourceMethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.SourceTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class SourceMethodDeclarationImpl extends SourceMemberDeclarationImpl<XtendFunction> implements SourceMethodDeclaration {
  public boolean isAbstract() {
    XtendFunction _delegate = this.getDelegate();
    XExpression _expression = _delegate.getExpression();
    boolean _equals = ObjectExtensions.operator_equals(_expression, null);
    return _equals;
  }
  
  public boolean isFinal() {
    return false;
  }
  
  public boolean isOverride() {
    XtendFunction _delegate = this.getDelegate();
    boolean _isOverride = _delegate.isOverride();
    return _isOverride;
  }
  
  public boolean isStatic() {
    XtendFunction _delegate = this.getDelegate();
    boolean _isStatic = _delegate.isStatic();
    return _isStatic;
  }
  
  public TypeReference getReturnType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendFunction _delegate = this.getDelegate();
    JvmTypeReference _returnType = _delegate.getReturnType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_returnType);
    return _typeReference;
  }
  
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendFunction _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    Visibility _visibility_1 = _compilationUnit.toVisibility(_visibility);
    return _visibility_1;
  }
  
  public String getName() {
    XtendFunction _delegate = this.getDelegate();
    String _name = _delegate.getName();
    return _name;
  }
  
  public Expression getBody() {
    return null;
  }
  
  public boolean isVarArgs() {
    XtendFunction _delegate = this.getDelegate();
    EList<XtendParameter> _parameters = _delegate.getParameters();
    final Function1<XtendParameter,Boolean> _function = new Function1<XtendParameter,Boolean>() {
        public Boolean apply(final XtendParameter it) {
          boolean _isVarArgs = SourceMethodDeclarationImpl.this.isVarArgs();
          return Boolean.valueOf(_isVarArgs);
        }
      };
    boolean _exists = IterableExtensions.<XtendParameter>exists(_parameters, _function);
    return _exists;
  }
  
  public List<SourceTypeParameterDeclaration> getTypeParameters() {
    XtendFunction _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,SourceTypeParameterDeclaration> _function = new Function1<JvmTypeParameter,SourceTypeParameterDeclaration>() {
        public SourceTypeParameterDeclaration apply(final JvmTypeParameter it) {
          CompilationUnitImpl _compilationUnit = SourceMethodDeclarationImpl.this.getCompilationUnit();
          SourceTypeParameterDeclaration _sourceTypeParameterDeclaration = _compilationUnit.toSourceTypeParameterDeclaration(it);
          return _sourceTypeParameterDeclaration;
        }
      };
    List<SourceTypeParameterDeclaration> _map = ListExtensions.<JvmTypeParameter, SourceTypeParameterDeclaration>map(_typeParameters, _function);
    return _map;
  }
  
  public List<TypeReference> getExceptions() {
    XtendFunction _delegate = this.getDelegate();
    EList<JvmTypeReference> _exceptions = _delegate.getExceptions();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
        public TypeReference apply(final JvmTypeReference it) {
          CompilationUnitImpl _compilationUnit = SourceMethodDeclarationImpl.this.getCompilationUnit();
          TypeReference _typeReference = _compilationUnit.toTypeReference(it);
          return _typeReference;
        }
      };
    List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(_exceptions, _function);
    return _map;
  }
  
  public List<SourceParameterDeclaration> getParameters() {
    XtendFunction _delegate = this.getDelegate();
    EList<XtendParameter> _parameters = _delegate.getParameters();
    final Function1<XtendParameter,SourceParameterDeclaration> _function = new Function1<XtendParameter,SourceParameterDeclaration>() {
        public SourceParameterDeclaration apply(final XtendParameter it) {
          CompilationUnitImpl _compilationUnit = SourceMethodDeclarationImpl.this.getCompilationUnit();
          SourceParameterDeclaration _sourceParameterDeclaration = _compilationUnit.toSourceParameterDeclaration(it);
          return _sourceParameterDeclaration;
        }
      };
    List<SourceParameterDeclaration> _map = ListExtensions.<XtendParameter, SourceParameterDeclaration>map(_parameters, _function);
    return _map;
  }
}
