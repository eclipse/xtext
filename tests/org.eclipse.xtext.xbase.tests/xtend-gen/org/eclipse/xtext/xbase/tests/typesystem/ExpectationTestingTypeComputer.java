/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractExpectationTest;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ExpectationTestingTypeComputer extends XbaseTypeComputer {
  private AbstractExpectationTest _test;
  
  public AbstractExpectationTest getTest() {
    return this._test;
  }
  
  public void setTest(final AbstractExpectationTest test) {
    this._test = test;
  }
  
  private Function1<? super XExpression, ? extends Boolean> _predicate = new Function1<XExpression, Boolean>() {
    public Boolean apply(final XExpression it) {
      return Boolean.valueOf((it instanceof XNullLiteral));
    }
  };
  
  public Function1<? super XExpression, ? extends Boolean> getPredicate() {
    return this._predicate;
  }
  
  public void setPredicate(final Function1<? super XExpression, ? extends Boolean> predicate) {
    this._predicate = predicate;
  }
  
  public void computeTypes(final XExpression expression, final ITypeComputationState state) {
    Function1<? super XExpression, ? extends Boolean> _predicate = this.getPredicate();
    Boolean _apply = _predicate.apply(expression);
    if ((_apply).booleanValue()) {
      AbstractExpectationTest _test = this.getTest();
      _test.recordExpectation(expression, state);
    }
    super.computeTypes(expression, state);
  }
}
