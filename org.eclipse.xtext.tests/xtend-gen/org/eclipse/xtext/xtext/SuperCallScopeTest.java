/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext;

import java.util.List;
import org.eclipse.emf.common.util.EList;
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
    Iterable<IEObjectDescription> _allElements = scope.getAllElements();
    this.assertElementNames(_allElements, 
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
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _last = IterableExtensions.<AbstractRule>last(_rules);
    final SuperCallScope scope = new SuperCallScope(_last);
    Iterable<IEObjectDescription> _allElements = scope.getAllElements();
    this.assertElementNames(_allElements, 
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
    QualifiedName _create = QualifiedName.create("ID");
    Iterable<IEObjectDescription> _elements = scope.getElements(_create);
    this.assertElements(_elements);
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
    QualifiedName _create = QualifiedName.create("super");
    Iterable<IEObjectDescription> _elements = scope.getElements(_create);
    this.assertElements(_elements);
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
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _head = IterableExtensions.<AbstractRule>head(_rules);
    final SuperCallScope scope = new SuperCallScope(_head);
    QualifiedName _create = QualifiedName.create("super");
    Iterable<IEObjectDescription> _elements = scope.getElements(_create);
    this.assertElements(_elements);
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
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _last = IterableExtensions.<AbstractRule>last(_rules);
    final SuperCallScope scope = new SuperCallScope(_last);
    QualifiedName _create = QualifiedName.create("super");
    Iterable<IEObjectDescription> _elements = scope.getElements(_create);
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
    QualifiedName _create = QualifiedName.create("super", "ID");
    Iterable<IEObjectDescription> _elements = scope.getElements(_create);
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
    QualifiedName _create = QualifiedName.create("Lang", "ID");
    Iterable<IEObjectDescription> _elements = scope.getElements(_create);
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
    QualifiedName _create = QualifiedName.create("test", "Lang", "ID");
    Iterable<IEObjectDescription> _elements = scope.getElements(_create);
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
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _head = IterableExtensions.<AbstractRule>head(_rules);
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
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _last = IterableExtensions.<AbstractRule>last(_rules);
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
    String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(expectedNames)), "\n");
    final Function1<IEObjectDescription, String> _function = (IEObjectDescription it) -> {
      QualifiedName _name = it.getName();
      return _name.toString();
    };
    Iterable<String> _map = IterableExtensions.<IEObjectDescription, String>map(descriptions, _function);
    String _join_1 = IterableExtensions.join(_map, "\n");
    Assert.assertEquals(_join, _join_1);
  }
  
  public void assertElements(final Iterable<IEObjectDescription> descriptions, final Pair<String, AbstractRule>... expected) {
    final Function1<Pair<String, AbstractRule>, String> _function = (Pair<String, AbstractRule> it) -> {
      String _key = it.getKey();
      String _plus = (_key + "->");
      AbstractRule _value = it.getValue();
      Grammar _grammar = GrammarUtil.getGrammar(_value);
      String _name = _grammar.getName();
      String _plus_1 = (_plus + _name);
      String _plus_2 = (_plus_1 + ".");
      AbstractRule _value_1 = it.getValue();
      String _name_1 = _value_1.getName();
      return (_plus_2 + _name_1);
    };
    List<String> _map = ListExtensions.<Pair<String, AbstractRule>, String>map(((List<Pair<String, AbstractRule>>)Conversions.doWrapArray(expected)), _function);
    String _join = IterableExtensions.join(_map, "\n");
    final Function1<IEObjectDescription, String> _function_1 = (IEObjectDescription it) -> {
      QualifiedName _name = it.getName();
      String _string = _name.toString();
      String _plus = (_string + "->");
      EObject _eObjectOrProxy = it.getEObjectOrProxy();
      Grammar _grammar = GrammarUtil.getGrammar(_eObjectOrProxy);
      String _name_1 = _grammar.getName();
      String _plus_1 = (_plus + _name_1);
      String _plus_2 = (_plus_1 + ".");
      EObject _eObjectOrProxy_1 = it.getEObjectOrProxy();
      String _name_2 = ((AbstractRule) _eObjectOrProxy_1).getName();
      return (_plus_2 + _name_2);
    };
    Iterable<String> _map_1 = IterableExtensions.<IEObjectDescription, String>map(descriptions, _function_1);
    String _join_1 = IterableExtensions.join(_map_1, "\n");
    Assert.assertEquals(_join, _join_1);
  }
}
