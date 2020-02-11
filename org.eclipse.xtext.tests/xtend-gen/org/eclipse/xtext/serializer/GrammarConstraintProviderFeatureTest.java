/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
@SuppressWarnings("all")
public class GrammarConstraintProviderFeatureTest {
  @Inject
  private ValidationTestHelper validator;
  
  @Inject
  private ParseHelper<Grammar> parser;
  
  @Inject
  private IGrammarConstraintProvider constraintProvider;
  
  @Test
  public void simple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: val=ID; ");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val[1,1]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void optional() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: {Rule} val=ID?; ");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val[0,1]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void multi() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: val=ID+; ");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val[1,*]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void optionalMulti() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: {Rule} val=ID*; ");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val[0,*]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void twoToThree() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: val+=ID val+=ID val+=ID?; ");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val[2,3]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void twoDoubleLoop() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: {Rule} (val1+=ID val2+=ID)*; ");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val1[0,*]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val2[0,*]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void zeroToThree() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: (val1+=ID | val2+=ID | val3+=ID) (val1+=ID | val2+=ID) val1+=ID; ");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val1[1,3]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val2[0,2]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val3[0,1]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void unordered() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: val1+=ID & val2+=ID; ");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val1[0,*]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val2[0,*]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void complex1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: \'a\' val1+=ID \'b\'");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("(");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("(\'c\' val2+=ID)?");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("& (\'d\' val3+=ID)?");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("& (\'e\' val4+=ID)?");
    _builder.newLine();
    _builder.append("  ");
    _builder.append(")");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("(\'f\' val5+=ID*)?");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("(\'g\' val6+=ID*)?");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("\'h\';");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val1[1,1]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val2[0,*]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val3[0,*]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val4[0,*]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val5[0,*]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val6[0,*]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  @Test
  public void complex2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Rule: {Rule} (val1+=ID | \'a\')");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("(val2+=ID & \'b\')");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("(\'c\' | val1+=ID);");
    _builder.newLine();
    final String actual = this.toFeatureInfo(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Rule_Rule{");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val1[0,2]");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("val2[0,*]");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final String expected = _builder_1.toString();
    this.assertEquals(expected, actual);
  }
  
  public void assertEquals(final String expected, final String actual) {
    String _replaceAll = null;
    if (expected!=null) {
      _replaceAll=expected.replaceAll(System.lineSeparator(), "\n");
    }
    final String expectedM = _replaceAll;
    String _replaceAll_1 = null;
    if (actual!=null) {
      _replaceAll_1=actual.replaceAll(System.lineSeparator(), "\n");
    }
    final String actualM = _replaceAll_1;
    Assert.assertEquals(expectedM, actualM);
  }
  
  public String toFeatureInfo(final CharSequence grammarString) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("grammar org.eclipse.xtext.serializer.GrammarConstraintProviderFeatureTestLanguage with org.eclipse.xtext.common.Terminals");
      _builder.newLine();
      _builder.newLine();
      _builder.append("generate GrammarConstraintProviderFeatureTest \"http://www.eclipse.org/2010/tmf/xtext/GrammarConstraintProviderFeatureTestLanguage\"");
      _builder.newLine();
      _builder.newLine();
      _builder.append(grammarString);
      _builder.newLineIfNotEmpty();
      final Grammar grammar = this.parser.parse(_builder);
      this.validator.assertNoErrors(grammar);
      final Function1<SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint>, IGrammarConstraintProvider.IConstraint> _function = (SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint> it) -> {
        return it.getValue();
      };
      final List<IGrammarConstraintProvider.IConstraint> constraints = ListExtensions.<SerializationContextMap.Entry<IGrammarConstraintProvider.IConstraint>, IGrammarConstraintProvider.IConstraint>map(this.constraintProvider.getConstraints(grammar).values(), _function);
      final Function1<IGrammarConstraintProvider.IConstraint, String> _function_1 = (IGrammarConstraintProvider.IConstraint it) -> {
        String _name = it.getName();
        String _plus = (_name + "{\n  ");
        final Function1<IGrammarConstraintProvider.IFeatureInfo, String> _function_2 = (IGrammarConstraintProvider.IFeatureInfo it_1) -> {
          return this.asString(it_1);
        };
        String _join = IterableExtensions.join(ListExtensions.<IGrammarConstraintProvider.IFeatureInfo, String>map(((List<IGrammarConstraintProvider.IFeatureInfo>)Conversions.doWrapArray(it.getFeatures())), _function_2), "\n  ");
        String _plus_1 = (_plus + _join);
        return (_plus_1 + "\n}");
      };
      String _join = IterableExtensions.join(ListExtensions.<IGrammarConstraintProvider.IConstraint, String>map(constraints, _function_1), "\n");
      return (_join + "\n");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String asString(final IGrammarConstraintProvider.IFeatureInfo it) {
    Object _xifexpression = null;
    int _upperBound = it.getUpperBound();
    boolean _equals = (_upperBound == IGrammarConstraintProvider.MAX);
    if (_equals) {
      _xifexpression = "*";
    } else {
      _xifexpression = Integer.valueOf(it.getUpperBound());
    }
    final Object upper = ((Object)_xifexpression);
    String _name = it.getFeature().getName();
    String _plus = (_name + "[");
    int _lowerBound = it.getLowerBound();
    String _plus_1 = (_plus + Integer.valueOf(_lowerBound));
    String _plus_2 = (_plus_1 + ",");
    String _plus_3 = (_plus_2 + upper);
    return (_plus_3 + "]");
  }
}
