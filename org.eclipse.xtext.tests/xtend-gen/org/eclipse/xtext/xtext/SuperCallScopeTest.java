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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xtext.SuperCallScope;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SuperCallScopeTest extends AbstractXtextTests {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    XtextStandaloneSetup _xtextStandaloneSetup = new XtextStandaloneSetup();
    this.with(_xtextStandaloneSetup);
  }
  
  @Test
  public void testGetAllElements_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    final SuperCallScope scope = new SuperCallScope(grammar);
    this.assertElementNames(scope.getAllElements(), 
      "Lang.Rule", "test.Lang.Rule", 
      "Lang.ID", "test.Lang.ID", 
      "super.ID", "Terminals.ID", "org.eclipse.xtext.common.Terminals.ID", 
      "super.INT", "Terminals.INT", "org.eclipse.xtext.common.Terminals.INT", 
      "super.STRING", "Terminals.STRING", "org.eclipse.xtext.common.Terminals.STRING", 
      "super.ML_COMMENT", "Terminals.ML_COMMENT", "org.eclipse.xtext.common.Terminals.ML_COMMENT", 
      "super.SL_COMMENT", "Terminals.SL_COMMENT", "org.eclipse.xtext.common.Terminals.SL_COMMENT", 
      "super.WS", "Terminals.WS", "org.eclipse.xtext.common.Terminals.WS", 
      "super.ANY_OTHER", "Terminals.ANY_OTHER", "org.eclipse.xtext.common.Terminals.ANY_OTHER");
  }
  
  @Test
  public void testGetAllElements_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    AbstractRule _last = IterableExtensions.<AbstractRule>last(grammar.getRules());
    final SuperCallScope scope = new SuperCallScope(_last);
    this.assertElementNames(scope.getAllElements(), 
      "Lang.Rule", "test.Lang.Rule", 
      "Lang.ID", "test.Lang.ID", 
      "super", 
      "super.ID", "Terminals.ID", "org.eclipse.xtext.common.Terminals.ID", 
      "super.INT", "Terminals.INT", "org.eclipse.xtext.common.Terminals.INT", 
      "super.STRING", "Terminals.STRING", "org.eclipse.xtext.common.Terminals.STRING", 
      "super.ML_COMMENT", "Terminals.ML_COMMENT", "org.eclipse.xtext.common.Terminals.ML_COMMENT", 
      "super.SL_COMMENT", "Terminals.SL_COMMENT", "org.eclipse.xtext.common.Terminals.SL_COMMENT", 
      "super.WS", "Terminals.WS", "org.eclipse.xtext.common.Terminals.WS", 
      "super.ANY_OTHER", "Terminals.ANY_OTHER", "org.eclipse.xtext.common.Terminals.ANY_OTHER");
  }
  
  @Test
  public void testGetElementsByName_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    final SuperCallScope scope = new SuperCallScope(grammar);
    this.assertElements(scope.getElements(QualifiedName.create("ID")));
  }
  
  @Test
  public void testGetElementsByName_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    final SuperCallScope scope = new SuperCallScope(grammar);
    this.assertElements(scope.getElements(QualifiedName.create("super")));
  }
  
  @Test
  public void testGetElementsByName_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    AbstractRule _head = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final SuperCallScope scope = new SuperCallScope(_head);
    this.assertElements(scope.getElements(QualifiedName.create("super")));
  }
  
  @Test
  public void testGetElementsByName_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    AbstractRule _last = IterableExtensions.<AbstractRule>last(grammar.getRules());
    final SuperCallScope scope = new SuperCallScope(_last);
    Iterable<IEObjectDescription> _elements = scope.getElements(QualifiedName.create("super"));
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Pair<String, AbstractRule> _mappedTo = Pair.<String, AbstractRule>of("super", _findRuleForName);
    this.assertElements(_elements, _mappedTo);
  }
  
  @Test
  public void testGetElementsByName_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    final SuperCallScope scope = new SuperCallScope(grammar);
    Iterable<IEObjectDescription> _elements = scope.getElements(QualifiedName.create("super", "ID"));
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Pair<String, AbstractRule> _mappedTo = Pair.<String, AbstractRule>of("super.ID", _findRuleForName);
    this.assertElements(_elements, _mappedTo);
  }
  
  @Test
  public void testGetElementsByName_06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    final SuperCallScope scope = new SuperCallScope(grammar);
    Iterable<IEObjectDescription> _elements = scope.getElements(QualifiedName.create("Lang", "ID"));
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "test.Lang.ID");
    Pair<String, AbstractRule> _mappedTo = Pair.<String, AbstractRule>of("Lang.ID", _findRuleForName);
    this.assertElements(_elements, _mappedTo);
  }
  
  @Test
  public void testGetElementsByName_07() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    final SuperCallScope scope = new SuperCallScope(grammar);
    Iterable<IEObjectDescription> _elements = scope.getElements(QualifiedName.create("test", "Lang", "ID"));
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "test.Lang.ID");
    Pair<String, AbstractRule> _mappedTo = Pair.<String, AbstractRule>of("test.Lang.ID", _findRuleForName);
    this.assertElements(_elements, _mappedTo);
  }
  
  @Test
  public void testGetElementsByEObject_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    final SuperCallScope scope = new SuperCallScope(grammar);
    final AbstractRule id = GrammarUtil.findRuleForName(grammar, "test.Lang.ID");
    Iterable<IEObjectDescription> _elements = scope.getElements(id);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "test.Lang.ID");
    Pair<String, AbstractRule> _mappedTo = Pair.<String, AbstractRule>of("Lang.ID", _findRuleForName);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "test.Lang.ID");
    Pair<String, AbstractRule> _mappedTo_1 = Pair.<String, AbstractRule>of("test.Lang.ID", _findRuleForName_1);
    this.assertElements(_elements, _mappedTo, _mappedTo_1);
  }
  
  @Test
  public void testGetElementsByEObject_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    AbstractRule _head = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final SuperCallScope scope = new SuperCallScope(_head);
    final AbstractRule id = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Iterable<IEObjectDescription> _elements = scope.getElements(id);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Pair<String, AbstractRule> _mappedTo = Pair.<String, AbstractRule>of("super.ID", _findRuleForName);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Pair<String, AbstractRule> _mappedTo_1 = Pair.<String, AbstractRule>of("Lang.ID", _findRuleForName_1);
    AbstractRule _findRuleForName_2 = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Pair<String, AbstractRule> _mappedTo_2 = Pair.<String, AbstractRule>of("test.Lang.ID", _findRuleForName_2);
    this.assertElements(_elements, _mappedTo, _mappedTo_1, _mappedTo_2);
  }
  
  @Test
  public void testGetElementsByEObject_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    AbstractRule _last = IterableExtensions.<AbstractRule>last(grammar.getRules());
    final SuperCallScope scope = new SuperCallScope(_last);
    final AbstractRule id = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Iterable<IEObjectDescription> _elements = scope.getElements(id);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Pair<String, AbstractRule> _mappedTo = Pair.<String, AbstractRule>of("super", _findRuleForName);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Pair<String, AbstractRule> _mappedTo_1 = Pair.<String, AbstractRule>of("super.ID", _findRuleForName_1);
    AbstractRule _findRuleForName_2 = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Pair<String, AbstractRule> _mappedTo_2 = Pair.<String, AbstractRule>of("Lang.ID", _findRuleForName_2);
    AbstractRule _findRuleForName_3 = GrammarUtil.findRuleForName(grammar, "org.eclipse.xtext.common.Terminals.ID");
    Pair<String, AbstractRule> _mappedTo_3 = Pair.<String, AbstractRule>of("test.Lang.ID", _findRuleForName_3);
    this.assertElements(_elements, _mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3);
  }
  
  public void assertElementNames(final Iterable<IEObjectDescription> descriptions, final String... expectedNames) {
    final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
      return it.getName().toString();
    };
    Assert.assertEquals(IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(expectedNames)), "\n"), IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(descriptions, _function), "\n"));
  }
  
  public void assertElements(final Iterable<IEObjectDescription> descriptions, final Pair<String, AbstractRule>... expected) {
    final Function1<Pair<String, AbstractRule>, String> _function = (Pair<String, AbstractRule> it) -> {
      String _key = it.getKey();
      String _plus = (_key + "->");
      String _name = GrammarUtil.getGrammar(it.getValue()).getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + ".");
      String _name_1 = it.getValue().getName();
      return (_plus_2 + _name_1);
    };
    final Function1<IEObjectDescription, String> _function_1 = (IEObjectDescription it) -> {
      String _string = it.getName().toString();
      String _plus = (_string + "->");
      String _name = GrammarUtil.getGrammar(it.getEObjectOrProxy()).getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + ".");
      EObject _eObjectOrProxy = it.getEObjectOrProxy();
      String _name_1 = ((AbstractRule) _eObjectOrProxy).getName();
      return (_plus_2 + _name_1);
    };
    Assert.assertEquals(
      IterableExtensions.join(ListExtensions.<Pair<String, AbstractRule>, String>map(((List<Pair<String, AbstractRule>>)Conversions.doWrapArray(expected)), _function), "\n"), 
      IterableExtensions.join(IterableExtensions.<IEObjectDescription, String>map(descriptions, _function_1), "\n"));
  }
}
