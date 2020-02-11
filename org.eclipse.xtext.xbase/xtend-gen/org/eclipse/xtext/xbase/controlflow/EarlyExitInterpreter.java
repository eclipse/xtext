/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.controlflow;

import com.google.common.base.Objects;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class EarlyExitInterpreter extends SwitchConstantExpressionsInterpreter {
  public boolean isConstant(final XExpression it, final Object value) {
    try {
      final Object constant = this.evaluate(it);
      return Objects.equal(value, constant);
    } catch (final Throwable _t) {
      if (_t instanceof ConstantExpressionEvaluationException) {
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
