/**
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext;

import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xtext.AbstractXtextRuleInspectorTest;
import org.eclipse.xtext.xtext.OverriddenValueInspector;
import org.eclipse.xtext.xtext.XtextRuleInspector;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class OverriddenValueInspectorTest extends AbstractXtextRuleInspectorTest<Boolean, ParserRule> {
  @Override
  protected XtextRuleInspector<Boolean, ParserRule> createInspector() {
    return new OverriddenValueInspector(this);
  }
  
  @Test
  public void testFragment_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : name=ID Named;");
    _builder.newLine();
    _builder.append("fragment Named: name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "Named");
    final ParserRule fragment = ((ParserRule) _findRuleForName_1);
    this.validateRule(fragment);
    String _string_1 = this.warnings.toString();
    int _size_1 = this.warnings.size();
    Assert.assertEquals(_string_1, 0, _size_1);
  }
  
  @Test
  public void testFragment_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Named;");
    _builder.newLine();
    _builder.append("fragment Named: name=ID+;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 0, _size);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "Named");
    final ParserRule fragment = ((ParserRule) _findRuleForName_1);
    this.validateRule(fragment);
    String _string_1 = this.warnings.toString();
    int _size_1 = this.warnings.size();
    Assert.assertEquals(_string_1, 1, _size_1);
  }
  
  @Test
  public void testFragment_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Named;");
    _builder.newLine();
    _builder.append("fragment Named: name=ID Named;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    final Function1<Triple<String, EObject, EStructuralFeature>, String> _function = new Function1<Triple<String, EObject, EStructuralFeature>, String>() {
      @Override
      public String apply(final Triple<String, EObject, EStructuralFeature> it) {
        return it.getFirst();
      }
    };
    List<String> _map = ListExtensions.<Triple<String, EObject, EStructuralFeature>, String>map(this.warnings, _function);
    String _string = _map.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 0, _size);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "Named");
    final ParserRule fragment = ((ParserRule) _findRuleForName_1);
    this.validateRule(fragment);
    final Function1<Triple<String, EObject, EStructuralFeature>, String> _function_1 = new Function1<Triple<String, EObject, EStructuralFeature>, String>() {
      @Override
      public String apply(final Triple<String, EObject, EStructuralFeature> it) {
        return it.getFirst();
      }
    };
    List<String> _map_1 = ListExtensions.<Triple<String, EObject, EStructuralFeature>, String>map(this.warnings, _function_1);
    String _string_1 = _map_1.toString();
    int _size_1 = this.warnings.size();
    Assert.assertEquals(_string_1, 2, _size_1);
  }
  
  @Test
  public void testFragment_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Named;");
    _builder.newLine();
    _builder.append("fragment Named: name=ID NamedAgain;");
    _builder.newLine();
    _builder.append("fragment NamedAgain returns Named: Named;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    final Function1<Triple<String, EObject, EStructuralFeature>, String> _function = new Function1<Triple<String, EObject, EStructuralFeature>, String>() {
      @Override
      public String apply(final Triple<String, EObject, EStructuralFeature> it) {
        return it.getFirst();
      }
    };
    List<String> _map = ListExtensions.<Triple<String, EObject, EStructuralFeature>, String>map(this.warnings, _function);
    String _string = _map.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 0, _size);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "Named");
    final ParserRule fragment = ((ParserRule) _findRuleForName_1);
    this.validateRule(fragment);
    final Function1<Triple<String, EObject, EStructuralFeature>, String> _function_1 = new Function1<Triple<String, EObject, EStructuralFeature>, String>() {
      @Override
      public String apply(final Triple<String, EObject, EStructuralFeature> it) {
        return it.getFirst();
      }
    };
    List<String> _map_1 = ListExtensions.<Triple<String, EObject, EStructuralFeature>, String>map(this.warnings, _function_1);
    String _string_1 = _map_1.toString();
    int _size_1 = this.warnings.size();
    Assert.assertEquals(_string_1, 2, _size_1);
    AbstractRule _findRuleForName_2 = GrammarUtil.findRuleForName(grammar, "NamedAgain");
    final ParserRule otherFragment = ((ParserRule) _findRuleForName_2);
    this.validateRule(otherFragment);
    final Function1<Triple<String, EObject, EStructuralFeature>, String> _function_2 = new Function1<Triple<String, EObject, EStructuralFeature>, String>() {
      @Override
      public String apply(final Triple<String, EObject, EStructuralFeature> it) {
        return it.getFirst();
      }
    };
    List<String> _map_2 = ListExtensions.<Triple<String, EObject, EStructuralFeature>, String>map(this.warnings, _function_2);
    String _string_2 = _map_2.toString();
    int _size_2 = this.warnings.size();
    Assert.assertEquals(_string_2, 0, _size_2);
  }
  
  @Test
  public void testFragment_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Named*;");
    _builder.newLine();
    _builder.append("fragment Named: name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 1, _size);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "Named");
    final ParserRule fragment = ((ParserRule) _findRuleForName_1);
    this.validateRule(fragment);
    String _string_1 = this.warnings.toString();
    int _size_1 = this.warnings.size();
    Assert.assertEquals(_string_1, 0, _size_1);
  }
  
  @Test
  public void testFragment_06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Named Named;");
    _builder.newLine();
    _builder.append("fragment Named*: name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "Named");
    final ParserRule fragment = ((ParserRule) _findRuleForName_1);
    this.validateRule(fragment);
    String _string_1 = this.warnings.toString();
    int _size_1 = this.warnings.size();
    Assert.assertEquals(_string_1, 0, _size_1);
  }
  
  @Test
  public void testBug280011_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Q : \'x\' a = ID | \'y\' a = ID ;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Q");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug280011_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Q : \'x\' a = ID \'y\' b = ID ;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Q");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug280011_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Q : \'x\' a = ID \'y\' a = ID ;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Q");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testBug280011_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Q : \'x\' (a = ID)+;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Q");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 1, _size);
  }
  
  @Test
  public void testAssignedAction_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second {First.second=current} second=Second;");
    _builder.newLine();
    _builder.append("Second: name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testAssignedAction_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second ({First.second=current} name=ID)*;");
    _builder.newLine();
    _builder.append("Second: name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testAssignedAction_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second {First.second=current} name=ID;");
    _builder.newLine();
    _builder.append("Second: name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testAssignedAction_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second {First.second+=current} second+=Second;");
    _builder.newLine();
    _builder.append("Second: name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testUnassignedRule_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second name+=ID;");
    _builder.newLine();
    _builder.append("Second: name+=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testUnassignedRule_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second name=ID;");
    _builder.newLine();
    _builder.append("Second: name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testUnassignedRule_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second (name=ID)?;");
    _builder.newLine();
    _builder.append("Second: id=INT (name=ID)?;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testUnassignedRule_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second (name=ID)? id=INT;");
    _builder.newLine();
    _builder.append("Second: id=INT (name=ID)?;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 4, _size);
  }
  
  @Test
  public void testAlternative_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second | name=ID;");
    _builder.newLine();
    _builder.append("Second: \'keyword\' name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testAlternative_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : (Second | multiName+=ID) multiName+=ID id=INT;");
    _builder.newLine();
    _builder.append("Second: \'keyword\' name=ID id=INT;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testAlternative_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : (Second | multiName+=ID | id=INT) multiName+=ID id=INT;");
    _builder.newLine();
    _builder.append("Second: \'keyword\' name=ID id=INT;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 3, _size);
  }
  
  @Test
  public void testAlternative_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : (Second | multiName+=ID | id=INT) multiName+=ID;");
    _builder.newLine();
    _builder.append("Second: \'keyword\' name=ID id=INT;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testOptionalAction_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second ({First.second=current} id=INT)? name=ID;");
    _builder.newLine();
    _builder.append("Second: \'keyword\' name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testOptionalAction_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second ({First.second=current} id=INT)* name=ID;");
    _builder.newLine();
    _builder.append("Second: \'keyword\' name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testOptionalAction_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second ({First.second=current} id=INT)+ name=ID;");
    _builder.newLine();
    _builder.append("Second: \'keyword\' name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testOptionalAction_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First : Second (isSecond=\'keyword\' | {First.second=current} id=INT) name=ID;");
    _builder.newLine();
    _builder.append("Second: \'keyword\' name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testRuleCall_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First returns Object: (Third|Second) cardinality=(\'+\'|\'*\')?;");
    _builder.newLine();
    _builder.append("Second returns Object: \'(\' First \')\';");
    _builder.newLine();
    _builder.append("Third returns Object: name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testNoMarkerForCalledRules_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("First returns Object: Second;");
    _builder.newLine();
    _builder.append("Second returns Object: name=ID name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "First");
    ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 0, _size);
    AbstractRule _findRuleForName_1 = GrammarUtil.findRuleForName(grammar, "Second");
    rule = ((ParserRule) _findRuleForName_1);
    this.validateRule(rule);
    String _string_1 = this.warnings.toString();
    int _size_1 = this.warnings.size();
    Assert.assertEquals(_string_1, 2, _size_1);
  }
  
  @Test
  public void testUnorderedGroup_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : \'x\' a = ID & \'y\' b = ID ;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testUnorderedGroup_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : \'x\' a = ID & \'y\' a = ID ;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testUnorderedGroup_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : (a = ID & b = STRING)+;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testUnorderedGroup_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : (\'x\' a = ID & \'y\' b = ID) a = ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testUnorderedGroup_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : a = ID (a = ID & b = STRING) ;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testUnorderedGroup_06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : a = ID b = STRING & a = ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testBug306281_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = \'-\' | {Binary.left=current} operator = \'+\') right=ID)*;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug306281_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = \'-\' | {Binary.left=current} operator = \'+\') right=ID)* name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testBug306281_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = \'-\' | {Binary.left=current} operator = \'+\') right=ID)+ name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug306281_04() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = \'-\' | {Binary.left=current} operator = \'+\')? name=ID);");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testBug306281_05() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = \'-\' | {Binary.left=current} operator = \'+\') name=ID);");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug306281_06() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) right=ID)*;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug306281_07() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) right=ID)* name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testBug306281_08() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) right=ID)+ name=ID;");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug306281_09() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model])?\tname=ID);");
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    int _size = this.warnings.size();
    Assert.assertEquals(_string, 2, _size);
  }
  
  @Test
  public void testBug306281_10() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) name=ID);");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
  
  @Test
  public void testBug306281_11() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate metamodel \'foo.sample\'");
    _builder.newLine();
    _builder.append("Model returns Model: SubModel ({Binary.params+=current} operator =\'+\' params+=SubModel)*;");
    _builder.newLine();
    _builder.append("SubModel returns Model: \'(\'Model\')\';");
    _builder.newLine();
    String grammarAsString = _builder.toString();
    final Grammar grammar = this.getGrammar(grammarAsString);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(grammar, "Model");
    final ParserRule rule = ((ParserRule) _findRuleForName);
    this.validateRule(rule);
    String _string = this.warnings.toString();
    boolean _isEmpty = this.warnings.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
}
