/**
 * Copyright (c) 2013, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Preconditions;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.CompilationStrategy;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend2.lib.StringConcatenationClient;
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

  public void setDefaultValueExpression(final Expression body) {
    this.checkMutable();
    if ((body == null)) {
      this.getCompilationUnit().getJvmTypesBuilder().removeExistingBody(this.getDelegate());
    } else {
      this.getCompilationUnit().getJvmTypesBuilder().setBody(this.getDelegate(), ((ExpressionImpl) body).getDelegate());
    }
  }

  public void setDefaultValueExpression(final CompilationStrategy compilationStrategy) {
    this.checkMutable();
    Preconditions.checkArgument((compilationStrategy != null), "compilationStrategy cannot be null");
    this.getCompilationUnit().setCompilationStrategy(this.getDelegate(), compilationStrategy);
  }

  public void setDefaultValueExpression(final StringConcatenationClient compilationTemplate) {
    this.checkMutable();
    Preconditions.checkArgument((compilationTemplate != null), "compilationTemplate cannot be null");
    this.getCompilationUnit().setCompilationTemplate(this.getDelegate(), compilationTemplate);
  }

  public void setType(final TypeReference type) {
    this.checkMutable();
    Preconditions.checkArgument((type != null), "returnType cannot be null");
    this.getDelegate().setReturnType(this.getCompilationUnit().toJvmTypeReference(type));
  }
}
