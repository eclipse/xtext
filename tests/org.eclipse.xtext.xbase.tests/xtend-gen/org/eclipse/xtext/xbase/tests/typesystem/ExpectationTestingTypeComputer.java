package org.eclipse.xtext.xbase.tests.typesystem;

import com.google.inject.Singleton;
import org.eclipse.xtext.xbase.XNullLiteral;
import org.eclipse.xtext.xbase.tests.typesystem.ExpectationTest;
import org.eclipse.xtext.xbase.typesystem.computation.XbaseTypeComputer;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeComputationState;

@Singleton
@SuppressWarnings("all")
public class ExpectationTestingTypeComputer extends XbaseTypeComputer {
  private ExpectationTest _test;
  
  public ExpectationTest getTest() {
    return this._test;
  }
  
  public void setTest(final ExpectationTest test) {
    this._test = test;
  }
  
  protected void _computeTypes(final XNullLiteral object, final LightweightTypeComputationState state) {
    ExpectationTest _test = this.getTest();
    _test.recordExpectation(state);
    super._computeTypes(object, state);
  }
}
