package org.eclipse.xtend.macro.lang.processing;

import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("all")
public class MacroEvaluationException extends RuntimeException {
  public XExpression causer;
  
  public MacroEvaluationException(final XExpression causer, final Throwable cause) {
    super(cause);
    this.causer = causer;
  }
}
