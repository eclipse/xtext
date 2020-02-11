/**
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import com.google.common.base.Objects;
import com.google.common.collect.Iterators;
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
    AbstractRule _head = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final ParserRule rootRule = ((ParserRule) _head);
    AbstractElement _alternatives = rootRule.getAlternatives();
    final Alternatives alternatives = ((Alternatives) _alternatives);
    AbstractElement _head_1 = IterableExtensions.<AbstractElement>head(alternatives.getElements());
    Condition _guardCondition = ((Group) _head_1).getGuardCondition();
    final ParameterReference firstGuard = ((ParameterReference) _guardCondition);
    Assert.assertEquals(IterableExtensions.<Parameter>head(rootRule.getParameters()), firstGuard.getParameter());
    AbstractElement _last = IterableExtensions.<AbstractElement>last(alternatives.getElements());
    Condition _guardCondition_1 = ((Group) _last).getGuardCondition();
    final Negation secondGuard = ((Negation) _guardCondition_1);
    Condition _value = secondGuard.getValue();
    Assert.assertEquals(IterableExtensions.<Parameter>head(rootRule.getParameters()), ((ParameterReference) _value).getParameter());
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
    AbstractRule _head = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final ParserRule rootRule = ((ParserRule) _head);
    AbstractRule _last = IterableExtensions.<AbstractRule>last(grammar.getRules());
    final ParserRule lastRule = ((ParserRule) _last);
    AbstractElement _alternatives = lastRule.getAlternatives();
    AbstractElement _last_1 = IterableExtensions.<AbstractElement>last(((Group) _alternatives).getElements());
    final Assignment lastAssignment = ((Assignment) _last_1);
    AbstractElement _terminal = lastAssignment.getTerminal();
    final RuleCall ruleCall = ((RuleCall) _terminal);
    final NamedArgument argument = IterableExtensions.<NamedArgument>head(ruleCall.getArguments());
    Assert.assertEquals(IterableExtensions.<Parameter>head(rootRule.getParameters()), argument.getParameter());
    Condition _value = argument.getValue();
    Assert.assertEquals(IterableExtensions.<Parameter>head(lastRule.getParameters()), ((ParameterReference) _value).getParameter());
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
    AbstractRule _head = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final ParserRule rootRule = ((ParserRule) _head);
    AbstractRule _last = IterableExtensions.<AbstractRule>last(grammar.getRules());
    final ParserRule lastRule = ((ParserRule) _last);
    AbstractElement _alternatives = lastRule.getAlternatives();
    AbstractElement _last_1 = IterableExtensions.<AbstractElement>last(((Group) _alternatives).getElements());
    final Assignment lastAssignment = ((Assignment) _last_1);
    AbstractElement _terminal = lastAssignment.getTerminal();
    final RuleCall ruleCall = ((RuleCall) _terminal);
    final NamedArgument argument = IterableExtensions.<NamedArgument>head(ruleCall.getArguments());
    Assert.assertEquals(IterableExtensions.<Parameter>head(rootRule.getParameters()), argument.getParameter());
    Condition _value = argument.getValue();
    Assert.assertEquals(IterableExtensions.<Parameter>head(lastRule.getParameters()), ((ParameterReference) _value).getParameter());
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
    AbstractRule _head = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final ParserRule rootRule = ((ParserRule) _head);
    AbstractRule _last = IterableExtensions.<AbstractRule>last(grammar.getRules());
    final ParserRule lastRule = ((ParserRule) _last);
    AbstractElement _alternatives = lastRule.getAlternatives();
    AbstractElement _last_1 = IterableExtensions.<AbstractElement>last(((Group) _alternatives).getElements());
    final Assignment lastAssignment = ((Assignment) _last_1);
    AbstractElement _terminal = lastAssignment.getTerminal();
    final RuleCall ruleCall = ((RuleCall) _terminal);
    final NamedArgument argument = IterableExtensions.<NamedArgument>head(ruleCall.getArguments());
    Assert.assertEquals(IterableExtensions.<Parameter>head(rootRule.getParameters()), argument.getParameter());
    Condition _value = argument.getValue();
    Assert.assertFalse(((LiteralCondition) _value).isTrue());
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
    final ResourceSet resourceSet = grammar.eResource().getResourceSet();
    final Resource otherResource = resourceSet.createResource(URI.createURI("other.xtext"));
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar test.SubLang with test.Lang");
    _builder_1.newLine();
    _builder_1.append("import \'http://test\'");
    _builder_1.newLine();
    _builder_1.append("Root<MyParam>: rule=super::Rule<true>;");
    _builder_1.newLine();
    LazyStringInputStream _lazyStringInputStream = new LazyStringInputStream(_builder_1.toString());
    otherResource.load(_lazyStringInputStream, null);
    EObject _head = IterableExtensions.<EObject>head(otherResource.getContents());
    final Grammar subGrammar = ((Grammar) _head);
    AbstractRule _head_1 = IterableExtensions.<AbstractRule>head(subGrammar.getRules());
    final ParserRule rootRule = ((ParserRule) _head_1);
    AbstractRule _last = IterableExtensions.<AbstractRule>last(grammar.getRules());
    final ParserRule parentRule = ((ParserRule) _last);
    AbstractElement _alternatives = parentRule.getAlternatives();
    AbstractElement _last_1 = IterableExtensions.<AbstractElement>last(((Group) _alternatives).getElements());
    final Assignment lastAssignment = ((Assignment) _last_1);
    AbstractElement _terminal = lastAssignment.getTerminal();
    final RuleCall ruleCall = ((RuleCall) _terminal);
    final NamedArgument argument = IterableExtensions.<NamedArgument>head(ruleCall.getArguments());
    Assert.assertEquals(IterableExtensions.<Parameter>head(rootRule.getParameters()), argument.getParameter());
    Condition _value = argument.getValue();
    Assert.assertFalse(((LiteralCondition) _value).isTrue());
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
    EObject _get = resource.getContents().get(0);
    Grammar grammar = ((Grammar) _get);
    final AbstractRule firstRule = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final RuleCall firstRuleCall = IteratorExtensions.<RuleCall>head(Iterators.<RuleCall>filter(firstRule.eAllContents(), RuleCall.class));
    Assert.assertTrue(firstRuleCall.isExplicitlyCalled());
    final RuleCall secondRuleCall = IteratorExtensions.<RuleCall>last(Iterators.<RuleCall>filter(firstRule.eAllContents(), RuleCall.class));
    Assert.assertFalse(secondRuleCall.isExplicitlyCalled());
    final RuleCall thirdRuleCall = IteratorExtensions.<RuleCall>head(Iterators.<RuleCall>filter(grammar.getRules().get(1).eAllContents(), RuleCall.class));
    Assert.assertTrue(thirdRuleCall.isExplicitlyCalled());
    resource.update(grammarAsString.indexOf("_super"), 1, " ");
    Assert.assertEquals(resource, firstRuleCall.eResource());
    Assert.assertEquals(resource, secondRuleCall.eResource());
    Assert.assertEquals(resource, thirdRuleCall.eResource());
    resource.getContents();
    Assert.assertFalse(thirdRuleCall.isExplicitlyCalled());
    Assert.assertEquals(IterableExtensions.<AbstractRule>last(grammar.getRules()), thirdRuleCall.getRule());
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
    EObject _get = resource.getContents().get(0);
    Grammar grammar = ((Grammar) _get);
    final AbstractRule firstRule = IterableExtensions.<AbstractRule>head(grammar.getRules());
    final AbstractRule idRule = GrammarUtil.findRuleForName(IterableExtensions.<Grammar>head(grammar.getUsedGrammars()), "ID");
    final Function1<RuleCall, Boolean> _function = (RuleCall it) -> {
      AbstractRule _rule = it.getRule();
      return Boolean.valueOf(Objects.equal(_rule, idRule));
    };
    Assert.assertTrue(
      IterableExtensions.<RuleCall>forall(GrammarUtil.containedRuleCalls(firstRule), _function));
    final AbstractRule secondRule = IterableExtensions.<AbstractRule>head(IterableExtensions.<AbstractRule>tail(grammar.getRules()));
    final AbstractRule stringRule = IterableExtensions.<AbstractRule>last(grammar.getRules());
    final Function1<RuleCall, Boolean> _function_1 = (RuleCall it) -> {
      AbstractRule _rule = it.getRule();
      return Boolean.valueOf(Objects.equal(_rule, stringRule));
    };
    Assert.assertTrue(
      IterableExtensions.<RuleCall>forall(GrammarUtil.containedRuleCalls(secondRule), _function_1));
    final AbstractRule thirdRule = IterableExtensions.<AbstractRule>head(IterableExtensions.<AbstractRule>drop(grammar.getRules(), 2));
    final AbstractRule inheritedString = GrammarUtil.findRuleForName(IterableExtensions.<Grammar>head(grammar.getUsedGrammars()), "STRING");
    final Function1<RuleCall, Boolean> _function_2 = (RuleCall it) -> {
      AbstractRule _rule = it.getRule();
      return Boolean.valueOf(Objects.equal(_rule, inheritedString));
    };
    Assert.assertTrue(
      IterableExtensions.<RuleCall>forall(GrammarUtil.containedRuleCalls(thirdRule), _function_2));
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
    EObject _get = resource.getContents().get(0);
    Grammar grammar = ((Grammar) _get);
    AbstractRule _get_1 = grammar.getRules().get(1);
    final TerminalRule string = ((TerminalRule) _get_1);
    AbstractElement _alternatives = string.getAlternatives();
    final RuleCall callToSuper = ((RuleCall) _alternatives);
    Assert.assertEquals(GrammarUtil.findRuleForName(IterableExtensions.<Grammar>head(grammar.getUsedGrammars()), "STRING"), callToSuper.getRule());
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
    EObject _get = resource.getContents().get(0);
    Grammar grammar = ((Grammar) _get);
    AbstractRule _get_1 = grammar.getRules().get(1);
    final TerminalRule string = ((TerminalRule) _get_1);
    AbstractElement _alternatives = string.getAlternatives();
    final RuleCall callToSuper = ((RuleCall) _alternatives);
    Assert.assertEquals(IterableExtensions.<AbstractRule>last(grammar.getRules()), callToSuper.getRule());
  }
  
  @Test
  public void testGeneratedPackageRemovedProperly() throws Exception {
    final String testGrammar = "grammar foo.Bar generate foo \'bar\'  Model : name=ID;";
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("name"), 4, "foo");
    int _indexOf = testGrammar.indexOf("generate foo");
    int _plus = (_indexOf + 11);
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, _plus, 1, "x");
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x");
  }
  
  @Test
  public void testImportedPackageRemovedProperly() throws Exception {
    final String testGrammar = "grammar foo.Bar import \'classpath:/org/eclipse/xtext/xtext/Foo.ecore\' as foo Model returns foo::Model: name=ID;";
    this.checkPackageRemovalAfterGrammarChange(false, testGrammar, testGrammar.indexOf("name"), 4, "foo");
    int _indexOf = testGrammar.indexOf("as foo");
    int _plus = (_indexOf + 4);
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, _plus, 1, "x");
    this.checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x");
  }
  
  @Test
  public void testRegisteredPackageNotUnloaded() throws Exception {
    final String testGrammar = "grammar foo.Bar import \'http://www.eclipse.org/emf/2002/Ecore\' EClass: \'foo\';";
    this.checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, testGrammar.indexOf("\'foo\'"), 4, "foo");
    int _indexOf = testGrammar.indexOf("import ");
    int _plus = (_indexOf + 11);
    this.checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, _plus, 1, "x");
    this.checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x");
  }
  
  private void checkPackageRemovalAfterGrammarChange(final boolean isRemoved, final String originalGrammar, final int offset, final int length, final String replacement) throws Exception {
    final XtextResource resource = this.getResourceFromStringAndExpect(originalGrammar, 1);
    EObject _get = resource.getContents().get(0);
    Grammar grammar = ((Grammar) _get);
    AbstractMetamodelDeclaration generatedMetamodel = grammar.getMetamodelDeclarations().get(0);
    EPackage ePackage = generatedMetamodel.getEPackage();
    Assert.assertEquals(ePackage.eResource().getResourceSet(), resource.getResourceSet());
    resource.update(offset, length, replacement);
    if (isRemoved) {
      Assert.assertNull(ePackage.eResource().getResourceSet());
    } else {
      Assert.assertEquals(ePackage.eResource().getResourceSet(), resource.getResourceSet());
    }
    EObject _get_1 = resource.getContents().get(0);
    grammar = ((Grammar) _get_1);
    generatedMetamodel = grammar.getMetamodelDeclarations().get(0);
    ePackage = generatedMetamodel.getEPackage();
    Assert.assertEquals(resource.getResourceSet(), ePackage.eResource().getResourceSet());
  }
  
  private void checkRegisteredPackageNotUnloadedAfterGrammarChange(final String originalGrammar, final int offset, final int length, final String replacement) throws Exception {
    final XtextResource resource = this.getResourceFromString(originalGrammar);
    EObject _get = resource.getContents().get(0);
    final Grammar grammar = ((Grammar) _get);
    final AbstractMetamodelDeclaration generatedMetamodel = grammar.getMetamodelDeclarations().get(0);
    final EPackage ePackage = generatedMetamodel.getEPackage();
    Assert.assertNull(((InternalEObject) ePackage).eProxyURI());
    resource.update(offset, length, replacement);
    Assert.assertNull(((InternalEObject) ePackage).eProxyURI());
  }
}
