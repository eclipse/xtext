/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.xtend.lib.macro.declaration.MemberDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;

@SuppressWarnings("all")
public class JvmMethodDeclarationImpl extends JvmExecutableDeclarationImpl<JvmOperation> implements MethodDeclaration {
  @Override
  public boolean isAbstract() {
    return this.getDelegate().isAbstract();
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
    return this.getDelegate().isSynchronized();
  }

  @Override
  public boolean isDefault() {
    return this.getDelegate().isDefault();
  }

  @Override
  public boolean isStrictFloatingPoint() {
    return this.getDelegate().isStrictFloatingPoint();
  }

  @Override
  public boolean isNative() {
    return this.getDelegate().isNative();
  }

  @Override
  public TypeReference getReturnType() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getReturnType());
  }

  @Override
  public Iterable<? extends MethodDeclaration> getOverriddenOrImplementedMethods() {
    final ResolvedFeatures resolvedFeatures = this.getCompilationUnit().getOverrideHelper().getResolvedFeatures(this.getDelegate().getDeclaringType());
    final IResolvedOperation resolvedOperation = resolvedFeatures.getResolvedOperation(this.getDelegate());
    final List<IResolvedOperation> overriddenOrImplemented = resolvedOperation.getOverriddenAndImplementedMethods();
    final Function1<IResolvedOperation, MemberDeclaration> _function = (IResolvedOperation it) -> {
      return this.getCompilationUnit().toMemberDeclaration(it.getDeclaration());
    };
    return Iterables.<MethodDeclaration>filter(ListExtensions.<IResolvedOperation, MemberDeclaration>map(overriddenOrImplemented, _function), MethodDeclaration.class);
  }
}
