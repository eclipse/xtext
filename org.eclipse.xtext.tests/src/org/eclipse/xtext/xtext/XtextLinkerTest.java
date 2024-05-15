/**
 * Copyright (c) 2008, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.LiteralCondition;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.Negation;
import org.eclipse.xtext.ParameterReference;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.util.LazyStringInputStream;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtextLinkerTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(new XtextStandaloneSetup());
	}

	@Test
	public void testGuardLinking() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Root<MyArg>: <MyArg> name=ID | <!MyArg> name=STRING;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		ParserRule rootRule = (ParserRule) Iterables.getFirst(grammar.getRules(), null);
		Alternatives alternatives = (Alternatives) rootRule.getAlternatives();
		ParameterReference firstGuard = (ParameterReference) ((Group) Iterables.getFirst(alternatives.getElements(),
				null)).getGuardCondition();
		Assert.assertEquals(Iterables.getFirst(rootRule.getParameters(), null), firstGuard.getParameter());
		Negation secondGuard = (Negation) ((Group) Iterables.getLast(alternatives.getElements())).getGuardCondition();
		Assert.assertEquals(Iterables.getFirst(rootRule.getParameters(), null),
				((ParameterReference) secondGuard.getValue()).getParameter());
	}

	@Test
	public void testNamedParameterLinking() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Root<MyArg>: rule=Rule<MyArg>;\n" +
				"Rule<MyParam>: name=ID child=Root<MyArg=MyParam>?;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		ParserRule rootRule = (ParserRule) Iterables.getFirst(grammar.getRules(), null);
		ParserRule getLastRule = (ParserRule) Iterables.getLast(grammar.getRules());
		Assignment getLastAssignment = (Assignment) Iterables
				.getLast(((Group) getLastRule.getAlternatives()).getElements());
		RuleCall ruleCall = (RuleCall) getLastAssignment.getTerminal();
		NamedArgument argument = Iterables.getFirst(ruleCall.getArguments(), null);
		Assert.assertEquals(Iterables.getFirst(rootRule.getParameters(), null), argument.getParameter());
		Assert.assertEquals(Iterables.getFirst(getLastRule.getParameters(), null),
				((ParameterReference) argument.getValue()).getParameter());
	}

	@Test
	public void testImplicitNamedParameterLinking_01() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Root<MyParam>: rule=Rule<MyParam>;\n" +
				"Rule<MyParam>: name=ID child=Root<MyParam>?;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		ParserRule rootRule = (ParserRule) Iterables.getFirst(grammar.getRules(), null);
		ParserRule getLastRule = (ParserRule) Iterables.getLast(grammar.getRules());
		Assignment getLastAssignment = (Assignment) Iterables
				.getLast(((Group) getLastRule.getAlternatives()).getElements());
		RuleCall ruleCall = (RuleCall) getLastAssignment.getTerminal();
		NamedArgument argument = Iterables.getFirst(ruleCall.getArguments(), null);
		Assert.assertEquals(Iterables.getFirst(rootRule.getParameters(), null), argument.getParameter());
		Assert.assertEquals(Iterables.getFirst(getLastRule.getParameters(), null),
				((ParameterReference) argument.getValue()).getParameter());
	}

	@Test
	public void testImplicitNamedParameterLinking_02() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Root<MyParam>: rule=Rule<true>;\n" +
				"Rule<MyParam>: name=ID child=Root<false>?;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		ParserRule rootRule = (ParserRule) Iterables.getFirst(grammar.getRules(), null);
		ParserRule getLastRule = (ParserRule) Iterables.getLast(grammar.getRules());
		Assignment getLastAssignment = (Assignment) Iterables
				.getLast(((Group) getLastRule.getAlternatives()).getElements());
		RuleCall ruleCall = (RuleCall) getLastAssignment.getTerminal();
		NamedArgument argument = Iterables.getFirst(ruleCall.getArguments(), null);
		Assert.assertEquals(Iterables.getFirst(rootRule.getParameters(), null), argument.getParameter());
		Assert.assertFalse(((LiteralCondition) argument.getValue()).isTrue());
	}

	@Test
	public void testNamedParameterAdjustment() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Root<MyParam>: rule=Rule<true>;\n" +
				"Rule<MyParam>: name=ID child=Root<false>?;\n";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		ResourceSet resourceSet = grammar.eResource().getResourceSet();
		Resource otherResource = resourceSet.createResource(URI.createURI("other.xtext"));
		String otheGrammar = 
				"grammar test.SubLang with test.Lang\n" +
				"import 'http://test'\n" +
				"Root<MyParam>: rule=super::Rule<true>;\n";
		otherResource.load(new LazyStringInputStream(
				otheGrammar),
				null);
		Grammar subGrammar = (Grammar) Iterables.getFirst(otherResource.getContents(), null);
		ParserRule rootRule = (ParserRule) Iterables.getFirst(subGrammar.getRules(), null);
		ParserRule parentRule = (ParserRule) Iterables.getLast(grammar.getRules());
		Assignment getLastAssignment = (Assignment) Iterables
				.getLast(((Group) parentRule.getAlternatives()).getElements());
		RuleCall ruleCall = (RuleCall) getLastAssignment.getTerminal();
		NamedArgument argument = Iterables.getFirst(ruleCall.getArguments(), null);
		Assert.assertEquals(Iterables.getFirst(rootRule.getParameters(), null), argument.getParameter());
		Assert.assertFalse(((LiteralCondition) argument.getValue()).isTrue());
	}

	@Test
	public void testExplicitRuleCallsAreTracked() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=super::ID name=ID;\n" +
				"terminal ID: super;\n" +
				"terminal _super: 's';\n";
		XtextResource resource = getResourceFromString(grammarAsString);
		Grammar grammar = (Grammar) resource.getContents().get(0);
		AbstractRule firstRule = Iterables.getFirst(grammar.getRules(), null);
		RuleCall firstRuleCall = Iterators.filter(firstRule.eAllContents(), RuleCall.class).next();
		Assert.assertTrue(firstRuleCall.isExplicitlyCalled());
		RuleCall secondRuleCall = Iterators.getLast(Iterators.filter(firstRule.eAllContents(), RuleCall.class));
		Assert.assertFalse(secondRuleCall.isExplicitlyCalled());
		RuleCall thirdRuleCall = Iterators.filter(grammar.getRules().get(1).eAllContents(), RuleCall.class).next();
		Assert.assertTrue(thirdRuleCall.isExplicitlyCalled());
		resource.update(grammarAsString.indexOf("_super"), 1, " ");
		Assert.assertEquals(resource, firstRuleCall.eResource());
		Assert.assertEquals(resource, secondRuleCall.eResource());
		Assert.assertEquals(resource, thirdRuleCall.eResource());
		// bogus - resource is only updated after a call to getContents
		resource.getContents();
		Assert.assertFalse(thirdRuleCall.isExplicitlyCalled());
		Assert.assertEquals(Iterables.getLast(grammar.getRules()), thirdRuleCall.getRule());
	}

	@Test
	public void testQualifiedRuleCall_01() throws Exception {
		String grammarAsString =
				"grammar test.Lang with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"RuleA returns Type:\n" +
				"  name+=ID name+=super::ID name+=Terminals::ID name+=org::eclipse::xtext::common::Terminals::ID;\n" +
				"RuleB returns Type:\n" +
				"  name+=STRING name+=Lang::STRING name+=test::Lang::STRING;\n" +
				"RuleC returns Type:\n" +
				"  name+=super::STRING name+=Terminals::STRING name+=org::eclipse::xtext::common::Terminals::STRING;\n" +
				"terminal STRING: super::STRING;\n";
		XtextResource resource = getResourceFromString(grammarAsString);
		Grammar grammar = (Grammar) resource.getContents().get(0);
		AbstractRule firstRule = Iterables.getFirst(grammar.getRules(), null);
		AbstractRule idRule = GrammarUtil.findRuleForName(Iterables.getFirst(grammar.getUsedGrammars(), null), "ID");
		Assert.assertTrue(IterableExtensions.forall(GrammarUtil.containedRuleCalls(firstRule),
				(RuleCall it) -> Objects.equals(it.getRule(), idRule)));
		AbstractRule secondRule = Iterables.getFirst(IterableExtensions.tail(grammar.getRules()), null);
		AbstractRule stringRule = Iterables.getLast(grammar.getRules());
		Assert.assertTrue(IterableExtensions.forall(GrammarUtil.containedRuleCalls(secondRule),
				(RuleCall it) -> Objects.equals(it.getRule(), stringRule)));
		AbstractRule thirdRule = Iterables.getFirst(IterableExtensions.drop(grammar.getRules(), 2), null);
		AbstractRule inheritedString = GrammarUtil.findRuleForName(Iterables.getFirst(grammar.getUsedGrammars(), null),
				"STRING");
		Assert.assertTrue(IterableExtensions.forall(GrammarUtil.containedRuleCalls(thirdRule),
				(RuleCall it) -> Objects.equals(it.getRule(), inheritedString)));
	}

	@Test
	public void testQualifiedRuleCall_02() throws Exception {
		String grammarAsString =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal STRING: super;\n";
		XtextResource resource = getResourceFromString(grammarAsString);
		Grammar grammar = (Grammar) resource.getContents().get(0);
		TerminalRule string = (TerminalRule) grammar.getRules().get(1);
		RuleCall callToSuper = (RuleCall) string.getAlternatives();
		Assert.assertEquals(GrammarUtil.findRuleForName(Iterables.getFirst(grammar.getUsedGrammars(), null), "STRING"),
				callToSuper.getRule());
	}

	@Test
	public void testQualifiedRuleCall_03() throws Exception {
		String grammarAsString =
				"grammar test with org.eclipse.xtext.common.Terminals\n" +
				"generate test 'http://test'\n" +
				"Rule: name=ID;\n" +
				"terminal STRING: super;\n" +
				"terminal super: 'super';\n";
		XtextResource resource = getResourceFromString(grammarAsString);
		Grammar grammar = (Grammar) resource.getContents().get(0);
		TerminalRule string = (TerminalRule) grammar.getRules().get(1);
		RuleCall callToSuper = (RuleCall) string.getAlternatives();
		Assert.assertEquals(Iterables.getLast(grammar.getRules()), callToSuper.getRule());
	}

	@Test
	public void testGeneratedPackageRemovedProperly() throws Exception {
		String testGrammar = "grammar foo.Bar generate foo 'bar'  Model : name=ID;";
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("name"), 4, "foo");
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("generate foo") + 11, 1, "x");
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x");
	}

	@Test
	public void testImportedPackageRemovedProperly() throws Exception {
		String testGrammar = "grammar foo.Bar import 'classpath:/org/eclipse/xtext/xtext/Foo.ecore' as foo Model returns foo::Model: name=ID;";
		// package import not influenced by parser rule change
		checkPackageRemovalAfterGrammarChange(false, testGrammar, testGrammar.indexOf("name"), 4, "foo");
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("as foo") + 4, 1, "x");
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x");
	}

	@Test
	public void testRegisteredPackageNotUnloaded() throws Exception {
		String testGrammar = "grammar foo.Bar import 'http://www.eclipse.org/emf/2002/Ecore' EClass: 'foo';";
		checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, testGrammar.indexOf("'foo'"), 4, "foo");
		checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, testGrammar.indexOf("import ") + 11, 1, "x");
		checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x");
	}

	private void checkPackageRemovalAfterGrammarChange(boolean isRemoved, String originalGrammar, int offset,
			int length, String replacement) throws Exception {
		XtextResource resource = getResourceFromStringAndExpect(originalGrammar, 1);
		Grammar grammar = (Grammar) resource.getContents().get(0);
		AbstractMetamodelDeclaration generatedMetamodel = grammar.getMetamodelDeclarations().get(0);
		EPackage ePackage = generatedMetamodel.getEPackage();
		Assert.assertEquals(ePackage.eResource().getResourceSet(), resource.getResourceSet());
		resource.update(offset, length, replacement);
		if (isRemoved) {
			Assert.assertNull(ePackage.eResource().getResourceSet());
		} else {
			Assert.assertEquals(ePackage.eResource().getResourceSet(), resource.getResourceSet());
		}
		grammar = (Grammar) resource.getContents().get(0);
		generatedMetamodel = grammar.getMetamodelDeclarations().get(0);
		ePackage = generatedMetamodel.getEPackage();
		Assert.assertEquals(resource.getResourceSet(), ePackage.eResource().getResourceSet());
	}

	private void checkRegisteredPackageNotUnloadedAfterGrammarChange(String originalGrammar, int offset, int length,
			String replacement) throws Exception {
		XtextResource resource = getResourceFromString(originalGrammar);
		Grammar grammar = (Grammar) resource.getContents().get(0);
		AbstractMetamodelDeclaration generatedMetamodel = grammar.getMetamodelDeclarations().get(0);
		EPackage ePackage = generatedMetamodel.getEPackage();
		Assert.assertNull(((InternalEObject) ePackage).eProxyURI());
		resource.update(offset, length, replacement);
		Assert.assertNull(((InternalEObject) ePackage).eProxyURI());
	}
}
