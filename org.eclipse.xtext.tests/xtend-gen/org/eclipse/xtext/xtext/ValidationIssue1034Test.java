/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xtext.XtextConfigurableIssueCodes;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eva Poell - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
@SuppressWarnings("all")
public class ValidationIssue1034Test extends AbstractXtextTests {
  @Inject
  @Extension
  private ParseHelper<Grammar> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Before
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.with(XtextStandaloneSetup.class);
  }
  
  @Test
  public void check_FirstRuleIsNotFragment() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("grammar com.space.Test with org.eclipse.xtext.common.Terminals");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("generate testDSL \"http://space.com/test\"");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Model:");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("\"type\" type=ID;");
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void check_FirstRuleIsFragment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar com.space.Test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("generate testDSL \"http://space.com/test\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fragment Model:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"type\" type=ID;");
    this.error(_builder);
  }
  
  @Test
  public void check_FirstRuleIsFragmentEmpty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar com.space.Test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("generate testDSL \"http://space.com/test\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fragment Model:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\"error\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Greeting:");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("\'Hello\' name=ID \'!\';");
    this.error(_builder);
  }
  
  @Test
  public void check_FirstRuleIsFragmentParams() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("generate mm \"http://bar\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("fragment MyRule<MyParam>:");
    _builder.newLine();
    _builder.append("\t\t    ");
    _builder.append("<MyParam> name=ID");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("| <!MyParam> name=STRING");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("| name=\'name\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(";");
    this.error(_builder);
  }
  
  private void error(final CharSequence input) {
    try {
      this._validationTestHelper.assertError(this._parseHelper.parse(input), XtextPackage.Literals.PARSER_RULE, XtextConfigurableIssueCodes.INVALID_FRAGMENT_AS_FIRST_RULE, "must not be a fragment");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
