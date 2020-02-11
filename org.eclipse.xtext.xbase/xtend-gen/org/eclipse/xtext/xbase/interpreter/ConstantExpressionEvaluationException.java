/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.interpreter;

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
  
  public ConstantExpressionEvaluationException(final String message, final XExpression expression, final Throwable cause) {
    super(message, cause);
    this.expression = expression;
  }
  
  public XExpression getExpression() {
    return this.expression;
  }
}
