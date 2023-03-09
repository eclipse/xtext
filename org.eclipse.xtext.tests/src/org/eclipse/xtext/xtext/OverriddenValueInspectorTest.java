/**
 * Copyright (c) 2009, 2020 itemis AG (http://www.itemis.eu) and others.
 * program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.util.Triple;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OverriddenValueInspectorTest extends AbstractXtextRuleInspectorTest<Boolean, ParserRule> {
	@Override
	protected XtextRuleInspector<Boolean, ParserRule> createInspector() {
		return new OverriddenValueInspector(this);
	}

	@Test
	public void testFragment_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : name=ID Named;\n" +
				"fragment Named: name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "Named");
		validateRule(fragment);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
	}

	@Test
	public void testFragment_02() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Named;\n" +
				"fragment Named: name=ID+;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "Named");
		validateRule(fragment);
		Assert.assertEquals(warnings.toString(), 1, warnings.size());
	}

	@Test
	public void testFragment_03() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Named;\n" +
				"fragment Named: name=ID Named;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(Lists.transform(warnings, Triple::getFirst).toString(),
				0, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "Named");
		validateRule(fragment);
		Assert.assertEquals(Lists.transform(warnings, Triple::getFirst).toString(),
				2, warnings.size());
	}

	@Test
	public void testFragment_04() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Named;\n" +
				"fragment Named: name=ID NamedAgain;\n" +
				"fragment NamedAgain returns Named: Named;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(Lists.transform(warnings, Triple::getFirst).toString(),
				0, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "Named");
		validateRule(fragment);
		Assert.assertEquals(Lists.transform(warnings, Triple::getFirst).toString(),
				2, warnings.size());
		ParserRule otherFragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "NamedAgain");
		validateRule(otherFragment);
		Assert.assertEquals(Lists.transform(warnings, Triple::getFirst).toString(),
				0, warnings.size());
	}

	@Test
	public void testFragment_05() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Named*;\n" +
				"fragment Named: name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 1, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "Named");
		validateRule(fragment);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
	}

	@Test
	public void testFragment_06() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Named Named;\n" +
				"fragment Named*: name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "Named");
		validateRule(fragment);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
	}

	@Test
	public void testFragment_07() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"EntryRule:\n" +
				"\tname=ID FragmentWithAction\n" +
				";\n" +
				"fragment FragmentWithAction returns EntryRule:\n" +
				"\t{EntryRule.prev=current} name=ID\n" +
				";\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "EntryRule");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "FragmentWithAction");
		validateRule(fragment);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
	}

	@Test
	public void testFragment_08() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"EntryRule:\n" +
				"\tname=ID FragmentWithAction\n" +
				";\n" +
				"fragment FragmentWithAction returns EntryRule:\n" +
				"\tname=ID {EntryRule.prev=current} name=ID\n" +
				";\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "EntryRule");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "FragmentWithAction");
		validateRule(fragment);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
	}

	@Test
	public void testFragment_09() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"EntryRule:\n" +
				"\tname=ID FragmentWithAction\n" +
				";\n" +
				"fragment FragmentWithAction returns EntryRule:\n" +
				"\tname=ID {EntryRule.prev=current}\n" +
				";\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "EntryRule");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "FragmentWithAction");
		validateRule(fragment);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
	}

	@Test
	public void testFragment_10() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"EntryRule:\n" +
				"\tname=ID FragmentWithAction*\n" +
				";\n" +
				"fragment FragmentWithAction returns EntryRule:\n" +
				"\t({EntryRule.prev=current} name=ID)*\n" +
				";\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "EntryRule");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
		ParserRule fragment = (ParserRule) GrammarUtil.findRuleForName(grammar, "FragmentWithAction");
		validateRule(fragment);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
	}

	@Test
	public void testBug280011_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Q : 'x' a = ID | 'y' a = ID ;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Q");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testBug280011_02() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Q : 'x' a = ID 'y' b = ID ;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Q");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testBug280011_03() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Q : 'x' a = ID 'y' a = ID ;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Q");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testBug280011_04() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Q : 'x' (a = ID)+;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Q");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 1, warnings.size());
	}

	@Test
	public void testAssignedAction_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second {First.second=current} second=Second;\n" +
				"Second: name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testAssignedAction_02() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second ({First.second=current} name=ID)*;\n" +
				"Second: name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testAssignedAction_03() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second {First.second=current} name=ID;\n" +
				"Second: name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testAssignedAction_04() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second {First.second+=current} second+=Second;\n" +
				"Second: name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testUnassignedRule_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second name+=ID;\n" +
				"Second: name+=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testUnassignedRule_02() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second name=ID;\n" +
				"Second: name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testUnassignedRule_03() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second (name=ID)?;\n" +
				"Second: id=INT (name=ID)?;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testUnassignedRule_04() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second (name=ID)? id=INT;\n" +
				"Second: id=INT (name=ID)?;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 4, warnings.size());
	}

	@Test
	public void testAlternative_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second | name=ID;\n" +
				"Second: 'keyword' name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testAlternative_02() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : (Second | multiName+=ID) multiName+=ID id=INT;\n" +
				"Second: 'keyword' name=ID id=INT;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testAlternative_03() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : (Second | multiName+=ID | id=INT) multiName+=ID id=INT;\n" +
				"Second: 'keyword' name=ID id=INT;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 3, warnings.size());
	}

	@Test
	public void testAlternative_04() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : (Second | multiName+=ID | id=INT) multiName+=ID;\n" +
				"Second: 'keyword' name=ID id=INT;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testOptionalAction_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second ({First.second=current} id=INT)? name=ID;\n" +
				"Second: 'keyword' name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testOptionalAction_02() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second ({First.second=current} id=INT)* name=ID;\n" +
				"Second: 'keyword' name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testOptionalAction_03() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second ({First.second=current} id=INT)+ name=ID;\n" +
				"Second: 'keyword' name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testOptionalAction_04() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First : Second (isSecond='keyword' | {First.second=current} id=INT) name=ID;\n" +
				"Second: 'keyword' name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testRuleCall_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First returns Object: (Third|Second) cardinality=('+'|'*')?;\n" +
				"Second returns Object: '(' First ')';\n" +
				"Third returns Object: name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testNoMarkerForCalledRules_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"First returns Object: Second;\n" +
				"Second returns Object: name=ID name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "First");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 0, warnings.size());
		rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Second");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testUnorderedGroup_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : 'x' a = ID & 'y' b = ID ;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testUnorderedGroup_02() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : 'x' a = ID & 'y' a = ID ;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testUnorderedGroup_03() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : (a = ID & b = STRING)+;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testUnorderedGroup_04() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : ('x' a = ID & 'y' b = ID) a = ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testUnorderedGroup_05() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : a = ID (a = ID & b = STRING) ;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testUnorderedGroup_06() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : a = ID b = STRING & a = ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testBug306281_01() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+') right=ID)*;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testBug306281_02() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+') right=ID)* name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testBug306281_03() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+') right=ID)+ name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testBug306281_04() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+')? name=ID);\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testBug306281_05() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+') name=ID);\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testBug306281_06() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) right=ID)*;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testBug306281_07() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) right=ID)* name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testBug306281_08() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) right=ID)+ name=ID;\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testBug306281_09() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model])?\tname=ID);";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertEquals(warnings.toString(), 2, warnings.size());
	}

	@Test
	public void testBug306281_10() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) name=ID);\n";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}

	@Test
	public void testBug306281_11() throws Exception {
		String grammarAsString =
				"grammar org.foo with org.eclipse.xtext.common.Terminals\n" +
				"generate metamodel 'foo.sample'\n" +
				"Model returns Model: SubModel ({Binary.params+=current} operator ='+' params+=SubModel)*;\n" +
				"SubModel returns Model: '(' Model ')';";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Model");
		validateRule(rule);
		Assert.assertTrue(warnings.toString(), warnings.isEmpty());
	}
}
