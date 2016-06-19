/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext

import org.eclipse.xtext.Alternatives
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.CrossReference
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.Group
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PredicatedElementTest extends AbstractXtextTests {
	
	override void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup);
	}
	
	@Test
	def void testPredicatedElement_01() {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			RootRule: Child;
			Child: =>(name=ID ->child=Child?);
		'''
		assertPredicate('ID ID?', grammar)	
	}
	
	@Test
	def void testPredicatedElement_02() {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			RootRule: Child;
			Child: =>(name=ID ->child=Sub);
			Sub: age=INT? name=STRING;
		'''
		assertPredicate('ID (INT | STRING)', grammar)	
	}
	
	@Test
	def void testPredicatedElement_03() {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			RootRule: Child;
			Child: =>(name=ID =>child=Sub);
			Sub: age=INT? name=STRING;
		'''
		assertPredicate('ID Sub', grammar)	
	}
	
	@Test
	def void testPredicatedElement_04() {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			RootRule: =>Child;
			Child: =>(name=ID =>child=Sub);
			Sub: age=INT? name=STRING;
		'''
		assertPredicate('Child', grammar)	
	}
	
	@Test
	def void testPredicatedElement_05() {
		val grammar = '''
			grammar test with org.eclipse.xtext.common.Terminals
			generate test 'http://test'
			RootRule: Child;
			Child: =>(name=ID (child=Child? | zonk=ID? ->sub=Sub));
			Sub: age=INT? name=STRING;
		'''
		assertPredicate('ID (Child? | ID? (INT | STRING))', grammar)	
	}
	
	def void assertPredicate(String expectation, String grammar) {
		val parsed = getModel(grammar) as Grammar
		val body = parsed.rules.head.alternatives
		val predicate = AntlrGrammarGenUtil.getPredicatedElement(body)
		assertEquals(expectation, predicate.toXtext)
	}
	
	def dispatch String toXtext(Group group) {
		if (group.cardinality === null)
			group.elements.join(' ') [ toXtext ]
		else
			group.elements.join('(', ' ', ')' + group.cardinality) [ toXtext ]
	}
	
	def dispatch String toXtext(Alternatives alt) {
		alt.elements.join('(', ' | ', ')' + (alt.cardinality?:'')) [ toXtext ]
	}
	
	def dispatch String toXtext(Keyword kw) {
		return "'" + kw.value + "'" + (kw.cardinality?:'')
	}
	
	def dispatch String toXtext(RuleCall rc) {
		return rc.rule.name + (rc.cardinality?:'')
	}
	
	def dispatch String toXtext(Assignment ass) {
		return ass.terminal.toXtext + (ass.cardinality?:'')
	}
	
	def dispatch String toXtext(CrossReference cr) {
		return cr.terminal.toXtext
	}
	
}