/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.parameters;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.parameters.AbstractParametersParsingTest;
import org.eclipse.xtext.parser.parameters.NoParametersTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class NoParametersParsingTest extends AbstractParametersParsingTest {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    NoParametersTestLanguageStandaloneSetup _noParametersTestLanguageStandaloneSetup = new NoParametersTestLanguageStandaloneSetup();
    this.with(_noParametersTestLanguageStandaloneSetup);
  }
  
  @Test
  @Override
  public void testScenario4_keyword() {
    try {
      final ParserRuleParameters instance = this.getModelWithErrors("#4 keyword");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals(null, _first);
      Resource _eResource = instance.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      int _size = _errors.size();
      Assert.assertEquals(1, _size);
      Resource _eResource_1 = instance.eResource();
      EList<Resource.Diagnostic> _errors_1 = _eResource_1.getErrors();
      Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(_errors_1);
      String _message = _head.getMessage();
      Assert.assertEquals("mismatched input \'keyword\' expecting RULE_ID", _message);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testScenario10_keyword() {
    try {
      final ParserRuleParameters instance = this.getModelWithErrors("#10 keyword");
      Scenario _scenario = instance.getScenario();
      String _second = _scenario.getSecond();
      Assert.assertEquals("keyword", _second);
      Resource _eResource = instance.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(_errors);
      String _message = _head.getMessage();
      Assert.assertEquals("mismatched input \'<EOF>\' expecting \'keyword\'", _message);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
