/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.ResolvedExecutableImpl;
import org.eclipse.xtend.core.macro.declaration.ResolvedTypeParameterImpl;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.ResolvedTypeParameter;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  
  public Iterable<? extends ResolvedTypeParameter> getResolvedTypeParameters() {
    ArrayList<ResolvedTypeParameterImpl> _xblockexpression = null;
    {
      final ArrayList<ResolvedTypeParameterImpl> resolvedTypeParameters = CollectionLiterals.<ResolvedTypeParameterImpl>newArrayList();
      for (int i = 0; (i < this.getDelegate().getResolvedTypeParameters().size()); i++) {
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        IResolvedOperation _delegate = this.getDelegate();
        List<JvmTypeParameter> _resolvedTypeParameters = _delegate.getResolvedTypeParameters();
        JvmTypeParameter _get = _resolvedTypeParameters.get(i);
        TypeParameterDeclaration _typeParameterDeclaration = _compilationUnit.toTypeParameterDeclaration(_get);
        IResolvedOperation _delegate_1 = this.getDelegate();
        List<LightweightTypeReference> _resolvedTypeParameterConstraints = _delegate_1.getResolvedTypeParameterConstraints(i);
        final Function1<LightweightTypeReference, TypeReference> _function = new Function1<LightweightTypeReference, TypeReference>() {
          public TypeReference apply(final LightweightTypeReference it) {
            CompilationUnitImpl _compilationUnit = ResolvedMethodImpl.this.getCompilationUnit();
            return _compilationUnit.toTypeReference(it);
          }
        };
        List<TypeReference> _map = ListExtensions.<LightweightTypeReference, TypeReference>map(_resolvedTypeParameterConstraints, _function);
        List<TypeReference> _list = IterableExtensions.<TypeReference>toList(_map);
        ResolvedTypeParameterImpl _resolvedTypeParameterImpl = new ResolvedTypeParameterImpl(_typeParameterDeclaration, _list);
        resolvedTypeParameters.add(_resolvedTypeParameterImpl);
      }
      _xblockexpression = resolvedTypeParameters;
    }
    return _xblockexpression;
  }
}
