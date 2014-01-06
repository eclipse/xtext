/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.declaration.Visibility;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("all")
public class XtendFieldDeclarationImpl extends XtendMemberDeclarationImpl<XtendField> implements FieldDeclaration {
  public Visibility getVisibility() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendField _delegate = this.getDelegate();
    JvmVisibility _visibility = _delegate.getVisibility();
    return _compilationUnit.toVisibility(_visibility);
  }
  
  public String getSimpleName() {
    XtendField _delegate = this.getDelegate();
    return _delegate.getName();
  }
  
  public Expression getInitializer() {
    XtendField _delegate = this.getDelegate();
    XExpression _initialValue = _delegate.getInitialValue();
    boolean _equals = Objects.equal(_initialValue, null);
    if (_equals) {
      return null;
    }
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendField _delegate_1 = this.getDelegate();
    XExpression _initialValue_1 = _delegate_1.getInitialValue();
    return _compilationUnit.toExpression(_initialValue_1);
  }
  
  public boolean isFinal() {
    XtendField _delegate = this.getDelegate();
    return _delegate.isFinal();
  }
  
  public boolean isStatic() {
    XtendField _delegate = this.getDelegate();
    return _delegate.isStatic();
  }
  
  public boolean isTransient() {
    return false;
  }
  
  public boolean isVolatile() {
    return false;
  }
  
  public TypeReference getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendField _delegate = this.getDelegate();
    JvmTypeReference _type = _delegate.getType();
    return _compilationUnit.toTypeReference(_type);
  }
  
  public ClassDeclaration getDeclaringType() {
    TypeDeclaration _declaringType = super.getDeclaringType();
    return ((ClassDeclaration) _declaringType);
  }
}
