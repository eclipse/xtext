/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext

import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.tests.AbstractXtextTests
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SuperCallScopeTest extends AbstractXtextTests {
	override void setUp() throws Exception {
		super.setUp()
		with(new XtextStandaloneSetup)
	}
	
	@Test def void testGetAllElements_01() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar)
		assertElementNames(scope.allElements, 
			'Lang.Rule', 'test.Lang.Rule',
			'Lang.ID', 'test.Lang.ID',
			'super.ID', 'Terminals.ID', 'org.eclipse.xtext.common.Terminals.ID',
			'super.INT', 'Terminals.INT', 'org.eclipse.xtext.common.Terminals.INT',
			'super.STRING', 'Terminals.STRING', 'org.eclipse.xtext.common.Terminals.STRING',
			'super.ML_COMMENT', 'Terminals.ML_COMMENT',	'org.eclipse.xtext.common.Terminals.ML_COMMENT',
			'super.SL_COMMENT', 'Terminals.SL_COMMENT',	'org.eclipse.xtext.common.Terminals.SL_COMMENT',
			'super.WS', 'Terminals.WS',	'org.eclipse.xtext.common.Terminals.WS',
			'super.ANY_OTHER', 'Terminals.ANY_OTHER', 'org.eclipse.xtext.common.Terminals.ANY_OTHER'
		)
	}
	
	@Test def void testGetAllElements_02() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar.rules.last)
		assertElementNames(scope.allElements, 
			'Lang.Rule', 'test.Lang.Rule',
			'Lang.ID', 'test.Lang.ID',
			'super',
			'super.ID', 'Terminals.ID', 'org.eclipse.xtext.common.Terminals.ID',
			'super.INT', 'Terminals.INT', 'org.eclipse.xtext.common.Terminals.INT',
			'super.STRING', 'Terminals.STRING', 'org.eclipse.xtext.common.Terminals.STRING',
			'super.ML_COMMENT', 'Terminals.ML_COMMENT',	'org.eclipse.xtext.common.Terminals.ML_COMMENT',
			'super.SL_COMMENT', 'Terminals.SL_COMMENT',	'org.eclipse.xtext.common.Terminals.SL_COMMENT',
			'super.WS', 'Terminals.WS',	'org.eclipse.xtext.common.Terminals.WS',
			'super.ANY_OTHER', 'Terminals.ANY_OTHER', 'org.eclipse.xtext.common.Terminals.ANY_OTHER'
		)
	}
	
	@Test def void testGetElementsByName_01() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar)
		assertElements(scope.getElements(QualifiedName.create('ID')))
	}
	
	@Test def void testGetElementsByName_02() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar)
		assertElements(scope.getElements(QualifiedName.create('super')))
	}
	
	@Test def void testGetElementsByName_03() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar.rules.head)
		assertElements(scope.getElements(QualifiedName.create('super')))
	}
	
	@Test def void testGetElementsByName_04() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar.rules.last)
		assertElements(scope.getElements(QualifiedName.create('super')), "super" -> GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID'))
	}
	
	@Test def void testGetElementsByName_05() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar)
		assertElements(scope.getElements(QualifiedName.create('super', 'ID')), "super.ID" -> GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID'))
	}
	
	@Test def void testGetElementsByName_06() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar)
		assertElements(scope.getElements(QualifiedName.create('Lang', 'ID')), "Lang.ID" -> GrammarUtil.findRuleForName(grammar, 'test.Lang.ID'))
	}
	
	@Test def void testGetElementsByName_07() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar)
		assertElements(scope.getElements(QualifiedName.create('test', 'Lang', 'ID')), "test.Lang.ID" -> GrammarUtil.findRuleForName(grammar, 'test.Lang.ID'))
	}
	
	@Test def void testGetElementsByEObject_01() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar)
		val id = GrammarUtil.findRuleForName(grammar, 'test.Lang.ID')
		assertElements(scope.getElements(id),
			"Lang.ID" -> GrammarUtil.findRuleForName(grammar, 'test.Lang.ID'),
			"test.Lang.ID" -> GrammarUtil.findRuleForName(grammar, 'test.Lang.ID')
		)
	}
	
	@Test def void testGetElementsByEObject_02() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar.rules.head)
		val id = GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID')
		assertElements(scope.getElements(id),
			"super.ID" -> GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID'),
			"Lang.ID" -> GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID'),
			"test.Lang.ID" -> GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID')
		)
	}
	
	@Test def void testGetElementsByEObject_03() throws Exception {
		val grammarAsString = '''
			grammar test.Lang with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			Rule: name=ID;
			terminal ID: super;
		'''
		val grammar = grammarAsString.model as Grammar
		val scope = new SuperCallScope(grammar.rules.last)
		val id = GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID')
		assertElements(scope.getElements(id),
			"super" -> GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID'),
			"super.ID" -> GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID'),
			"Lang.ID" -> GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID'),
			"test.Lang.ID" -> GrammarUtil.findRuleForName(grammar, 'org.eclipse.xtext.common.Terminals.ID')
		)
	}
	
	def assertElementNames(Iterable<IEObjectDescription> descriptions, String... expectedNames) {
		assertEquals(expectedNames.join('\n'), descriptions.map[name.toString].join('\n'))	
	}
	
	def assertElements(Iterable<IEObjectDescription> descriptions, Pair<String, AbstractRule>... expected) {
		assertEquals(
			expected.map[key + '->' + GrammarUtil.getGrammar(value).name + '.' + value.name].join('\n'),
			descriptions.map[name.toString + '->' + GrammarUtil.getGrammar(EObjectOrProxy).name + '.' + (EObjectOrProxy as AbstractRule).name].join('\n')
		)	
	}
	
}