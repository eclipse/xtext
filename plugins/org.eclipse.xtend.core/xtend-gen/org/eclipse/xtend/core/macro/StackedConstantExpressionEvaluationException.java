/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import org.eclipse.xtend.core.macro.ConstantExpressionEvaluationException;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("all")
public class StackedConstantExpressionEvaluationException extends ConstantExpressionEvaluationException {
  private JvmField field;
  
  private ConstantExpressionEvaluationException cause;
  
  public StackedConstantExpressionEvaluationException(final XExpression expression, final JvmField field, final ConstantExpressionEvaluationException cause) {
    super(((("Error during call to " + field.getSimpleName()) + " : ") + cause.getMessage()), expression);
    this.field = field;
    this.cause = cause;
  }
}
