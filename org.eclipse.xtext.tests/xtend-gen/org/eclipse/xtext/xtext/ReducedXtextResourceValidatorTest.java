/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xtext.ReducedXtextResourceValidator;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class ReducedXtextResourceValidatorTest extends AbstractXtextTests {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    XtextStandaloneSetup _xtextStandaloneSetup = new XtextStandaloneSetup();
    this.with(_xtextStandaloneSetup);
    this.resourceValidator = this.<ReducedXtextResourceValidator>get(ReducedXtextResourceValidator.class);
  }
  
  private ReducedXtextResourceValidator resourceValidator;
  
  @Test
  public void testNoEcoreLinkingErrors() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \'http://test\' as test");
    _builder.newLine();
    _builder.append("Root returns test::Foo: name=ID;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final List<Issue> issues = this.resourceValidator.validate(this.getErroneousResource(grammarAsString), CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
    Assert.assertEquals(issues.toString(), 0, issues.size());
  }
  
  @Test
  public void testSyntaxErrors() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \'http://test\' as test");
    _builder.newLine();
    _builder.append("Root returns test::Foo: name=ID;;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final List<Issue> issues = this.resourceValidator.validate(this.getErroneousResource(grammarAsString), CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
    Assert.assertEquals(issues.toString(), 1, issues.size());
    Assert.assertTrue(issues.toString(), IterableExtensions.<Issue>head(issues).getMessage().contains("extraneous input \';\'"));
  }
  
  @Test
  public void testRuleLinkingErrors() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("import \'http://test\' as test");
    _builder.newLine();
    _builder.append("Root returns test::Foo : name=IDS;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final List<Issue> issues = this.resourceValidator.validate(this.getErroneousResource(grammarAsString), CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
    Assert.assertEquals(issues.toString(), 1, issues.size());
    Assert.assertTrue(issues.toString(), IterableExtensions.<Issue>head(issues).getMessage().contains("IDS"));
  }
  
  @Test
  public void testGrammarLinkingErrors() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Trminals");
    _builder.newLine();
    _builder.append("import \'http://test\' as test");
    _builder.newLine();
    _builder.append("Root returns test::Foo : name=\'foo\';");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final List<Issue> issues = this.resourceValidator.validate(this.getErroneousResource(grammarAsString), CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
    Assert.assertEquals(issues.toString(), 1, issues.size());
    Assert.assertTrue(issues.toString(), IterableExtensions.<Issue>head(issues).getMessage().contains("Trminals"));
  }
  
  public XtextResource getErroneousResource(final CharSequence seq) {
    try {
      return this.doGetResource(this.getAsStream(seq.toString()), this.getTestModelURI());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
