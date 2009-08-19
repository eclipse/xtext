/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;

import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class KeywordInspectorTest extends XtextInspectorTest {

	@Override
	protected boolean isExpectingWarnings() {
		return false;
	}
	
	@Override
	protected boolean isExpectingErrors() {
		return true;
	}
	
	public void validateRule(AbstractRule rule) {
		assertNotNull("rule", rule);
		warnings.clear();
		KeywordInspector inspector = new KeywordInspector(this);
		Iterator<Keyword> keywords = Iterators.filter(EcoreUtil.getAllContents(rule, true), Keyword.class);
		while(keywords.hasNext())
			inspector.inspectKeywordHidesTerminalRule(keywords.next());
	}
	
	public void testBug285146_01() throws Exception {
		String grammarAsString = "grammar org.xtext.example.MyDsl7 with org.eclipse.xtext.common.Terminals\n" + 
				"generate myDsl \"http://www.xtext.org/example/MyDsl\"\n" + 
				"Type : 'type' '#' name=ID;\n" + 
				"terminal POUND: '#';";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Type");
		validateRule(rule);
		assertEquals(errors.toString(), 1, errors.size());
	}
	
	public void testBug285146_02() throws Exception {
		String grammarAsString = "grammar org.xtext.example.MyDsl7 with org.eclipse.xtext.common.Terminals\n" + 
				"generate myDsl \"http://www.xtext.org/example/MyDsl\"\n" + 
				"Type : 'type' '#' name=ID;\n" + 
				"terminal POUND: '#'?;";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Type");
		validateRule(rule);
		assertEquals(errors.toString(), 0, errors.size());
	}
	
	public void testBug285146_03() throws Exception {
		String grammarAsString = "grammar org.xtext.example.MyDsl7 with org.eclipse.xtext.common.Terminals\n" + 
				"generate myDsl \"http://www.xtext.org/example/MyDsl\"\n" + 
				"Type : 'type' '#' name=ID;\n" + 
				"terminal POUND: ((('#')));";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Type");
		validateRule(rule);
		assertEquals(errors.toString(), 1, errors.size());
	}
	
	public void testBug285146_04() throws Exception {
		String grammarAsString = "grammar org.xtext.example.MyDsl7 with org.eclipse.xtext.common.Terminals\n" + 
				"generate myDsl \"http://www.xtext.org/example/MyDsl\"\n" + 
				"Type : 'type' '#' name=ID;\n" + 
				"terminal POUND: '#' '#';";
		Grammar grammar = getGrammar(grammarAsString);
		ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(grammar, "Type");
		validateRule(rule);
		assertEquals(errors.toString(), 0, errors.size());
	}
	
	public void testIgnoreTerminalRules() throws Exception {
		String grammarAsString = "grammar org.xtext.example.MyDsl7 with org.eclipse.xtext.common.Terminals\n" + 
				"generate myDsl \"http://www.xtext.org/example/MyDsl\"\n" + 
				"Type : 'type' '#' name=ID;\n" + 
				"terminal POUND: '#';";
		Grammar grammar = getGrammar(grammarAsString);
		AbstractRule rule = GrammarUtil.findRuleForName(grammar, "POUND");
		validateRule(rule);
		assertEquals(errors.toString(), 0, errors.size());
	}
	
}
