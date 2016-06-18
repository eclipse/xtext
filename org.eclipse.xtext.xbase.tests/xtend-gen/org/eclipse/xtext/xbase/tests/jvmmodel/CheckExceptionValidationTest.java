package org.eclipse.xtext.xbase.tests.jvmmodel;

import com.google.inject.Inject;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.tests.jvmmodel.AbstractJvmModelTest;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("all")
public class CheckExceptionValidationTest extends AbstractJvmModelTest {
  @Inject
  private ValidationTestHelper helper;
  
  private MapBasedPreferenceValues preferences;
  
  @Inject
  public void setPreferences(final IPreferenceValuesProvider.SingletonPreferenceValuesProvider prefProvider) {
    MapBasedPreferenceValues _preferenceValues = prefProvider.getPreferenceValues(null);
    this.preferences = _preferenceValues;
  }
  
  @Before
  public void setSeverity() {
    this.preferences.put(IssueCodes.UNHANDLED_EXCEPTION, "error");
  }
  
  @After
  public void clearPreferences() {
    this.preferences.clear();
  }
  
  @Test
  public void testSimple() {
    try {
      final XExpression expression = this.expression("throw new java.io.IOException()", false);
      this.helper.assertError(expression, XbasePackage.Literals.XTHROW_EXPRESSION, IssueCodes.UNHANDLED_EXCEPTION);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
