/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.parser;

import org.eclipse.emf.common.util.EList;
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
      org.eclipse.xtext.parsetree.reconstr.serializationerror.Test _test = model.getTest();
      Assert.assertNull(_test);
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
      org.eclipse.xtext.parsetree.reconstr.serializationerror.Test _test = model.getTest();
      Assert.assertNull(_test);
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
      org.eclipse.xtext.parsetree.reconstr.serializationerror.Test _test = model.getTest();
      Assert.assertNotNull(_test);
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
      org.eclipse.xtext.parsetree.reconstr.serializationerror.Test _test = model.getTest();
      Assert.assertNotNull(_test);
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
      int _indexOf = modelAsString.indexOf("a");
      res.update(_indexOf, 1, "b");
      EList<EObject> _contents = res.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      Assert.assertSame(model, _head);
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
      int _indexOf = modelAsString.indexOf("t");
      int _length = "tworequired a b".length();
      res.update(_indexOf, _length, " ");
      EList<EObject> _contents = res.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      Assert.assertSame(model, _head);
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
      int _indexOf = modelAsString.indexOf("t");
      int _length = "tworequired a b".length();
      res.update(_indexOf, _length, " ");
      EList<EObject> _contents = res.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      Assert.assertSame(model, _head);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testPartialParsingRemoveNestedIndent_01() {
    try {
      final String modelAsString = "({{ tworequired a b }})";
      PartialParsingProcessor _get = this.<PartialParsingProcessor>get(PartialParsingProcessor.class);
      int _indexOf = modelAsString.indexOf("t");
      int _length = "tworequired a b".length();
      _get.processFile(modelAsString, modelAsString, _indexOf, _length, " ");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
