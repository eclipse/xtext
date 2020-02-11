/**
 * Copyright (c) 2019 Malardalen University (http://www.mdh.se) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.XtextConfigurableIssueCodes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Lorenzo Addazi - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
@SuppressWarnings("all")
public class Issue1161Test extends AbstractXtextTests {
  /**
   * @author Lorenzo Addazi - Initial contribution and API
   */
  public static class Issue1161StandaloneSetup extends XtextStandaloneSetup {
    @Override
    public Injector createInjector() {
      abstract class __Issue1161StandaloneSetup_1 extends XtextRuntimeModule {
        public abstract Class<? extends IPreferenceValuesProvider> bindIPreferenceValuesProvider();
      }
      
      __Issue1161StandaloneSetup_1 ___Issue1161StandaloneSetup_1 = new __Issue1161StandaloneSetup_1() {
        public Class<? extends IPreferenceValuesProvider> bindIPreferenceValuesProvider() {
          return IPreferenceValuesProvider.SingletonPreferenceValuesProvider.class;
        }
      };
      return Guice.createInjector(___Issue1161StandaloneSetup_1);
    }
  }
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private ParseHelper<Grammar> _parseHelper;
  
  @Inject
  private MapBasedPreferenceValues preferences;
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.with(Issue1161Test.Issue1161StandaloneSetup.class);
  }
  
  @Before
  public void setPreferences() {
    this.preferences = this.<IPreferenceValuesProvider.SingletonPreferenceValuesProvider>get(IPreferenceValuesProvider.SingletonPreferenceValuesProvider.class).getPreferenceValues(null);
  }
  
  @After
  public void clearPreferences() {
    this.preferences.clear();
  }
  
  @Test
  public void testValidJavaPackageNamingConventionsWithIgnoreSeverity() {
    this.assertNoIssue(this.grammarWithValidJavaPackageNamingConventions());
  }
  
  @Test
  public void testInvalidJavaPackageNamingConventionsWithIgnoreSeverity() {
    this.assertNoIssue(this.grammarWithInvalidJavaPackageNamingConventions());
  }
  
  @Test
  public void testValidJavaPackageNamingConventionsWithErrorSeverity() {
    this.setSeverity("error");
    this.assertNoIssue(this.grammarWithValidJavaPackageNamingConventions());
  }
  
  @Test
  public void testInvalidJavaPackageNamingConventionsWithErrorSeverity() {
    this.setSeverity("error");
    this.assertError(this.grammarWithInvalidJavaPackageNamingConventions());
  }
  
  @Test
  public void testValidJavaPackageNamingConventionsWithWarningSeverity() {
    this.setSeverity("warning");
    this.assertNoIssue(this.grammarWithValidJavaPackageNamingConventions());
  }
  
  @Test
  public void testInvalidJavaPackageNamingConventionsWithWarningSeverity() {
    this.setSeverity("warning");
    this.assertWarning(this.grammarWithInvalidJavaPackageNamingConventions());
  }
  
  @Test
  public void testValidJavaPackageNamingConventionsWithInfoSeverity() {
    this.setSeverity("info");
    this.assertNoIssue(this.grammarWithValidJavaPackageNamingConventions());
  }
  
  @Test
  public void testInvalidJavaPackageNamingConventionsWithInfoSeverity() {
    this.setSeverity("info");
    this.assertInfo(this.grammarWithInvalidJavaPackageNamingConventions());
  }
  
  private void assertError(final CharSequence grammar) {
    this.assertIssue(grammar, Severity.ERROR);
  }
  
  private void assertWarning(final CharSequence grammar) {
    this.assertIssue(grammar, Severity.WARNING);
  }
  
  private void assertInfo(final CharSequence grammar) {
    this.assertIssue(grammar, Severity.INFO);
  }
  
  private void assertIssue(final CharSequence grammar, final Severity severity) {
    try {
      this._validationTestHelper.assertIssue(this._parseHelper.parse(grammar), XtextPackage.Literals.GENERATED_METAMODEL, 
        XtextConfigurableIssueCodes.INVALID_JAVAPACKAGE_NAME, severity);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertNoIssue(final CharSequence grammar) {
    try {
      this._validationTestHelper.assertNoIssue(this._parseHelper.parse(grammar), XtextPackage.Literals.GENERATED_METAMODEL, 
        XtextConfigurableIssueCodes.INVALID_JAVAPACKAGE_NAME);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private CharSequence grammarWithValidJavaPackageNamingConventions() {
    return this.grammarWithGeneratedMetamodelName("testissue1161");
  }
  
  private CharSequence grammarWithInvalidJavaPackageNamingConventions() {
    return this.grammarWithGeneratedMetamodelName("testIssue1161");
  }
  
  private CharSequence grammarWithGeneratedMetamodelName(final String generatedMetamodelName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Issue1161 with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate ");
    _builder.append(generatedMetamodelName);
    _builder.append(" \"http://issue1161\"");
    _builder.newLineIfNotEmpty();
    _builder.append("A : {A};");
    _builder.newLine();
    return _builder;
  }
  
  private void setSeverity(final String severity) {
    this.preferences.put(XtextConfigurableIssueCodes.INVALID_JAVAPACKAGE_NAME, severity);
  }
}
