/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.List;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.ResolvedExecutableImpl;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class ResolvedMethodImpl extends ResolvedExecutableImpl<IResolvedOperation, MethodDeclaration> implements ResolvedMethod {
  public TypeReference getResolvedReturnType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    IResolvedOperation _delegate = this.getDelegate();
    LightweightTypeReference _resolvedReturnType = _delegate.getResolvedReturnType();
    return _compilationUnit.toTypeReference(_resolvedReturnType);
  }
  
  public Iterable<? extends TypeParameterDeclaration> getResolvedTypeParameters() {
    IResolvedOperation _delegate = this.getDelegate();
    List<JvmTypeParameter> _resolvedTypeParameters = _delegate.getResolvedTypeParameters();
    final Function1<JvmTypeParameter, TypeParameterDeclaration> _function = new Function1<JvmTypeParameter, TypeParameterDeclaration>() {
      public TypeParameterDeclaration apply(final JvmTypeParameter it) {
        CompilationUnitImpl _compilationUnit = ResolvedMethodImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeParameterDeclaration(it);
      }
    };
    return ListExtensions.<JvmTypeParameter, TypeParameterDeclaration>map(_resolvedTypeParameters, _function);
  }
}
