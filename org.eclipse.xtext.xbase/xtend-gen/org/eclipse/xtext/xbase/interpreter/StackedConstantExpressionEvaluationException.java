/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.interpreter;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.lib.Functions.Function0;

@SuppressWarnings("all")
public class StackedConstantExpressionEvaluationException extends ConstantExpressionEvaluationException {
  public StackedConstantExpressionEvaluationException(final XExpression expression, final JvmField field, final ConstantExpressionEvaluationException cause) {
    super(new Function0<String>() {
      @Override
      public String apply() {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Error during call to ");
        String _simpleName = field.getSimpleName();
        _builder.append(_simpleName);
        _builder.append(" : ");
        String _message = cause.getMessage();
        _builder.append(_message);
        return _builder.toString();
      }
    }.apply(), expression, cause);
  }
}
