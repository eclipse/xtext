/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xtext.XtextValidator.OverriddenValueIdentifier;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OverriddenValueIdentifierTest extends AbstractXtextTests implements ValidationMessageAcceptor {

	private List<Triple<String, EObject, Integer>> warnings;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		warnings = Lists.newArrayList();
	}
	
	@Override
	protected void tearDown() throws Exception {
		warnings = null;
		super.tearDown();
	}
	
	public void validateRule(AbstractRule rule) {
		assertNotNull("rule", rule);
		warnings.clear();
		OverriddenValueIdentifier strategy = new OverriddenValueIdentifier(this, rule);
		strategy.doSwitch(rule.getAlternatives());
	}

	public void acceptError(String message, EObject object, Integer feature) {
		fail("unexpected call to acceptError");
	}

	public void acceptWarning(String message, EObject object, Integer feature) {
		Triple<String,EObject,Integer> warning = Tuples.create(message, object, feature);
		warnings.add(warning);
	}
	
	public void testBug280011_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Q : 'x' a = ID | 'y' a = ID ;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Q");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testBug280011_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Q : 'x' a = ID 'y' b = ID ;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Q");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testBug280011_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Q : 'x' a = ID 'y' a = ID ;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Q");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testBug280011_04() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Q : 'x' (a = ID)+;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Q");
		validateRule(rule);
		assertEquals(warnings.toString(), 1, warnings.size());
	}
	
	public void testAssignedAction_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second {First.second=current} second=Second;\n" +
				"Second: name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testAssignedAction_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second ({First.second=current} name=ID)*;\n" +
				"Second: name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testAssignedAction_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second {First.second=current} name=ID;\n" +
				"Second: name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}

	public void testAssignedAction_04() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second {First.second+=current} second+=Second;\n" +
				"Second: name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testUnassignedRule_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second name+=ID;\n" +
				"Second: name+=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testUnassignedRule_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second name=ID;\n" +
				"Second: name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testUnassignedRule_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second (name=ID)?;\n" +
				"Second: id=INT (name=ID)?;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testUnassignedRule_04() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second (name=ID)? id=INT;\n" +
				"Second: id=INT (name=ID)?;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 4, warnings.size());
	}
	
	public void testAlternative_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second | name=ID;\n" +
				"Second: 'keyword' name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testAlternative_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : (Second | multiName+=ID) multiName+=ID id=INT;\n" +
				"Second: 'keyword' name=ID id=INT;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testAlternative_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : (Second | multiName+=ID | id=INT) multiName+=ID id=INT;\n" +
				"Second: 'keyword' name=ID id=INT;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 3, warnings.size());
	}
	
	public void testAlternative_04() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : (Second | multiName+=ID | id=INT) multiName+=ID;\n" +
				"Second: 'keyword' name=ID id=INT;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testOptionalAction_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second ({First.second=current} id=INT)? name=ID;\n" +
				"Second: 'keyword' name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testOptionalAction_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second ({First.second=current} id=INT)* name=ID;\n" +
				"Second: 'keyword' name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testOptionalAction_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second ({First.second=current} id=INT)+ name=ID;\n" +
				"Second: 'keyword' name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testOptionalAction_04() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second (isSecond='keyword' | {First.second=current} id=INT) name=ID;\n" +
				"Second: 'keyword' name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	
	private Grammar getGrammar(String grammar) throws Exception {
		XtextResource resourceFromString = getResourceFromString(grammar);
		assertTrue(resourceFromString.getErrors().toString(), resourceFromString.getErrors().isEmpty());
		return (Grammar) resourceFromString.getContents().get(0);
	}
}
