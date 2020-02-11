/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguageStandaloneSetup;
import org.eclipse.xtext.parsetree.reconstr.serializationerror.Model;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.smoketest.processors.PartialParsingProcessor;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class Bug410560Test extends AbstractXtextTests {
  @Override
  public boolean shouldTestSerializer(final XtextResource resource) {
    return false;
  }
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    this.with(SerializationErrorTestLanguageStandaloneSetup.class);
  }
  
  @Test
  public void testParsingWithoutIndent_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{}");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Model model = ((Model) _model);
      Assert.assertNotNull(model);
      Assert.assertNull(model.getTest());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingWithoutIndent_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("({})");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Model model = ((Model) _model);
      Assert.assertNotNull(model);
      Assert.assertNull(model.getTest());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingWithIndent_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{tworequired a b}");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Model model = ((Model) _model);
      Assert.assertNotNull(model);
      Assert.assertNotNull(model.getTest());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParsingWithIndent_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("({tworequired a b})");
      _builder.newLine();
      EObject _model = this.getModel(_builder.toString());
      final Model model = ((Model) _model);
      Assert.assertNotNull(model);
      Assert.assertNotNull(model.getTest());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPartialParsingChangeIndent() {
    try {
      final String modelAsString = "({tworequired a b})";
      EObject _model = this.getModel(modelAsString);
      final Model model = ((Model) _model);
      Resource _eResource = model.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(modelAsString.indexOf("a"), 1, "b");
      Assert.assertSame(model, IterableExtensions.<EObject>head(res.getContents()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPartialParsingRemoveIndent() {
    try {
      final String modelAsString = "({ tworequired a b })";
      EObject _model = this.getModel(modelAsString);
      final Model model = ((Model) _model);
      Resource _eResource = model.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(modelAsString.indexOf("t"), "tworequired a b".length(), " ");
      Assert.assertSame(model, IterableExtensions.<EObject>head(res.getContents()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPartialParsingRemoveNestedIndent() {
    try {
      final String modelAsString = "({{ tworequired a b }})";
      EObject _model = this.getModel(modelAsString);
      final Model model = ((Model) _model);
      Resource _eResource = model.eResource();
      final XtextResource res = ((XtextResource) _eResource);
      res.update(modelAsString.indexOf("t"), "tworequired a b".length(), " ");
      Assert.assertSame(model, IterableExtensions.<EObject>head(res.getContents()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPartialParsingRemoveNestedIndent_01() {
    try {
      final String modelAsString = "({{ tworequired a b }})";
      this.<PartialParsingProcessor>get(PartialParsingProcessor.class).processFile(modelAsString, modelAsString, modelAsString.indexOf("t"), "tworequired a b".length(), " ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
