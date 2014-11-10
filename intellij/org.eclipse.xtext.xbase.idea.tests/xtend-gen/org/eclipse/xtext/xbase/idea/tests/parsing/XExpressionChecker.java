package org.eclipse.xtext.xbase.idea.tests.parsing;

import org.eclipse.xtext.xbase.XExpression;

@SuppressWarnings("all")
public interface XExpressionChecker {
  public abstract XExpression testExpression(final String code, final boolean resolve);
}
