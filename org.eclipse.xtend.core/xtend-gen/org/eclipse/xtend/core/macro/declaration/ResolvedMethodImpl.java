/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedMethod;
import org.eclipse.xtend.lib.macro.declaration.ResolvedTypeParameter;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class ResolvedMethodImpl extends ResolvedExecutableImpl<IResolvedOperation, MethodDeclaration> implements ResolvedMethod {
  @Override
  public TypeReference getResolvedReturnType() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getResolvedReturnType());
  }

  @Override
  public Iterable<? extends ResolvedTypeParameter> getResolvedTypeParameters() {
    ArrayList<ResolvedTypeParameterImpl> _xblockexpression = null;
    {
      final ArrayList<ResolvedTypeParameterImpl> resolvedTypeParameters = CollectionLiterals.<ResolvedTypeParameterImpl>newArrayList();
      for (int i = 0; (i < this.getDelegate().getResolvedTypeParameters().size()); i++) {
        TypeParameterDeclaration _typeParameterDeclaration = this.getCompilationUnit().toTypeParameterDeclaration(this.getDelegate().getResolvedTypeParameters().get(i));
        final Function1<LightweightTypeReference, TypeReference> _function = (LightweightTypeReference it) -> {
          return this.getCompilationUnit().toTypeReference(it);
        };
        List<TypeReference> _list = IterableExtensions.<TypeReference>toList(ListExtensions.<LightweightTypeReference, TypeReference>map(this.getDelegate().getResolvedTypeParameterConstraints(i), _function));
        ResolvedTypeParameterImpl _resolvedTypeParameterImpl = new ResolvedTypeParameterImpl(_typeParameterDeclaration, _list);
        resolvedTypeParameters.add(_resolvedTypeParameterImpl);
      }
      _xblockexpression = resolvedTypeParameters;
    }
    return _xblockexpression;
  }
}
