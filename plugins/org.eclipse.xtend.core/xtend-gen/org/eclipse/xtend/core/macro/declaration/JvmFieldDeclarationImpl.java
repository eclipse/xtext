/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;

@SuppressWarnings("all")
public class JvmFieldDeclarationImpl extends JvmMemberDeclarationImpl<JvmField> implements FieldDeclaration {
  public Expression getInitializer() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
    JvmTypesBuilder _jvmTypesBuilder = _compilationUnit_1.getJvmTypesBuilder();
    JvmField _delegate = this.getDelegate();
    XExpression _expression = _jvmTypesBuilder.getExpression(_delegate);
    return _compilationUnit.toExpression(_expression);
  }
  
  public boolean isFinal() {
    JvmField _delegate = this.getDelegate();
    return _delegate.isFinal();
  }
  
  public boolean isStatic() {
    JvmField _delegate = this.getDelegate();
    return _delegate.isStatic();
  }
  
  public boolean isTransient() {
    JvmField _delegate = this.getDelegate();
    return _delegate.isTransient();
  }
  
  public boolean isVolatile() {
    JvmField _delegate = this.getDelegate();
    return _delegate.isVolatile();
  }
  
  public TypeReference getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    JvmTypeReference _type = _delegate.getType();
    return _compilationUnit.toTypeReference(_type);
  }
}
