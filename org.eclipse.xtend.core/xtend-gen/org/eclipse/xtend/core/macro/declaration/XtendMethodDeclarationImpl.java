/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;

@SuppressWarnings("all")
public class XtendMethodDeclarationImpl extends XtendMemberDeclarationImpl<XtendFunction> implements MethodDeclaration {
  @Override
  public boolean isAbstract() {
    XExpression _expression = this.getDelegate().getExpression();
    return (_expression == null);
  }

  @Override
  public boolean isFinal() {
    return this.getDelegate().isFinal();
  }

  @Override
  public boolean isStatic() {
    return this.getDelegate().isStatic();
  }

  @Override
  public boolean isSynchronized() {
    return false;
  }

  @Override
  public boolean isDefault() {
    return (((!this.getDelegate().isStatic()) && (this.getDelegate().getExpression() != null)) && (this.getDeclaringType() instanceof InterfaceDeclaration));
  }

  @Override
  public boolean isStrictFloatingPoint() {
    return false;
  }

  @Override
  public boolean isNative() {
    return false;
  }

  @Override
  public TypeReference getReturnType() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getReturnType());
  }

  @Override
  public Visibility getVisibility() {
    return this.getCompilationUnit().toVisibility(this.getDelegate().getVisibility());
  }

  @Override
  public String getSimpleName() {
    return this.getDelegate().getName();
  }

  @Override
  public Expression getBody() {
    XExpression _expression = this.getDelegate().getExpression();
    boolean _tripleEquals = (_expression == null);
    if (_tripleEquals) {
      return null;
    }
    return this.getCompilationUnit().toExpression(this.getDelegate().getExpression());
  }

  @Override
  public boolean isVarArgs() {
    final Function1<XtendParameter, Boolean> _function = (XtendParameter it) -> {
      return Boolean.valueOf(this.isVarArgs());
    };
    return IterableExtensions.<XtendParameter>exists(this.getDelegate().getParameters(), _function);
  }

  @Override
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    final Function1<JvmTypeParameter, XtendTypeParameterDeclarationImpl> _function = (JvmTypeParameter it) -> {
      return this.getCompilationUnit().toXtendTypeParameterDeclaration(it);
    };
    return ListExtensions.<JvmTypeParameter, XtendTypeParameterDeclarationImpl>map(this.getDelegate().getTypeParameters(), _function);
  }

  @Override
  public Iterable<? extends TypeReference> getExceptions() {
    final Function1<JvmTypeReference, TypeReference> _function = (JvmTypeReference it) -> {
      return this.getCompilationUnit().toTypeReference(it);
    };
    return ListExtensions.<JvmTypeReference, TypeReference>map(this.getDelegate().getExceptions(), _function);
  }

  @Override
  public Iterable<? extends ParameterDeclaration> getParameters() {
    final Function1<XtendParameter, XtendParameterDeclarationImpl> _function = (XtendParameter it) -> {
      return this.getCompilationUnit().toXtendParameterDeclaration(it);
    };
    return ListExtensions.<XtendParameter, XtendParameterDeclarationImpl>map(this.getDelegate().getParameters(), _function);
  }

  @Override
  public Iterable<? extends MethodDeclaration> getOverriddenOrImplementedMethods() {
    boolean _isOverride = this.getDelegate().isOverride();
    if (_isOverride) {
      final JvmOperation jvmOperation = this.getCompilationUnit().getJvmModelAssociations().getDirectlyInferredOperation(this.getDelegate());
      final ResolvedFeatures resolvedFeatures = this.getCompilationUnit().getOverrideHelper().getResolvedFeatures(jvmOperation.getDeclaringType());
      final IResolvedOperation resolvedOperation = resolvedFeatures.getResolvedOperation(jvmOperation);
      final List<IResolvedOperation> overriddenOrImplemented = resolvedOperation.getOverriddenAndImplementedMethods();
      final Function1<IResolvedOperation, MemberDeclaration> _function = (IResolvedOperation it) -> {
        return this.getCompilationUnit().toMemberDeclaration(it.getDeclaration());
      };
      return Iterables.<MethodDeclaration>filter(ListExtensions.<IResolvedOperation, MemberDeclaration>map(overriddenOrImplemented, _function), MethodDeclaration.class);
    }
    return CollectionLiterals.<MethodDeclaration>emptyList();
  }
}
