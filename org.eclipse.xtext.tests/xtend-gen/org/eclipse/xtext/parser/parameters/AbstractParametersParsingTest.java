/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser.parameters;

import com.google.inject.Injector;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.Scenario;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractParametersParsingTest extends AbstractXtextTests {
  @Override
  protected void setInjector(final Injector injector) {
    super.setInjector(injector);
    this.injectMembers(this);
  }
  
  @Override
  protected boolean shouldTestSerializer(final XtextResource resource) {
    return false;
  }
  
  @Override
  public ParserRuleParameters getModel(final String model) throws Exception {
    EObject _model = super.getModel(model);
    return ((ParserRuleParameters) _model);
  }
  
  protected ParserRuleParameters getModelWithErrors(final String model) throws Exception {
    EObject _modelAndExpect = this.getModelAndExpect(model, AbstractXtextTests.EXPECT_ERRORS);
    return ((ParserRuleParameters) _modelAndExpect);
  }
  
  @Test
  public void testScenario1_first() {
    try {
      final ParserRuleParameters instance = this.getModel("#1 first");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("first", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario2_second() {
    try {
      final ParserRuleParameters instance = this.getModel("#2 second");
      Scenario _scenario = instance.getScenario();
      String _second = _scenario.getSecond();
      Assert.assertEquals("second", _second);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario3_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#3 keyword");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("keyword", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario3_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#3 id");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("id", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
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
  public void testScenario4_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#4 id");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("id", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario5_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#5 keyword");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("keyword", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario5_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#5 id");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("id", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario6_keyword() {
    try {
      final ParserRuleParameters instance = this.getModelWithErrors("#6 keyword");
      Scenario _scenario = instance.getScenario();
      Assert.assertEquals(null, _scenario);
      Resource _eResource = instance.eResource();
      EList<Resource.Diagnostic> _errors = _eResource.getErrors();
      Resource.Diagnostic _head = IterableExtensions.<Resource.Diagnostic>head(_errors);
      String _message = _head.getMessage();
      Assert.assertEquals("no viable alternative at input \'#6\'", _message);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario6_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#6 id");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("id", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario7_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#7 keyword");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("keyword", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario7_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#7 id");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("id", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario8_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#8 keyword");
      Scenario _scenario = instance.getScenario();
      String _second = _scenario.getSecond();
      Assert.assertEquals("keyword", _second);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario8_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#8 id");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("id", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario9_keyword_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#9 keyword keyword");
      Scenario _scenario = instance.getScenario();
      String _second = _scenario.getSecond();
      Assert.assertEquals("keyword", _second);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario9_id_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#9 id keyword");
      Scenario _scenario = instance.getScenario();
      String _second = _scenario.getSecond();
      Assert.assertEquals("id", _second);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario9_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#9 id");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("id", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario9_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#9 keyword");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("keyword", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario10_keyword_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#10 keyword keyword");
      Scenario _scenario = instance.getScenario();
      String _second = _scenario.getSecond();
      Assert.assertEquals("keyword", _second);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario10_id_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#10 id keyword");
      Scenario _scenario = instance.getScenario();
      String _second = _scenario.getSecond();
      Assert.assertEquals("id", _second);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario10_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#10 id");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("id", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
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
  
  @Test
  public void testScenario11_keyword_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#11 keyword keyword");
      Scenario _scenario = instance.getScenario();
      String _first = _scenario.getFirst();
      Assert.assertEquals("keyword", _first);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario11_id_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#11 id keyword");
      Scenario _scenario = instance.getScenario();
      String _second = _scenario.getSecond();
      Assert.assertEquals("id", _second);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
