/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext;

import java.io.InputStream;
import java.util.List;
import org.eclipse.emf.common.util.URI;
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
    ReducedXtextResourceValidator _get = this.<ReducedXtextResourceValidator>get(ReducedXtextResourceValidator.class);
    this.resourceValidator = _get;
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
    XtextResource _errorneousResource = this.getErrorneousResource(grammarAsString);
    final List<Issue> issues = this.resourceValidator.validate(_errorneousResource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
    String _string = issues.toString();
    int _size = issues.size();
    Assert.assertEquals(_string, 0, _size);
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
    XtextResource _errorneousResource = this.getErrorneousResource(grammarAsString);
    final List<Issue> issues = this.resourceValidator.validate(_errorneousResource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
    String _string = issues.toString();
    int _size = issues.size();
    Assert.assertEquals(_string, 1, _size);
    String _string_1 = issues.toString();
    Issue _head = IterableExtensions.<Issue>head(issues);
    String _message = _head.getMessage();
    boolean _contains = _message.contains("extraneous input \';\'");
    Assert.assertTrue(_string_1, _contains);
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
    XtextResource _errorneousResource = this.getErrorneousResource(grammarAsString);
    final List<Issue> issues = this.resourceValidator.validate(_errorneousResource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
    String _string = issues.toString();
    int _size = issues.size();
    Assert.assertEquals(_string, 1, _size);
    String _string_1 = issues.toString();
    Issue _head = IterableExtensions.<Issue>head(issues);
    String _message = _head.getMessage();
    boolean _contains = _message.contains("IDS");
    Assert.assertTrue(_string_1, _contains);
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
    XtextResource _errorneousResource = this.getErrorneousResource(grammarAsString);
    final List<Issue> issues = this.resourceValidator.validate(_errorneousResource, CheckMode.NORMAL_AND_FAST, CancelIndicator.NullImpl);
    String _string = issues.toString();
    int _size = issues.size();
    Assert.assertEquals(_string, 1, _size);
    String _string_1 = issues.toString();
    Issue _head = IterableExtensions.<Issue>head(issues);
    String _message = _head.getMessage();
    boolean _contains = _message.contains("Trminals");
    Assert.assertTrue(_string_1, _contains);
  }
  
  public XtextResource getErrorneousResource(final CharSequence seq) {
    try {
      String _string = seq.toString();
      InputStream _asStream = this.getAsStream(_string);
      URI _testModelURI = this.getTestModelURI();
      return this.doGetResource(_asStream, _testModelURI);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
