package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

@SuppressWarnings("all")
public class CheckExceptionValiationTest extends AbstractJvmModelTest {
  @Inject
  private ValidationTestHelper helper;
  
  @Test
  public void testSimple() {
    try {
      final XExpression expression = this.expression("throw new java.io.IOException()", false);
      this.helper.assertError(expression, Literals.XTHROW_EXPRESSION, IssueCodes.UNHANDLED_EXCEPTION);
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
