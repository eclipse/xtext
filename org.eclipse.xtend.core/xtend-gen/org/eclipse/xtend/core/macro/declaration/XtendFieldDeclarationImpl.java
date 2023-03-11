/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("all")
public class XtendFieldDeclarationImpl extends XtendMemberDeclarationImpl<XtendField> implements FieldDeclaration {
  @Override
  public Visibility getVisibility() {
    return this.getCompilationUnit().toVisibility(this.getDelegate().getVisibility());
  }

  @Override
  public String getSimpleName() {
    return this.getDelegate().getName();
  }

  @Override
  public Expression getInitializer() {
    XExpression _initialValue = this.getDelegate().getInitialValue();
    boolean _tripleEquals = (_initialValue == null);
    if (_tripleEquals) {
      return null;
    }
    return this.getCompilationUnit().toExpression(this.getDelegate().getInitialValue());
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
  public boolean isTransient() {
    return false;
  }

  @Override
  public boolean isVolatile() {
    return false;
  }

  @Override
  public TypeReference getType() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getType());
  }

  @Override
  public ClassDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((ClassDeclaration) _declaringType);
  }
}
