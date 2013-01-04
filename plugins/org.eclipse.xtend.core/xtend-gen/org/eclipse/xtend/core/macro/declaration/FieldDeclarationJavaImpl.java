/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.MemberDeclarationJavaImpl;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.type.TypeReference;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmTypeReference;

@SuppressWarnings("all")
public class FieldDeclarationJavaImpl extends MemberDeclarationJavaImpl<JvmField> implements FieldDeclaration {
  public Expression getInitializer() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("Auto-generated function stub");
    throw _unsupportedOperationException;
  }
  
  public boolean isFinal() {
    JvmField _delegate = this.getDelegate();
    boolean _isFinal = _delegate.isFinal();
    return _isFinal;
  }
  
  public boolean isStatic() {
    JvmField _delegate = this.getDelegate();
    boolean _isStatic = _delegate.isStatic();
    return _isStatic;
  }
  
  public TypeReference getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmField _delegate = this.getDelegate();
    JvmTypeReference _type = _delegate.getType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_type);
    return _typeReference;
  }
}
