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
import org.eclipse.xtend.core.macro.declaration.MemberDeclarationJavaImpl;
import org.eclipse.xtend.lib.macro.declaration.ExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public abstract class ExecutableDeclarationJavaImpl<T extends JvmExecutable> extends MemberDeclarationJavaImpl<T> implements ExecutableDeclaration {
  public List<TypeParameterDeclaration> getFormalTypeParameters() {
    JvmTypeParameterDeclarator _delegate = this.getDelegate();
    EList<JvmTypeParameter> _typeParameters = _delegate.getTypeParameters();
    final Function1<JvmTypeParameter,TypeParameterDeclaration> _function = new Function1<JvmTypeParameter,TypeParameterDeclaration>() {
        public TypeParameterDeclaration apply(final JvmTypeParameter it) {
          CompilationUnitImpl _compilationUnit = ExecutableDeclarationJavaImpl.this.getCompilationUnit();
          TypeParameterDeclaration _typeParameterDeclaration = _compilationUnit.toTypeParameterDeclaration(it);
          return _typeParameterDeclaration;
        }
      };
    List<TypeParameterDeclaration> _map = ListExtensions.<JvmTypeParameter, TypeParameterDeclaration>map(_typeParameters, _function);
    return _map;
  }
  
  public TypeReference getType() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
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
}
