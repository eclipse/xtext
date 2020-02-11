/**
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.serializer.sequencertest.AltList1;
import org.eclipse.xtext.serializer.sequencertest.Model;
import org.eclipse.xtext.serializer.sequencertest.MultiKeywordsOrID;
import org.eclipse.xtext.serializer.sequencertest.SimpleGroup;
import org.eclipse.xtext.serializer.sequencertest.SimpleMultiplicities;
import org.eclipse.xtext.serializer.tests.SequencerTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(SequencerTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class SerializerValidationDiagnosticsTest {
  @Inject
  @Extension
  private ParseHelper<Model> _parseHelper;
  
  @Inject
  @Extension
  private ISerializer _iSerializer;
  
  @Test
  public void testSingleValueMandatoryGenerated() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#1 foo bar");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      SimpleGroup _x1 = model.getX1();
      _x1.setVal1(null);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("A value for feature \'val1\' is missing but required.");
      _builder_1.newLine();
      _builder_1.append("Semantic Object: Model.x1->SimpleGroup");
      _builder_1.newLine();
      _builder_1.append("URI: __synthetic0.sequencertestlanguage");
      _builder_1.newLine();
      this.assertSerializationError(model, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSingleValueMandatoryBacktracking() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#3 foo kw1 kw2 bar kw3");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      SimpleMultiplicities _x3 = model.getX3();
      _x3.setVal1(null);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Could not serialize SimpleMultiplicities:");
      _builder_1.newLine();
      _builder_1.append("SimpleMultiplicities.val1 is required to have a value, but it does not.");
      _builder_1.newLine();
      _builder_1.append("Semantic Object: Model.x3->SimpleMultiplicities");
      _builder_1.newLine();
      _builder_1.append("URI: __synthetic0.sequencertestlanguage");
      _builder_1.newLine();
      _builder_1.append("Context: SimpleMultiplicities returns SimpleMultiplicities");
      _builder_1.newLine();
      this.assertSerializationError(model, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMultiValueUpperBoundBacktracking() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#17 foo");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      EObject _x11 = model.getX11();
      final MultiKeywordsOrID mt = ((MultiKeywordsOrID) _x11);
      EList<String> _val = mt.getVal();
      _val.add("bar");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Could not serialize MultiKeywordsOrID:");
      _builder_1.newLine();
      _builder_1.append("MultiKeywordsOrID.val violates the upper bound: It holds 2 values, but only 1 are allowed.");
      _builder_1.newLine();
      _builder_1.append("Semantic Object: Model.x11->MultiKeywordsOrID");
      _builder_1.newLine();
      _builder_1.append("URI: __synthetic0.sequencertestlanguage");
      _builder_1.newLine();
      _builder_1.append("Context: MultiKeywordsOrID returns MultiKeywordsOrID");
      _builder_1.newLine();
      this.assertSerializationError(model, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMultiValueLowerBoundBacktracking() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#17 foo");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      EObject _x11 = model.getX11();
      final MultiKeywordsOrID mt = ((MultiKeywordsOrID) _x11);
      mt.getVal().clear();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Could not serialize MultiKeywordsOrID:");
      _builder_1.newLine();
      _builder_1.append("MultiKeywordsOrID.val violates the lower bound: It holds 0 values, but at least 1 are required.");
      _builder_1.newLine();
      _builder_1.append("Semantic Object: Model.x11->MultiKeywordsOrID");
      _builder_1.newLine();
      _builder_1.append("URI: __synthetic0.sequencertestlanguage");
      _builder_1.newLine();
      _builder_1.append("Context: MultiKeywordsOrID returns MultiKeywordsOrID");
      _builder_1.newLine();
      this.assertSerializationError(model, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBacktracking() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("#8 foo bar");
      _builder.newLine();
      final Model model = this._parseHelper.parse(_builder);
      AltList1 _x8 = model.getX8();
      _x8.setVal3("baz");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Could not serialize AltList1 via backtracking.");
      _builder_1.newLine();
      _builder_1.append("Constraint: AltList1_AltList1 returns AltList1: ((val1=ID val2=ID) | (val1=ID val3=ID) | (val1=ID val4=ID?));");
      _builder_1.newLine();
      _builder_1.append("Values: val1(1), val2(1), val3(1)");
      _builder_1.newLine();
      _builder_1.append("Semantic Object: Model.x8->AltList1");
      _builder_1.newLine();
      _builder_1.append("URI: __synthetic0.sequencertestlanguage");
      _builder_1.newLine();
      _builder_1.append("Context: AltList1 returns AltList1");
      _builder_1.newLine();
      this.assertSerializationError(model, _builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertSerializationError(final EObject obj, final String expected) {
    try {
      this._iSerializer.serialize(obj);
      Assert.fail("Serialization should not succeed.");
    } catch (final Throwable _t) {
      if (_t instanceof Throwable) {
        final Throwable t = (Throwable)_t;
        final String expectedM = expected.toString().trim().replaceAll(System.lineSeparator(), "\n");
        final String messageM = t.getMessage().replaceAll(System.lineSeparator(), "\n");
        Assert.assertEquals(expectedM, messageM);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
