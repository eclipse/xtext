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
import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.ResolvedParameterImpl;
import org.eclipse.xtend.lib.macro.declaration.ExecutableDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ResolvedExecutable;
import org.eclipse.xtend.lib.macro.declaration.ResolvedParameter;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class ResolvedExecutableImpl<T extends IResolvedExecutable, D extends ExecutableDeclaration> extends AbstractElementImpl<T> implements ResolvedExecutable {
  private Iterable<? extends ResolvedParameter> resolvedParameters;
  
  public Iterable<? extends ResolvedParameter> getResolvedParameters() {
    Iterable<? extends ResolvedParameter> _xblockexpression = null;
    {
      boolean _tripleEquals = (this.resolvedParameters == null);
      if (_tripleEquals) {
        T _delegate = this.getDelegate();
        JvmExecutable _declaration = _delegate.getDeclaration();
        EList<JvmFormalParameter> _parameters = _declaration.getParameters();
        int _size = _parameters.size();
        ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
        final Function1<Integer, ResolvedParameterImpl> _function = new Function1<Integer, ResolvedParameterImpl>() {
          public ResolvedParameterImpl apply(final Integer i) {
            CompilationUnitImpl _compilationUnit = ResolvedExecutableImpl.this.getCompilationUnit();
            T _delegate = ResolvedExecutableImpl.this.getDelegate();
            JvmExecutable _declaration = _delegate.getDeclaration();
            EList<JvmFormalParameter> _parameters = _declaration.getParameters();
            JvmFormalParameter _get = _parameters.get((i).intValue());
            ParameterDeclaration _parameterDeclaration = _compilationUnit.toParameterDeclaration(_get);
            CompilationUnitImpl _compilationUnit_1 = ResolvedExecutableImpl.this.getCompilationUnit();
            T _delegate_1 = ResolvedExecutableImpl.this.getDelegate();
            List<LightweightTypeReference> _resolvedParameterTypes = _delegate_1.getResolvedParameterTypes();
            LightweightTypeReference _get_1 = _resolvedParameterTypes.get((i).intValue());
            TypeReference _typeReference = _compilationUnit_1.toTypeReference(_get_1);
            return new ResolvedParameterImpl(_parameterDeclaration, _typeReference);
          }
        };
        Iterable<ResolvedParameterImpl> _map = IterableExtensions.<Integer, ResolvedParameterImpl>map(_doubleDotLessThan, _function);
        this.resolvedParameters = _map;
      }
      _xblockexpression = this.resolvedParameters;
    }
    return _xblockexpression;
  }
  
  public Iterable<? extends TypeReference> getResolvedExceptions() {
    T _delegate = this.getDelegate();
    List<LightweightTypeReference> _resolvedExceptions = _delegate.getResolvedExceptions();
    final Function1<LightweightTypeReference, TypeReference> _function = new Function1<LightweightTypeReference, TypeReference>() {
      public TypeReference apply(final LightweightTypeReference it) {
        CompilationUnitImpl _compilationUnit = ResolvedExecutableImpl.this.getCompilationUnit();
        return _compilationUnit.toTypeReference(it);
      }
    };
    return ListExtensions.<LightweightTypeReference, TypeReference>map(_resolvedExceptions, _function);
  }
  
  public D getDeclaration() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    T _delegate = this.getDelegate();
    JvmExecutable _declaration = _delegate.getDeclaration();
    MemberDeclaration _memberDeclaration = _compilationUnit.toMemberDeclaration(_declaration);
    return ((D) _memberDeclaration);
  }
  
  public String toString() {
    T _delegate = this.getDelegate();
    return _delegate.toString();
  }
}
