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
import org.eclipse.xtend.core.macro.declaration.GeneratedMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.GeneratedExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.GeneratedParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.GeneratedTypeParameterDeclaration;
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
public abstract class GeneratedExecutableDeclarationImpl<T extends JvmExecutable> extends GeneratedMemberDeclarationImpl<T> implements GeneratedExecutableDeclaration {
  public List<GeneratedTypeParameterDeclaration> getTypeParameters() {
    JvmTypeParameterDeclarator _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,GeneratedTypeParameterDeclaration> _function = new Function1<JvmTypeParameter,GeneratedTypeParameterDeclaration>() {
        public GeneratedTypeParameterDeclaration apply(final JvmTypeParameter it) {
          CompilationUnitImpl _compilationUnit = GeneratedExecutableDeclarationImpl.this.getCompilationUnit();
          TypeParameterDeclaration _typeParameterDeclaration = _compilationUnit.toTypeParameterDeclaration(it);
          return ((GeneratedTypeParameterDeclaration) _typeParameterDeclaration);
        }
      };
    List<GeneratedTypeParameterDeclaration> _map = ListExtensions.<JvmTypeParameter, GeneratedTypeParameterDeclaration>map(_typeParameters, _function);
    return _map;
  }
  
  public boolean isVarArgs() {
    JvmExecutable _delegate = this.getDelegate();
    boolean _isVarArgs = _delegate.isVarArgs();
    return _isVarArgs;
  }
  
  public Expression getBody() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public List<GeneratedParameterDeclaration> getParameters() {
    JvmExecutable _delegate = this.getDelegate();
    EList<JvmFormalParameter> _parameters = _delegate.getParameters();
    final Function1<JvmFormalParameter,GeneratedParameterDeclaration> _function = new Function1<JvmFormalParameter,GeneratedParameterDeclaration>() {
        public GeneratedParameterDeclaration apply(final JvmFormalParameter it) {
          CompilationUnitImpl _compilationUnit = GeneratedExecutableDeclarationImpl.this.getCompilationUnit();
          ParameterDeclaration _parameterDeclaration = _compilationUnit.toParameterDeclaration(it);
          return ((GeneratedParameterDeclaration) _parameterDeclaration);
        }
      };
    List<GeneratedParameterDeclaration> _map = ListExtensions.<JvmFormalParameter, GeneratedParameterDeclaration>map(_parameters, _function);
    return _map;
  }
  
  public List<TypeReference> getExceptions() {
    JvmExecutable _delegate = this.getDelegate();
    EList<JvmTypeReference> _exceptions = _delegate.getExceptions();
    final Function1<JvmTypeReference,TypeReference> _function = new Function1<JvmTypeReference,TypeReference>() {
        public TypeReference apply(final JvmTypeReference it) {
          CompilationUnitImpl _compilationUnit = GeneratedExecutableDeclarationImpl.this.getCompilationUnit();
          TypeReference _typeReference = _compilationUnit.toTypeReference(it);
          return _typeReference;
        }
      };
    List<TypeReference> _map = ListExtensions.<JvmTypeReference, TypeReference>map(_exceptions, _function);
    return _map;
  }
}
