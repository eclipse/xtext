/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendParameter;
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.ParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeParameterDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class XtendConstructorDeclarationImpl extends XtendMemberDeclarationImpl<XtendConstructor> implements ConstructorDeclaration {
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
  public Visibility getVisibility() {
    return this.getCompilationUnit().toVisibility(this.getDelegate().getVisibility());
  }

  @Override
  public String getSimpleName() {
    return this.getDeclaringType().getSimpleName();
  }

  @Override
  public boolean isVarArgs() {
    final Function1<XtendParameter, Boolean> _function = (XtendParameter it) -> {
      return Boolean.valueOf(this.isVarArgs());
    };
    return IterableExtensions.<XtendParameter>exists(this.getDelegate().getParameters(), _function);
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
  public Iterable<? extends TypeParameterDeclaration> getTypeParameters() {
    return CollectionLiterals.<TypeParameterDeclaration>emptyList();
  }
}
