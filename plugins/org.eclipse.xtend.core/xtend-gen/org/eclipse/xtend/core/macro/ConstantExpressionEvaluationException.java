/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import org.eclipse.xtext.xbase.XExpression;

/**
 * Indicates a problem during evaluation
 */
@SuppressWarnings("all")
public class ConstantExpressionEvaluationException extends RuntimeException {
  private XExpression expression;
  
  public ConstantExpressionEvaluationException(final String message) {
    super(message);
  }
  
  public ConstantExpressionEvaluationException(final String message, final XExpression expression) {
    this(message);
    this.expression = expression;
  }
  
  public XExpression getExpression() {
    return this.expression;
  }
}
