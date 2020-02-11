/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.parameters;

import com.google.inject.Injector;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.parser.parameters.parametersTestLanguage.ParserRuleParameters;
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
      Assert.assertEquals("first", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario2_second() {
    try {
      final ParserRuleParameters instance = this.getModel("#2 second");
      Assert.assertEquals("second", instance.getScenario().getSecond());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario3_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#3 keyword");
      Assert.assertEquals("keyword", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario3_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#3 id");
      Assert.assertEquals("id", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario4_keyword() {
    try {
      final ParserRuleParameters instance = this.getModelWithErrors("#4 keyword");
      Assert.assertEquals(null, instance.getScenario().getFirst());
      Assert.assertEquals(1, instance.eResource().getErrors().size());
      Assert.assertEquals("mismatched input \'keyword\' expecting RULE_ID", IterableExtensions.<Resource.Diagnostic>head(instance.eResource().getErrors()).getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario4_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#4 id");
      Assert.assertEquals("id", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario5_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#5 keyword");
      Assert.assertEquals("keyword", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario5_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#5 id");
      Assert.assertEquals("id", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario6_keyword() {
    try {
      final ParserRuleParameters instance = this.getModelWithErrors("#6 keyword");
      Assert.assertEquals(null, instance.getScenario());
      Assert.assertEquals("no viable alternative at input \'#6\'", IterableExtensions.<Resource.Diagnostic>head(instance.eResource().getErrors()).getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario6_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#6 id");
      Assert.assertEquals("id", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario7_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#7 keyword");
      Assert.assertEquals("keyword", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario7_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#7 id");
      Assert.assertEquals("id", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario8_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#8 keyword");
      Assert.assertEquals("keyword", instance.getScenario().getSecond());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario8_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#8 id");
      Assert.assertEquals("id", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario9_keyword_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#9 keyword keyword");
      Assert.assertEquals("keyword", instance.getScenario().getSecond());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario9_id_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#9 id keyword");
      Assert.assertEquals("id", instance.getScenario().getSecond());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario9_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#9 id");
      Assert.assertEquals("id", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario9_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#9 keyword");
      Assert.assertEquals("keyword", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario10_keyword_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#10 keyword keyword");
      Assert.assertEquals("keyword", instance.getScenario().getSecond());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario10_id_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#10 id keyword");
      Assert.assertEquals("id", instance.getScenario().getSecond());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario10_id() {
    try {
      final ParserRuleParameters instance = this.getModel("#10 id");
      Assert.assertEquals("id", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario10_keyword() {
    try {
      final ParserRuleParameters instance = this.getModelWithErrors("#10 keyword");
      Assert.assertEquals("keyword", instance.getScenario().getSecond());
      Assert.assertEquals("mismatched input \'<EOF>\' expecting \'keyword\'", IterableExtensions.<Resource.Diagnostic>head(instance.eResource().getErrors()).getMessage());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario11_keyword_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#11 keyword keyword");
      Assert.assertEquals("keyword", instance.getScenario().getFirst());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testScenario11_id_keyword() {
    try {
      final ParserRuleParameters instance = this.getModel("#11 id keyword");
      Assert.assertEquals("id", instance.getScenario().getSecond());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
