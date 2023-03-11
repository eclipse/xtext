/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.lib.macro.declaration.ExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedExecutable;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class ResolvedExecutableImpl<T extends IResolvedExecutable, D extends ExecutableDeclaration> extends AbstractDelegator<T> implements ResolvedExecutable {
  private Iterable<? extends ResolvedParameter> resolvedParameters;

  @Override
  public Iterable<? extends ResolvedParameter> getResolvedParameters() {
    Iterable<? extends ResolvedParameter> _xblockexpression = null;
    {
      if ((this.resolvedParameters == null)) {
        int _size = this.getDelegate().getDeclaration().getParameters().size();
        final Function1<Integer, ResolvedParameterImpl> _function = (Integer i) -> {
          ParameterDeclaration _parameterDeclaration = this.getCompilationUnit().toParameterDeclaration(this.getDelegate().getDeclaration().getParameters().get((i).intValue()));
          TypeReference _typeReference = this.getCompilationUnit().toTypeReference(this.getDelegate().getResolvedParameterTypes().get((i).intValue()));
          return new ResolvedParameterImpl(_parameterDeclaration, _typeReference);
        };
        this.resolvedParameters = IterableExtensions.<Integer, ResolvedParameterImpl>map(new ExclusiveRange(0, _size, true), _function);
      }
      _xblockexpression = this.resolvedParameters;
    }
    return _xblockexpression;
  }

  @Override
  public Iterable<? extends TypeReference> getResolvedExceptionTypes() {
    final Function1<LightweightTypeReference, TypeReference> _function = (LightweightTypeReference it) -> {
      return this.getCompilationUnit().toTypeReference(it);
    };
    return ListExtensions.<LightweightTypeReference, TypeReference>map(this.getDelegate().getResolvedExceptions(), _function);
  }

  @Override
  public D getDeclaration() {
    MemberDeclaration _memberDeclaration = this.getCompilationUnit().toMemberDeclaration(this.getDelegate().getDeclaration());
    return ((D) _memberDeclaration);
  }

  @Override
  public String getSimpleSignature() {
    return this.getDelegate().getSimpleSignature();
  }

  @Override
  public String toString() {
    return this.getDelegate().toString();
  }

  @Override
  public String getResolvedErasureSignature() {
    return this.getDelegate().getResolvedErasureSignature();
  }
}
