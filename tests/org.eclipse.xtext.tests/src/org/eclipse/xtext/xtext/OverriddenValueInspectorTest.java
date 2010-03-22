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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OverriddenValueInspectorTest extends AbstractXtextRuleInspectorTest<Boolean, ParserRule> {

	@Override
	protected XtextRuleInspector<Boolean, ParserRule> createInspector() {
		return new OverriddenValueInspector(this);
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
	
	public void testRuleCall_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First returns Object: (Third|Second) cardinality=('+'|'*')?;\n" +
				"Second returns Object: '(' First ')';\n" +
				"Third returns Object: name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testNoMarkerForCalledRules_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First returns Object: Second;\n" +
				"Second returns Object: name=ID name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		assertEquals(warnings.toString(), 0, warnings.size());
		rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Second");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testUnorderedGroup_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : 'x' a = ID & 'y' b = ID ;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testUnorderedGroup_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : 'x' a = ID & 'y' a = ID ;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testUnorderedGroup_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : (a = ID & b = STRING)+;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testUnorderedGroup_04() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : ('x' a = ID & 'y' b = ID) a = ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testUnorderedGroup_05() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : a = ID (a = ID & b = STRING) ;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testUnorderedGroup_06() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : a = ID b = STRING & a = ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testBug306281_01() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (" +
				"		({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+')" +
				"	right=ID)*;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testBug306281_02() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (" +
				"		({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+')" +
				"	right=ID)* name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testBug306281_03() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (" +
				"		({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+')" +
				"	right=ID)+ name=ID;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
	
	public void testBug306281_04() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (" +
				"		({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+')?" +
				"	name=ID);";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertEquals(warnings.toString(), 2, warnings.size());
	}
	
	public void testBug306281_05() throws Exception {
		String grammarAsString = "grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (" +
				"		({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+')" +
				"	name=ID);";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		assertTrue(warnings.toString(), warnings.isEmpty());
	}
}
