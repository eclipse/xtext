/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmOperation;

@SuppressWarnings("all")
public class JvmAnnotationTypeElementDeclarationImpl extends JvmMemberDeclarationImpl<JvmOperation> implements AnnotationTypeElementDeclaration {
  @Override
  public Object getDefaultValue() {
    return this.getCompilationUnit().translateAnnotationValue(this.getDelegate().getDefaultValue(), this.getCompilationUnit().getTypeReferences().isArray(this.getDelegate().getReturnType()));
  }
  
  @Override
  public TypeReference getType() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getReturnType());
  }
  
  @Override
  public Expression getDefaultValueExpression() {
    return null;
  }
}
