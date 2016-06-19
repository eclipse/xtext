/**
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Condition;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.LiteralCondition;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.Negation;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParameterReference;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextLinkerTest extends AbstractXtextTests {
  @Override
  public void setUp() throws Exception {
    super.setUp();
    XtextStandaloneSetup _xtextStandaloneSetup = new XtextStandaloneSetup();
    this.with(_xtextStandaloneSetup);
  }
  
  @Test
  public void testGuardLinking() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Root<MyArg>: <MyArg> name=ID | <!MyArg> name=STRING;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _head = IterableExtensions.<AbstractRule>head(_rules);
    final ParserRule rootRule = ((ParserRule) _head);
    AbstractElement _alternatives = rootRule.getAlternatives();
    final Alternatives alternatives = ((Alternatives) _alternatives);
    EList<AbstractElement> _elements = alternatives.getElements();
    AbstractElement _head_1 = IterableExtensions.<AbstractElement>head(_elements);
    Condition _guardCondition = ((Group) _head_1).getGuardCondition();
    final ParameterReference firstGuard = ((ParameterReference) _guardCondition);
    EList<Parameter> _parameters = rootRule.getParameters();
    Parameter _head_2 = IterableExtensions.<Parameter>head(_parameters);
    Parameter _parameter = firstGuard.getParameter();
    Assert.assertEquals(_head_2, _parameter);
    EList<AbstractElement> _elements_1 = alternatives.getElements();
    AbstractElement _last = IterableExtensions.<AbstractElement>last(_elements_1);
    Condition _guardCondition_1 = ((Group) _last).getGuardCondition();
    final Negation secondGuard = ((Negation) _guardCondition_1);
    EList<Parameter> _parameters_1 = rootRule.getParameters();
    Parameter _head_3 = IterableExtensions.<Parameter>head(_parameters_1);
    Condition _value = secondGuard.getValue();
    Parameter _parameter_1 = ((ParameterReference) _value).getParameter();
    Assert.assertEquals(_head_3, _parameter_1);
  }
  
  @Test
  public void testNamedParameterLinking() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Root<MyArg>: rule=Rule<MyArg>;");
    _builder.newLine();
    _builder.append("Rule<MyParam>: name=ID child=Root<MyArg=MyParam>?;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _head = IterableExtensions.<AbstractRule>head(_rules);
    final ParserRule rootRule = ((ParserRule) _head);
    EList<AbstractRule> _rules_1 = grammar.getRules();
    AbstractRule _last = IterableExtensions.<AbstractRule>last(_rules_1);
    final ParserRule lastRule = ((ParserRule) _last);
    AbstractElement _alternatives = lastRule.getAlternatives();
    EList<AbstractElement> _elements = ((Group) _alternatives).getElements();
    AbstractElement _last_1 = IterableExtensions.<AbstractElement>last(_elements);
    final Assignment lastAssignment = ((Assignment) _last_1);
    AbstractElement _terminal = lastAssignment.getTerminal();
    final RuleCall ruleCall = ((RuleCall) _terminal);
    EList<NamedArgument> _arguments = ruleCall.getArguments();
    final NamedArgument argument = IterableExtensions.<NamedArgument>head(_arguments);
    EList<Parameter> _parameters = rootRule.getParameters();
    Parameter _head_1 = IterableExtensions.<Parameter>head(_parameters);
    Parameter _parameter = argument.getParameter();
    Assert.assertEquals(_head_1, _parameter);
    EList<Parameter> _parameters_1 = lastRule.getParameters();
    Parameter _head_2 = IterableExtensions.<Parameter>head(_parameters_1);
    Condition _value = argument.getValue();
    Parameter _parameter_1 = ((ParameterReference) _value).getParameter();
    Assert.assertEquals(_head_2, _parameter_1);
  }
  
  @Test
  public void testImplicitNamedParameterLinking_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Root<MyParam>: rule=Rule<MyParam>;");
    _builder.newLine();
    _builder.append("Rule<MyParam>: name=ID child=Root<MyParam>?;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _head = IterableExtensions.<AbstractRule>head(_rules);
    final ParserRule rootRule = ((ParserRule) _head);
    EList<AbstractRule> _rules_1 = grammar.getRules();
    AbstractRule _last = IterableExtensions.<AbstractRule>last(_rules_1);
    final ParserRule lastRule = ((ParserRule) _last);
    AbstractElement _alternatives = lastRule.getAlternatives();
    EList<AbstractElement> _elements = ((Group) _alternatives).getElements();
    AbstractElement _last_1 = IterableExtensions.<AbstractElement>last(_elements);
    final Assignment lastAssignment = ((Assignment) _last_1);
    AbstractElement _terminal = lastAssignment.getTerminal();
    final RuleCall ruleCall = ((RuleCall) _terminal);
    EList<NamedArgument> _arguments = ruleCall.getArguments();
    final NamedArgument argument = IterableExtensions.<NamedArgument>head(_arguments);
    EList<Parameter> _parameters = rootRule.getParameters();
    Parameter _head_1 = IterableExtensions.<Parameter>head(_parameters);
    Parameter _parameter = argument.getParameter();
    Assert.assertEquals(_head_1, _parameter);
    EList<Parameter> _parameters_1 = lastRule.getParameters();
    Parameter _head_2 = IterableExtensions.<Parameter>head(_parameters_1);
    Condition _value = argument.getValue();
    Parameter _parameter_1 = ((ParameterReference) _value).getParameter();
    Assert.assertEquals(_head_2, _parameter_1);
  }
  
  @Test
  public void testImplicitNamedParameterLinking_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Root<MyParam>: rule=Rule<true>;");
    _builder.newLine();
    _builder.append("Rule<MyParam>: name=ID child=Root<false>?;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _head = IterableExtensions.<AbstractRule>head(_rules);
    final ParserRule rootRule = ((ParserRule) _head);
    EList<AbstractRule> _rules_1 = grammar.getRules();
    AbstractRule _last = IterableExtensions.<AbstractRule>last(_rules_1);
    final ParserRule lastRule = ((ParserRule) _last);
    AbstractElement _alternatives = lastRule.getAlternatives();
    EList<AbstractElement> _elements = ((Group) _alternatives).getElements();
    AbstractElement _last_1 = IterableExtensions.<AbstractElement>last(_elements);
    final Assignment lastAssignment = ((Assignment) _last_1);
    AbstractElement _terminal = lastAssignment.getTerminal();
    final RuleCall ruleCall = ((RuleCall) _terminal);
    EList<NamedArgument> _arguments = ruleCall.getArguments();
    final NamedArgument argument = IterableExtensions.<NamedArgument>head(_arguments);
    EList<Parameter> _parameters = rootRule.getParameters();
    Parameter _head_1 = IterableExtensions.<Parameter>head(_parameters);
    Parameter _parameter = argument.getParameter();
    Assert.assertEquals(_head_1, _parameter);
    Condition _value = argument.getValue();
    boolean _isTrue = ((LiteralCondition) _value).isTrue();
    Assert.assertFalse(_isTrue);
  }
  
  @Test
  public void testNamedParameterAdjustment() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Root<MyParam>: rule=Rule<true>;");
    _builder.newLine();
    _builder.append("Rule<MyParam>: name=ID child=Root<false>?;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    EObject _model = this.getModel(grammarAsString);
    final Grammar grammar = ((Grammar) _model);
    Resource _eResource = grammar.eResource();
    final ResourceSet resourceSet = _eResource.getResourceSet();
    URI _createURI = URI.createURI("other.xtext");
    final Resource otherResource = resourceSet.createResource(_createURI);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar test.SubLang with test.Lang");
    _builder_1.newLine();
    _builder_1.append("import \'http://test\'");
    _builder_1.newLine();
    _builder_1.append("Root<MyParam>: rule=super::Rule<true>;");
    _builder_1.newLine();
    LazyStringInputStream _lazyStringInputStream = new LazyStringInputStream(_builder_1.toString());
    otherResource.load(_lazyStringInputStream, null);
    EList<EObject> _contents = otherResource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    final Grammar subGrammar = ((Grammar) _head);
    EList<AbstractRule> _rules = subGrammar.getRules();
    AbstractRule _head_1 = IterableExtensions.<AbstractRule>head(_rules);
    final ParserRule rootRule = ((ParserRule) _head_1);
    EList<AbstractRule> _rules_1 = grammar.getRules();
    AbstractRule _last = IterableExtensions.<AbstractRule>last(_rules_1);
    final ParserRule parentRule = ((ParserRule) _last);
    AbstractElement _alternatives = parentRule.getAlternatives();
    EList<AbstractElement> _elements = ((Group) _alternatives).getElements();
    AbstractElement _last_1 = IterableExtensions.<AbstractElement>last(_elements);
    final Assignment lastAssignment = ((Assignment) _last_1);
    AbstractElement _terminal = lastAssignment.getTerminal();
    final RuleCall ruleCall = ((RuleCall) _terminal);
    EList<NamedArgument> _arguments = ruleCall.getArguments();
    final NamedArgument argument = IterableExtensions.<NamedArgument>head(_arguments);
    EList<Parameter> _parameters = rootRule.getParameters();
    Parameter _head_2 = IterableExtensions.<Parameter>head(_parameters);
    Parameter _parameter = argument.getParameter();
    Assert.assertEquals(_head_2, _parameter);
    Condition _value = argument.getValue();
    boolean _isTrue = ((LiteralCondition) _value).isTrue();
    Assert.assertFalse(_isTrue);
  }
  
  @Test
  public void testExplicitRuleCallsAreTracked() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=super::ID name=ID;");
    _builder.newLine();
    _builder.append("terminal ID: super;");
    _builder.newLine();
    _builder.append("terminal _super: \'s\';");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammarAsString);
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    Grammar grammar = ((Grammar) _get);
    EList<AbstractRule> _rules = grammar.getRules();
    final AbstractRule firstRule = IterableExtensions.<AbstractRule>head(_rules);
    TreeIterator<EObject> _eAllContents = firstRule.eAllContents();
    Iterator<RuleCall> _filter = Iterators.<RuleCall>filter(_eAllContents, RuleCall.class);
    final RuleCall firstRuleCall = IteratorExtensions.<RuleCall>head(_filter);
    boolean _isExplicitlyCalled = firstRuleCall.isExplicitlyCalled();
    Assert.assertTrue(_isExplicitlyCalled);
    TreeIterator<EObject> _eAllContents_1 = firstRule.eAllContents();
    Iterator<RuleCall> _filter_1 = Iterators.<RuleCall>filter(_eAllContents_1, RuleCall.class);
    final RuleCall secondRuleCall = IteratorExtensions.<RuleCall>last(_filter_1);
    boolean _isExplicitlyCalled_1 = secondRuleCall.isExplicitlyCalled();
    Assert.assertFalse(_isExplicitlyCalled_1);
    EList<AbstractRule> _rules_1 = grammar.getRules();
    AbstractRule _get_1 = _rules_1.get(1);
    TreeIterator<EObject> _eAllContents_2 = _get_1.eAllContents();
    Iterator<RuleCall> _filter_2 = Iterators.<RuleCall>filter(_eAllContents_2, RuleCall.class);
    final RuleCall thirdRuleCall = IteratorExtensions.<RuleCall>head(_filter_2);
    boolean _isExplicitlyCalled_2 = thirdRuleCall.isExplicitlyCalled();
    Assert.assertTrue(_isExplicitlyCalled_2);
    int _indexOf = grammarAsString.indexOf("_super");
    resource.update(_indexOf, 1, " ");
    Resource _eResource = firstRuleCall.eResource();
    Assert.assertEquals(resource, _eResource);
    Resource _eResource_1 = secondRuleCall.eResource();
    Assert.assertEquals(resource, _eResource_1);
    Resource _eResource_2 = thirdRuleCall.eResource();
    Assert.assertEquals(resource, _eResource_2);
    resource.getContents();
    boolean _isExplicitlyCalled_3 = thirdRuleCall.isExplicitlyCalled();
    Assert.assertFalse(_isExplicitlyCalled_3);
    EList<AbstractRule> _rules_2 = grammar.getRules();
    AbstractRule _last = IterableExtensions.<AbstractRule>last(_rules_2);
    AbstractRule _rule = thirdRuleCall.getRule();
    Assert.assertEquals(_last, _rule);
  }
  
  @Test
  public void testQualifiedRuleCall_01() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test.Lang with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("RuleA returns Type:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("name+=ID name+=super::ID name+=Terminals::ID name+=org::eclipse::xtext::common::Terminals::ID;");
    _builder.newLine();
    _builder.append("RuleB returns Type:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("name+=STRING name+=Lang::STRING name+=test::Lang::STRING;");
    _builder.newLine();
    _builder.append("RuleC returns Type:");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("name+=super::STRING name+=Terminals::STRING name+=org::eclipse::xtext::common::Terminals::STRING;");
    _builder.newLine();
    _builder.append("terminal STRING: super::STRING;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammarAsString);
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    Grammar grammar = ((Grammar) _get);
    EList<AbstractRule> _rules = grammar.getRules();
    final AbstractRule firstRule = IterableExtensions.<AbstractRule>head(_rules);
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
    final AbstractRule idRule = GrammarUtil.findRuleForName(_head, "ID");
    List<RuleCall> _containedRuleCalls = GrammarUtil.containedRuleCalls(firstRule);
    final Function1<RuleCall, Boolean> _function = (RuleCall it) -> {
      AbstractRule _rule = it.getRule();
      return Boolean.valueOf(Objects.equal(_rule, idRule));
    };
    boolean _forall = IterableExtensions.<RuleCall>forall(_containedRuleCalls, _function);
    Assert.assertTrue(_forall);
    EList<AbstractRule> _rules_1 = grammar.getRules();
    Iterable<AbstractRule> _tail = IterableExtensions.<AbstractRule>tail(_rules_1);
    final AbstractRule secondRule = IterableExtensions.<AbstractRule>head(_tail);
    EList<AbstractRule> _rules_2 = grammar.getRules();
    final AbstractRule stringRule = IterableExtensions.<AbstractRule>last(_rules_2);
    List<RuleCall> _containedRuleCalls_1 = GrammarUtil.containedRuleCalls(secondRule);
    final Function1<RuleCall, Boolean> _function_1 = (RuleCall it) -> {
      AbstractRule _rule = it.getRule();
      return Boolean.valueOf(Objects.equal(_rule, stringRule));
    };
    boolean _forall_1 = IterableExtensions.<RuleCall>forall(_containedRuleCalls_1, _function_1);
    Assert.assertTrue(_forall_1);
    EList<AbstractRule> _rules_3 = grammar.getRules();
    Iterable<AbstractRule> _drop = IterableExtensions.<AbstractRule>drop(_rules_3, 2);
    final AbstractRule thirdRule = IterableExtensions.<AbstractRule>head(_drop);
    EList<Grammar> _usedGrammars_1 = grammar.getUsedGrammars();
    Grammar _head_1 = IterableExtensions.<Grammar>head(_usedGrammars_1);
    final AbstractRule inheritedString = GrammarUtil.findRuleForName(_head_1, "STRING");
    List<RuleCall> _containedRuleCalls_2 = GrammarUtil.containedRuleCalls(thirdRule);
    final Function1<RuleCall, Boolean> _function_2 = (RuleCall it) -> {
      AbstractRule _rule = it.getRule();
      return Boolean.valueOf(Objects.equal(_rule, inheritedString));
    };
    boolean _forall_2 = IterableExtensions.<RuleCall>forall(_containedRuleCalls_2, _function_2);
    Assert.assertTrue(_forall_2);
  }
  
  @Test
  public void testQualifiedRuleCall_02() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal STRING: super;");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammarAsString);
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    Grammar grammar = ((Grammar) _get);
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _get_1 = _rules.get(1);
    final TerminalRule string = ((TerminalRule) _get_1);
    AbstractElement _alternatives = string.getAlternatives();
    final RuleCall callToSuper = ((RuleCall) _alternatives);
    EList<Grammar> _usedGrammars = grammar.getUsedGrammars();
    Grammar _head = IterableExtensions.<Grammar>head(_usedGrammars);
    AbstractRule _findRuleForName = GrammarUtil.findRuleForName(_head, "STRING");
    AbstractRule _rule = callToSuper.getRule();
    Assert.assertEquals(_findRuleForName, _rule);
  }
  
  @Test
  public void testQualifiedRuleCall_03() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar test with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate test \'http://test\'");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("terminal STRING: super;");
    _builder.newLine();
    _builder.append("terminal super: \'super\';");
    _builder.newLine();
    final String grammarAsString = _builder.toString();
    final XtextResource resource = this.getResourceFromString(grammarAsString);
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    Grammar grammar = ((Grammar) _get);
    EList<AbstractRule> _rules = grammar.getRules();
    AbstractRule _get_1 = _rules.get(1);
    final TerminalRule string = ((TerminalRule) _get_1);
    AbstractElement _alternatives = string.getAlternatives();
    final RuleCall callToSuper = ((RuleCall) _alternatives);
    EList<AbstractRule> _rules_1 = grammar.getRules();
    AbstractRule _last = IterableExtensions.<AbstractRule>last(_rules_1);
    AbstractRule _rule = callToSuper.getRule();
    Assert.assertEquals(_last, _rule);
  }
  
  @Test
  public void testGeneratedPackageRemovedProperly() throws Exception {
    final String testGrammar = "grammar foo.Bar generate foo \'bar\'  Model : name=ID;";
    int _indexOf = testGrammar.indexOf("name");
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, _indexOf, 4, "foo");
    int _indexOf_1 = testGrammar.indexOf("generate foo");
    int _plus = (_indexOf_1 + 11);
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, _plus, 1, "x");
    int _indexOf_2 = testGrammar.indexOf("foo.Bar");
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, _indexOf_2, 1, "x");
  }
  
  @Test
  public void testImportedPackageRemovedProperly() throws Exception {
    final String testGrammar = "grammar foo.Bar import \'classpath:/org/eclipse/xtext/xtext/Foo.ecore\' as foo Model returns foo::Model: name=ID;";
    int _indexOf = testGrammar.indexOf("name");
    this.checkPackageRemovalAfterGrammarChange(false, testGrammar, _indexOf, 4, "foo");
    int _indexOf_1 = testGrammar.indexOf("as foo");
    int _plus = (_indexOf_1 + 4);
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, _plus, 1, "x");
    int _indexOf_2 = testGrammar.indexOf("foo.Bar");
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, _indexOf_2, 1, "x");
  }
  
  @Test
  public void testRegisteredPackageNotUnloaded() throws Exception {
    final String testGrammar = "grammar foo.Bar import \'http://www.eclipse.org/emf/2002/Ecore\' EClass: \'foo\';";
    int _indexOf = testGrammar.indexOf("\'foo\'");
    this.checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, _indexOf, 4, "foo");
    int _indexOf_1 = testGrammar.indexOf("import ");
    int _plus = (_indexOf_1 + 11);
    this.checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, _plus, 1, "x");
    int _indexOf_2 = testGrammar.indexOf("foo.Bar");
    this.checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, _indexOf_2, 1, "x");
  }
  
  private void checkPackageRemovalAfterGrammarChange(final boolean isRemoved, final String originalGrammar, final int offset, final int length, final String replacement) throws Exception {
    final XtextResource resource = this.getResourceFromStringAndExpect(originalGrammar, 1);
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    Grammar grammar = ((Grammar) _get);
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = grammar.getMetamodelDeclarations();
    AbstractMetamodelDeclaration generatedMetamodel = _metamodelDeclarations.get(0);
    EPackage ePackage = generatedMetamodel.getEPackage();
    Resource _eResource = ePackage.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    ResourceSet _resourceSet_1 = resource.getResourceSet();
    Assert.assertEquals(_resourceSet, _resourceSet_1);
    resource.update(offset, length, replacement);
    if (isRemoved) {
      Resource _eResource_1 = ePackage.eResource();
      ResourceSet _resourceSet_2 = _eResource_1.getResourceSet();
      Assert.assertNull(_resourceSet_2);
    } else {
      Resource _eResource_2 = ePackage.eResource();
      ResourceSet _resourceSet_3 = _eResource_2.getResourceSet();
      ResourceSet _resourceSet_4 = resource.getResourceSet();
      Assert.assertEquals(_resourceSet_3, _resourceSet_4);
    }
    EList<EObject> _contents_1 = resource.getContents();
    EObject _get_1 = _contents_1.get(0);
    grammar = ((Grammar) _get_1);
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations_1 = grammar.getMetamodelDeclarations();
    AbstractMetamodelDeclaration _get_2 = _metamodelDeclarations_1.get(0);
    generatedMetamodel = _get_2;
    EPackage _ePackage = generatedMetamodel.getEPackage();
    ePackage = _ePackage;
    ResourceSet _resourceSet_5 = resource.getResourceSet();
    Resource _eResource_3 = ePackage.eResource();
    ResourceSet _resourceSet_6 = _eResource_3.getResourceSet();
    Assert.assertEquals(_resourceSet_5, _resourceSet_6);
  }
  
  private void checkRegisteredPackageNotUnloadedAfterGrammarChange(final String originalGrammar, final int offset, final int length, final String replacement) throws Exception {
    final XtextResource resource = this.getResourceFromString(originalGrammar);
    EList<EObject> _contents = resource.getContents();
    EObject _get = _contents.get(0);
    final Grammar grammar = ((Grammar) _get);
    EList<AbstractMetamodelDeclaration> _metamodelDeclarations = grammar.getMetamodelDeclarations();
    final AbstractMetamodelDeclaration generatedMetamodel = _metamodelDeclarations.get(0);
    final EPackage ePackage = generatedMetamodel.getEPackage();
    URI _eProxyURI = ((InternalEObject) ePackage).eProxyURI();
    Assert.assertNull(_eProxyURI);
    resource.update(offset, length, replacement);
    URI _eProxyURI_1 = ((InternalEObject) ePackage).eProxyURI();
    Assert.assertNull(_eProxyURI_1);
  }
}
