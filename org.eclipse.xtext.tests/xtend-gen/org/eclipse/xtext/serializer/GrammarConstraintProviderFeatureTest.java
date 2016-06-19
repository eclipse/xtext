/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.serializer;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
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
    Assert.assertEquals(expected, actual);
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
    Assert.assertEquals(expected, actual);
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
    Assert.assertEquals(expected, actual);
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
    Assert.assertEquals(expected, actual);
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
    Assert.assertEquals(expected, actual);
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
    Assert.assertEquals(expected, actual);
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
      _builder.append(grammarString, "");
      _builder.newLineIfNotEmpty();
      final Grammar grammar = this.parser.parse(_builder);
      this.validator.assertNoErrors(grammar);
      Map<ISerializationContext, IGrammarConstraintProvider.IConstraint> _constraints = this.constraintProvider.getConstraints(grammar);
      final Collection<IGrammarConstraintProvider.IConstraint> constraints = _constraints.values();
      final Function1<IGrammarConstraintProvider.IConstraint, String> _function = (IGrammarConstraintProvider.IConstraint it) -> {
        String _name = it.getName();
        String _plus = (_name + "{\n  ");
        IGrammarConstraintProvider.IFeatureInfo[] _features = it.getFeatures();
        final Function1<IGrammarConstraintProvider.IFeatureInfo, String> _function_1 = (IGrammarConstraintProvider.IFeatureInfo it_1) -> {
          return this.asString(it_1);
        };
        List<String> _map = ListExtensions.<IGrammarConstraintProvider.IFeatureInfo, String>map(((List<IGrammarConstraintProvider.IFeatureInfo>)Conversions.doWrapArray(_features)), _function_1);
        String _join = IterableExtensions.join(_map, "\n  ");
        String _plus_1 = (_plus + _join);
        return (_plus_1 + "\n}");
      };
      Iterable<String> _map = IterableExtensions.<IGrammarConstraintProvider.IConstraint, String>map(constraints, _function);
      String _join = IterableExtensions.join(_map, "\n");
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
    EStructuralFeature _feature = it.getFeature();
    String _name = _feature.getName();
    String _plus = (_name + "[");
    int _lowerBound = it.getLowerBound();
    String _plus_1 = (_plus + Integer.valueOf(_lowerBound));
    String _plus_2 = (_plus_1 + ",");
    String _plus_3 = (_plus_2 + upper);
    return (_plus_3 + "]");
  }
}
