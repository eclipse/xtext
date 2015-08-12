/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuleWithoutInstantiationInspectorTest extends AbstractXtextRuleInspectorTest<Boolean, ParserRule> {

	@Override
	protected XtextRuleInspector<Boolean, ParserRule> createInspector() {
		return new RuleWithoutInstantiationInspector(this);
	}
	
	@Test public void testFragment_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: name=ID X;\n" +
				"fragment X : 'x';";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testFragment_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: name=ID X;\n" +
				"fragment X*: 'x';";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testDatatypes() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : 'x';";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test public void testAssignment_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : x='x';";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testAssignment_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : (x+='x')+;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testAssignment_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : (x+='x')*;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertEquals(warnings.toString(), 1, warnings.size());
		String message = warnings.get(0).getFirst();
		assertTrue(message, message.contains("{X}"));
	}
	
	@Test public void testAssignment_04() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample' as x\n" +
				"Model returns x::Model: x=X;\n" +
				"X returns x::X: (x+='x')*;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertEquals(warnings.toString(), 1, warnings.size());
		String message = warnings.get(0).getFirst();
		assertTrue(message, message.contains("{x::X}"));
	}
	
	@Test public void testAssignment_05() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : ID (x+='x')+;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testAssignment_06() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : ID (x+='x')*;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertEquals(warnings.toString(), 1, warnings.size());
		String message = warnings.get(0).getFirst();
		assertTrue(message, message.contains("{X}"));
	}
	
	@Test public void testIgnoreFirstRule_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"X : (x+='x')*;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testIgnoreFirstRule_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"X : 'keyword' (x+='x')*;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testAction_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : {X} ID?;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testAction_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : {X} | ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertEquals(warnings.toString(), 1, warnings.size());
	}
	
	@Test public void testRuleCall_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : Y;\n" +
				"Y : name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testRuleCall_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : Y | name=ID;\n" +
				"Y : ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertEquals(warnings.toString(), 1, warnings.size());
	}
	
	@Test public void testRuleCall_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : INT (ID? {X} ID?);\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	@Test public void testUnorderedGroup_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : {X} | 'keyword0' & 'keyword1';\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertEquals(warnings.toString(), 1, warnings.size());
	}
	
	@Test public void testUnorderedGroup_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : value='keyword0' & 'keyword1';\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertEquals(warnings.toString(), 0, warnings.size());
	}
	
	@Test public void testUnorderedGroup_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : value='keyword0'? & 'keyword1';\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertEquals(warnings.toString(), 1, warnings.size());
	}
	
	@Test public void testUnorderedGroup_04() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : value='keyword0'? & value='keyword1';\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertEquals(warnings.toString(), 0, warnings.size());
	}
	
	@Test public void testBug_287735_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model: x=X;\n" +
				"X : Y | Z;\n";
		Grammar grammar = getGrammarWithErrors(grammarAsString, 2);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "X");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
}
