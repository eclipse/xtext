/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.interpreter;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class StackedConstantExpressionEvaluationException extends ConstantExpressionEvaluationException {
  private final JvmField field;
  
  private final ConstantExpressionEvaluationException exceptionCause;
  
  public StackedConstantExpressionEvaluationException(final XExpression expression, final JvmField field, final ConstantExpressionEvaluationException cause) {
    super(new Function0<String>() {
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
    }.apply(), expression);
    this.field = field;
    this.exceptionCause = cause;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.field== null) ? 0 : this.field.hashCode());
    return prime * result + ((this.exceptionCause== null) ? 0 : this.exceptionCause.hashCode());
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    StackedConstantExpressionEvaluationException other = (StackedConstantExpressionEvaluationException) obj;
    if (this.field == null) {
      if (other.field != null)
        return false;
    } else if (!this.field.equals(other.field))
      return false;
    if (this.exceptionCause == null) {
      if (other.exceptionCause != null)
        return false;
    } else if (!this.exceptionCause.equals(other.exceptionCause))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    return new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
  }
  
  @Pure
  public JvmField getField() {
    return this.field;
  }
  
  @Pure
  public ConstantExpressionEvaluationException getExceptionCause() {
    return this.exceptionCause;
  }
}
