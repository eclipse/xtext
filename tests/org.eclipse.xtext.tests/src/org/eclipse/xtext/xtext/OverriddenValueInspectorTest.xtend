/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext

import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.ParserRule
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class OverriddenValueInspectorTest extends AbstractXtextRuleInspectorTest<Boolean, ParserRule> {
	override protected XtextRuleInspector<Boolean, ParserRule> createInspector() {
		return new OverriddenValueInspector(this)
	}
	
	@Test def void testFragment_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : name=ID Named;
			fragment Named: name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
		val fragment = GrammarUtil.findRuleForName(grammar, "Named") as ParserRule
		fragment.validateRule
		assertEquals(warnings.toString(), 0, warnings.size())
	}
	
	@Test def void testFragment_02() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Named;
			fragment Named: name=ID+;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 0, warnings.size())
		val fragment = GrammarUtil.findRuleForName(grammar, "Named") as ParserRule
		fragment.validateRule
		assertEquals(warnings.toString(), 1, warnings.size())
	}
	
	@Test def void testFragment_03() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Named;
			fragment Named: name=ID Named;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.map[first].toString(), 0, warnings.size())
		val fragment = GrammarUtil.findRuleForName(grammar, "Named") as ParserRule
		fragment.validateRule
		assertEquals(warnings.map[first].toString(), 2, warnings.size())
	}
	
	@Test def void testFragment_04() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Named;
			fragment Named: name=ID NamedAgain;
			fragment NamedAgain returns Named: Named;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.map[first].toString(), 0, warnings.size())
		val fragment = GrammarUtil.findRuleForName(grammar, "Named") as ParserRule
		fragment.validateRule
		assertEquals(warnings.map[first].toString(), 2, warnings.size())
		val otherFragment = GrammarUtil.findRuleForName(grammar, "NamedAgain") as ParserRule
		otherFragment.validateRule
		assertEquals(warnings.map[first].toString(), 0, warnings.size())
	}
	
	@Test def void testFragment_05() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Named*;
			fragment Named: name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 1, warnings.size())
		val fragment = GrammarUtil.findRuleForName(grammar, "Named") as ParserRule
		fragment.validateRule
		assertEquals(warnings.toString(), 0, warnings.size())
	}
	
	@Test def void testFragment_06() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Named Named;
			fragment Named*: name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
		val fragment = GrammarUtil.findRuleForName(grammar, "Named") as ParserRule
		fragment.validateRule
		assertEquals(warnings.toString(), 0, warnings.size())
	}

	@Test def void testBug280011_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Q : 'x' a = ID | 'y' a = ID ;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Q") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testBug280011_02() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Q : 'x' a = ID 'y' b = ID ;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Q") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testBug280011_03() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Q : 'x' a = ID 'y' a = ID ;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Q") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testBug280011_04() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Q : 'x' (a = ID)+;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Q") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 1, warnings.size())
	}

	@Test def void testAssignedAction_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second {First.second=current} second=Second;
			Second: name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testAssignedAction_02() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second ({First.second=current} name=ID)*;
			Second: name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testAssignedAction_03() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second {First.second=current} name=ID;
			Second: name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testAssignedAction_04() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second {First.second+=current} second+=Second;
			Second: name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testUnassignedRule_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second name+=ID;
			Second: name+=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testUnassignedRule_02() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second name=ID;
			Second: name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testUnassignedRule_03() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second (name=ID)?;
			Second: id=INT (name=ID)?;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testUnassignedRule_04() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second (name=ID)? id=INT;
			Second: id=INT (name=ID)?;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 4, warnings.size())
	}

	@Test def void testAlternative_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second | name=ID;
			Second: 'keyword' name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testAlternative_02() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : (Second | multiName+=ID) multiName+=ID id=INT;
			Second: 'keyword' name=ID id=INT;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testAlternative_03() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : (Second | multiName+=ID | id=INT) multiName+=ID id=INT;
			Second: 'keyword' name=ID id=INT;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 3, warnings.size())
	}

	@Test def void testAlternative_04() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : (Second | multiName+=ID | id=INT) multiName+=ID;
			Second: 'keyword' name=ID id=INT;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testOptionalAction_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second ({First.second=current} id=INT)? name=ID;
			Second: 'keyword' name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testOptionalAction_02() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second ({First.second=current} id=INT)* name=ID;
			Second: 'keyword' name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testOptionalAction_03() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second ({First.second=current} id=INT)+ name=ID;
			Second: 'keyword' name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testOptionalAction_04() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First : Second (isSecond='keyword' | {First.second=current} id=INT) name=ID;
			Second: 'keyword' name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testRuleCall_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First returns Object: (Third|Second) cardinality=('+'|'*')?;
			Second returns Object: '(' First ')';
			Third returns Object: name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testNoMarkerForCalledRules_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			First returns Object: Second;
			Second returns Object: name=ID name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		var rule = GrammarUtil.findRuleForName(grammar, "First") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 0, warnings.size())
		rule = GrammarUtil.findRuleForName(grammar, "Second") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testUnorderedGroup_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : 'x' a = ID & 'y' b = ID ;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testUnorderedGroup_02() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : 'x' a = ID & 'y' a = ID ;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testUnorderedGroup_03() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : (a = ID & b = STRING)+;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testUnorderedGroup_04() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : ('x' a = ID & 'y' b = ID) a = ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testUnorderedGroup_05() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : a = ID (a = ID & b = STRING) ;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testUnorderedGroup_06() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : a = ID b = STRING & a = ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testBug306281_01() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+') right=ID)*;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testBug306281_02() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+') right=ID)* name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testBug306281_03() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+') right=ID)+ name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testBug306281_04() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+')? name=ID);
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testBug306281_05() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = '-' | {Binary.left=current} operator = '+') name=ID);
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testBug306281_06() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) right=ID)*;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testBug306281_07() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) right=ID)* name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testBug306281_08() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) right=ID)+ name=ID;
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testBug306281_09() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model])?	name=ID);'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertEquals(warnings.toString(), 2, warnings.size())
	}

	@Test def void testBug306281_10() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model : name=ID (({Binary.left=current} operator = [Model] | {Binary.left=current} operator = [Model]) name=ID);
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

	@Test def void testBug306281_11() throws Exception {
		var String grammarAsString = '''
			grammar org.foo with org.eclipse.xtext.common.Terminals
			generate metamodel 'foo.sample'
			Model returns Model: SubModel ({Binary.params+=current} operator ='+' params+=SubModel)*;
			SubModel returns Model: '('Model')';
		'''
		val grammar = getGrammar(grammarAsString)
		val rule = GrammarUtil.findRuleForName(grammar, "Model") as ParserRule
		rule.validateRule
		assertTrue(warnings.toString(), warnings.isEmpty())
	}

}
														