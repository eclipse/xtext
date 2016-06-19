/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.Alternatives
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.Group
import org.eclipse.xtext.LiteralCondition
import org.eclipse.xtext.Negation
import org.eclipse.xtext.ParameterReference
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.util.LazyStringInputStream
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtextLinkerTest extends AbstractXtextTests {
	override void setUp() throws Exception {
		super.setUp()
		with(new XtextStandaloneSetup())
	}
	
	@Test def void testGuardLinking() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Root<MyArg>: <MyArg> name=ID | <!MyArg> name=STRING;
		'''
		val grammar = grammarAsString.model as Grammar
		val rootRule = grammar.rules.head as ParserRule
		val alternatives = rootRule.alternatives as Alternatives
		val firstGuard = (alternatives.elements.head as Group).guardCondition as ParameterReference
		assertEquals(rootRule.parameters.head, firstGuard.parameter)
		val secondGuard = (alternatives.elements.last as Group).guardCondition as Negation
		assertEquals(rootRule.parameters.head, (secondGuard.value as ParameterReference).parameter)
	}
	
	@Test def void testNamedParameterLinking() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Root<MyArg>: rule=Rule<MyArg>;
			Rule<MyParam>: name=ID child=Root<MyArg=MyParam>?;
		'''
		val grammar = grammarAsString.model as Grammar
		val rootRule = grammar.rules.head as ParserRule
		val lastRule = grammar.rules.last as ParserRule
		val lastAssignment = (lastRule.alternatives as Group).elements.last as Assignment
		val ruleCall = lastAssignment.terminal as RuleCall
		val argument = ruleCall.arguments.head
		assertEquals(rootRule.parameters.head, argument.parameter)
		assertEquals(lastRule.parameters.head, (argument.value as ParameterReference).parameter)
	}
	
	@Test def void testImplicitNamedParameterLinking_01() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Root<MyParam>: rule=Rule<MyParam>;
			Rule<MyParam>: name=ID child=Root<MyParam>?;
		'''
		val grammar = grammarAsString.model as Grammar
		val rootRule = grammar.rules.head as ParserRule
		val lastRule = grammar.rules.last as ParserRule
		val lastAssignment = (lastRule.alternatives as Group).elements.last as Assignment
		val ruleCall = lastAssignment.terminal as RuleCall
		val argument = ruleCall.arguments.head
		assertEquals(rootRule.parameters.head, argument.parameter)
		assertEquals(lastRule.parameters.head, (argument.value as ParameterReference).parameter)
	}
	
	@Test def void testImplicitNamedParameterLinking_02() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Root<MyParam>: rule=Rule<true>;
			Rule<MyParam>: name=ID child=Root<false>?;
		'''
		val grammar = grammarAsString.model as Grammar
		val rootRule = grammar.rules.head as ParserRule
		val lastRule = grammar.rules.last as ParserRule
		val lastAssignment = (lastRule.alternatives as Group).elements.last as Assignment
		val ruleCall = lastAssignment.terminal as RuleCall
		val argument = ruleCall.arguments.head
		assertEquals(rootRule.parameters.head, argument.parameter)
		assertFalse((argument.value as LiteralCondition).isTrue)
	}
	
	@Test def void testNamedParameterAdjustment() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Root<MyParam>: rule=Rule<true>;
			Rule<MyParam>: name=ID child=Root<false>?;
		'''
		val grammar = grammarAsString.model as Grammar
		val resourceSet = grammar.eResource.resourceSet
		val otherResource = resourceSet.createResource(URI.createURI('other.xtext'))
		otherResource.load(new LazyStringInputStream('''
			grammar test.SubLang with test.Lang
			import 'http://test'
			Root<MyParam>: rule=super::Rule<true>;
		'''), null)
		val subGrammar = otherResource.contents.head as Grammar
		val rootRule = subGrammar.rules.head as ParserRule
		val parentRule = grammar.rules.last as ParserRule
		val lastAssignment = (parentRule.alternatives as Group).elements.last as Assignment
		val ruleCall = lastAssignment.terminal as RuleCall
		val argument = ruleCall.arguments.head
		assertEquals(rootRule.parameters.head, argument.parameter)
		assertFalse((argument.value as LiteralCondition).isTrue)
	}
	
	@Test def void testExplicitRuleCallsAreTracked() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=super::ID name=ID;
			terminal ID: super;
			terminal _super: 's';
		'''
		val resource = grammarAsString.resourceFromString
		var grammar = resource.getContents().get(0) as Grammar
		val firstRule = grammar.rules.head
		val firstRuleCall = firstRule.eAllContents.filter(RuleCall).head
		assertTrue(firstRuleCall.isExplicitlyCalled)
		
		val secondRuleCall = firstRule.eAllContents.filter(RuleCall).last
		assertFalse(secondRuleCall.isExplicitlyCalled)
		
		val thirdRuleCall = grammar.rules.get(1).eAllContents.filter(RuleCall).head
		assertTrue(thirdRuleCall.isExplicitlyCalled)
		
		resource.update(grammarAsString.indexOf('_super'), 1, ' ');
		assertEquals(resource, firstRuleCall.eResource)
		assertEquals(resource, secondRuleCall.eResource)
		assertEquals(resource, thirdRuleCall.eResource)
		// bogus - resource is only updated after a call to getContents
		resource.contents
		assertFalse(thirdRuleCall.isExplicitlyCalled)
		assertEquals(grammar.rules.last, thirdRuleCall.rule)
	}
	
	@Test def void testQualifiedRuleCall_01() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			RuleA returns Type:
			  name+=ID name+=super::ID name+=Terminals::ID name+=org::eclipse::xtext::common::Terminals::ID;
			RuleB returns Type:
			  name+=STRING name+=Lang::STRING name+=test::Lang::STRING;
			RuleC returns Type:
			  name+=super::STRING name+=Terminals::STRING name+=org::eclipse::xtext::common::Terminals::STRING;
			terminal STRING: super::STRING;
		'''
		val resource = grammarAsString.resourceFromString
		var grammar = resource.getContents().get(0) as Grammar
		val firstRule = grammar.rules.head
		val idRule = GrammarUtil.findRuleForName(grammar.usedGrammars.head, "ID")
		assertTrue(GrammarUtil.containedRuleCalls(firstRule).forall[
			rule == idRule 
		])
		val secondRule = grammar.rules.tail.head
		val stringRule = grammar.rules.last
		assertTrue(GrammarUtil.containedRuleCalls(secondRule).forall[
			rule == stringRule 
		])
		val thirdRule = grammar.rules.drop(2).head
		val inheritedString = GrammarUtil.findRuleForName(grammar.usedGrammars.head, "STRING")
		assertTrue(GrammarUtil.containedRuleCalls(thirdRule).forall[
			rule == inheritedString 
		])
	}
	
	@Test def void testQualifiedRuleCall_02() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal STRING: super;
		'''
		val resource = grammarAsString.resourceFromString
		var grammar = resource.getContents().get(0) as Grammar
		val string = grammar.rules.get(1) as TerminalRule
		val callToSuper = string.alternatives as RuleCall
		assertEquals(GrammarUtil.findRuleForName(grammar.usedGrammars.head, "STRING"), callToSuper.rule)
	}
	
	@Test def void testQualifiedRuleCall_03() throws Exception {
		val grammarAsString = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal STRING: super;
			terminal super: 'super';
		'''
		val resource = grammarAsString.resourceFromString
		var grammar = resource.getContents().get(0) as Grammar
		val string = grammar.rules.get(1) as TerminalRule
		val callToSuper = string.alternatives as RuleCall
		assertEquals(grammar.rules.last, callToSuper.rule)
	}

	@Test def void testGeneratedPackageRemovedProperly() throws Exception {
		val testGrammar = "grammar foo.Bar generate foo 'bar'  Model : name=ID;"
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("name"), 4, "foo")
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("generate foo") + 11, 1, "x")
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x")
	}

	@Test def void testImportedPackageRemovedProperly() throws Exception {
		val testGrammar = "grammar foo.Bar import 'classpath:/org/eclipse/xtext/xtext/Foo.ecore' as foo Model returns foo::Model: name=ID;"
		// package import not influenced by parser rule change
		checkPackageRemovalAfterGrammarChange(false, testGrammar, testGrammar.indexOf("name"), 4, "foo")
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("as foo") + 4, 1, "x")
		checkPackageRemovalAfterGrammarChange(true, testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x")
	}

	@Test def void testRegisteredPackageNotUnloaded() throws Exception {
		val testGrammar = "grammar foo.Bar import 'http://www.eclipse.org/emf/2002/Ecore' EClass: 'foo';"
		checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, testGrammar.indexOf("'foo'"), 4, "foo")
		checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, testGrammar.indexOf("import ") + 11, 1, "x")
		checkRegisteredPackageNotUnloadedAfterGrammarChange(testGrammar, testGrammar.indexOf("foo.Bar"), 1, "x")
	}

	def private void checkPackageRemovalAfterGrammarChange(boolean isRemoved,
			String originalGrammar, int offset,	int length, String replacement) throws Exception {
		val resource = getResourceFromStringAndExpect(originalGrammar, 1)
		var grammar = resource.getContents().get(0) as Grammar
		var generatedMetamodel = grammar.getMetamodelDeclarations().get(0)
		var ePackage = generatedMetamodel.getEPackage()
		assertEquals(ePackage.eResource().getResourceSet(), resource.getResourceSet())
		resource.update(offset, length, replacement)
		if (isRemoved) {
			assertNull(ePackage.eResource().getResourceSet())
		} else {
			assertEquals(ePackage.eResource().getResourceSet(), resource.getResourceSet())
		}
		grammar = resource.getContents().get(0) as Grammar
		generatedMetamodel = grammar.getMetamodelDeclarations().get(0)
		ePackage = generatedMetamodel.getEPackage()
		assertEquals(resource.getResourceSet(), ePackage.eResource().getResourceSet())
	}

	def private void checkRegisteredPackageNotUnloadedAfterGrammarChange(String originalGrammar,
			int offset, int length, String replacement) throws Exception {
		val resource = getResourceFromString(originalGrammar)
		val grammar = resource.getContents().get(0) as Grammar
		val generatedMetamodel = grammar.getMetamodelDeclarations().get(0)
		val ePackage = generatedMetamodel.getEPackage()
		assertNull((ePackage as InternalEObject).eProxyURI())
		resource.update(offset, length, replacement)
		assertNull((ePackage as InternalEObject).eProxyURI())
	}

}
