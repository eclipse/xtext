package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.eclipse.xtext.xbase.validation.IssueCodes;

@SuppressWarnings("all")
public class CheckExceptionValiationTest extends AbstractJvmModelTest {
  @Inject
  private ValidationTestHelper helper;
  
  public void testSimple() {
    try {
      {
        XExpression _expression = this.expression("throw new java.io.IOException()", false);
        final XExpression expression = _expression;
        this.helper.assertError(expression, Literals.XTHROW_EXPRESSION, IssueCodes.UNHANDLED_EXCEPTION);
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
