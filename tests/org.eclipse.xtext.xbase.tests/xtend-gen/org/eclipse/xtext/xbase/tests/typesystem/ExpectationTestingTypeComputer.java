/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.tests.typesystem.ExpectationTest;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;

@SuppressWarnings("all")
public class ExpectationTestingTypeComputer extends XbaseTypeComputer {
  private ExpectationTest _test;
  
  public ExpectationTest getTest() {
    return this._test;
  }
  
  public void setTest(final ExpectationTest test) {
    this._test = test;
  }
  
  protected void _computeTypes(final XNullLiteral object, final ITypeComputationState state) {
    ExpectationTest _test = this.getTest();
    _test.recordExpectation(state);
    super._computeTypes(object, state);
  }
}
