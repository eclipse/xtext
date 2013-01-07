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
import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.MutableExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class JvmExecutableDeclarationImpl<T extends JvmExecutable> extends JvmMemberDeclarationImpl<T> implements MutableExecutableDeclaration {
  public List<MutableTypeParameterDeclaration> getTypeParameters() {
    JvmTypeParameterDeclarator _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,MutableTypeParameterDeclaration> _function = new Function1<JvmTypeParameter,MutableTypeParameterDeclaration>() {
        public MutableTypeParameterDeclaration apply(final JvmTypeParameter it) {
          CompilationUnitImpl _compilationUnit = JvmExecutableDeclarationImpl.this.getCompilationUnit();
          TypeParameterDeclaration _typeParameterDeclaration = _compilationUnit.toTypeParameterDeclaration(it);
          return ((MutableTypeParameterDeclaration) _typeParameterDeclaration);
        }
      };
    List<MutableTypeParameterDeclaration> _map = ListExtensions.<JvmTypeParameter, MutableTypeParameterDeclaration>map(_typeParameters, _function);
    return _map;
  }
  
  public boolean isVarArgs() {
    JvmExecutable _delegate = this.getDelegate();
    boolean _isVarArgs = _delegate.isVarArgs();
    return _isVarArgs;
  }
  
  public Expression getBody() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public List<MutableParameterDeclaration> getParameters() {
    JvmExecutable _delegate = this.getDelegate();
    EList<JvmFormalParameter> _parameters = _delegate.getParameters();
    final Function1<JvmFormalParameter,MutableParameterDeclaration> _function = new Function1<JvmFormalParameter,MutableParameterDeclaration>() {
        public MutableParameterDeclaration apply(final JvmFormalParameter it) {
          CompilationUnitImpl _compilationUnit = JvmExecutableDeclarationImpl.this.getCompilationUnit();
          ParameterDeclaration _parameterDeclaration = _compilationUnit.toParameterDeclaration(it);
          return ((MutableParameterDeclaration) _parameterDeclaration);
        }
      };
    List<MutableParameterDeclaration> _map = ListExtensions.<JvmFormalParameter, MutableParameterDeclaration>map(_parameters, _function);
    return _map;
  }
  
  public List<TypeReference> getExceptions() {
    JvmExecutable _delegate = this.getDelegate();
    EList<JvmTypeReference> _exceptions = _delegate.getExceptions();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
        public TypeReference apply(final JvmTypeReference it) {
          CompilationUnitImpl _compilationUnit = JvmExecutableDeclarationImpl.this.getCompilationUnit();
          TypeReference _typeReference = _compilationUnit.toTypeReference(it);
          return _typeReference;
        }
      };
    List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(_exceptions, _function);
    return _map;
  }
  
  public void setBody(final Expression body) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public void setExceptions(final List<TypeReference> exceptions) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public void setVarArgs(final boolean isVarArgs) {
    JvmExecutable _delegate = this.getDelegate();
    _delegate.setVarArgs(isVarArgs);
  }
  
  public void addTypeParameter(final MutableTypeParameterDeclaration typeParameter) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public void addTypeParameter(final int index, final MutableTypeParameterDeclaration typeParameter) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
  
  public void removeTypeParameter(final MutableTypeParameterDeclaration typeParameter) {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-Jvm function stub");
    throw _unsupportedOperationException;
  }
}
