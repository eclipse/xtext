/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.tests.typesystem.AbstractExpectationTest;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class ExpectationTestingTypeComputer extends XbaseTypeComputer {
  @Accessors
  private AbstractExpectationTest test;
  
  @Accessors
  private Function1<? super XExpression, ? extends Boolean> predicate = ((Function1<XExpression, Boolean>) (XExpression it) -> {
    return Boolean.valueOf((it instanceof XNullLiteral));
  });
  
  @Override
  public void computeTypes(final XExpression expression, final ITypeComputationState state) {
    Boolean _apply = this.predicate.apply(expression);
    if ((_apply).booleanValue()) {
      this.test.recordExpectation(expression, state);
    }
    super.computeTypes(expression, state);
  }
  
  @Pure
  public AbstractExpectationTest getTest() {
    return this.test;
  }
  
  public void setTest(final AbstractExpectationTest test) {
    this.test = test;
  }
  
  @Pure
  public Function1<? super XExpression, ? extends Boolean> getPredicate() {
    return this.predicate;
  }
  
  public void setPredicate(final Function1<? super XExpression, ? extends Boolean> predicate) {
    this.predicate = predicate;
  }
}
