package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage.Literals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("TODO implement exception validation")
@SuppressWarnings("all")
public class CheckExceptionValidationTest extends AbstractJvmModelTest {
  @Inject
  private ValidationTestHelper helper;
  
  @Test
  public void testSimple() {
    try {
      final XExpression expression = this.expression("throw new java.io.IOException()", false);
      this.helper.assertError(expression, Literals.XTHROW_EXPRESSION, IssueCodes.UNHANDLED_EXCEPTION);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
