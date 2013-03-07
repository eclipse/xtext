/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.XtendMemberDeclarationImpl;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmTypeReference;

@SuppressWarnings("all")
public class XtendAnnotationTypeElementDeclarationImpl extends XtendMemberDeclarationImpl<XtendField> implements AnnotationTypeElementDeclaration {
  public String getName() {
    XtendField _delegate = this.getDelegate();
    String _name = _delegate.getName();
    return _name;
  }
  
  public Object getDefaultValue() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public Expression getDefaultValueExpression() {
    UnsupportedOperationException _unsupportedOperationException = new UnsupportedOperationException("TODO: auto-generated method stub");
    throw _unsupportedOperationException;
  }
  
  public TypeReference getType() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    XtendField _delegate = this.getDelegate();
    JvmTypeReference _type = _delegate.getType();
    TypeReference _typeReference = _compilationUnit.toTypeReference(_type);
    return _typeReference;
  }
}
