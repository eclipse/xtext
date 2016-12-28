/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.xtend.core.macro.declaration.JvmMemberDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmField;

@SuppressWarnings("all")
public class JvmFieldDeclarationImpl extends JvmMemberDeclarationImpl<JvmField> implements FieldDeclaration {
  @Override
  public Expression getInitializer() {
    return this.getCompilationUnit().toExpression(this.getCompilationUnit().getJvmTypesBuilder().getExpression(this.getDelegate()));
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
    return this.getDelegate().isTransient();
  }
  
  @Override
  public boolean isVolatile() {
    return this.getDelegate().isVolatile();
  }
  
  @Override
  public TypeReference getType() {
    return this.getCompilationUnit().toTypeReference(this.getDelegate().getType());
  }
  
  @Override
  public void remove() {
    this.getCompilationUnit().getJvmModelAssociator().removeLogicalChildAssociation(this.getDelegate());
    super.remove();
  }
}
