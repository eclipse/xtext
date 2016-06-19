/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.xtext.generator.parser.antlr.AntlrGrammarGenUtil;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FirstSetComputationTest extends AbstractXtextTests {

	private XtextGrammarAccess grammarAccess;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		grammarAccess = (XtextGrammarAccess) getGrammarAccess();
	}
	
	protected void assertFirstSet(String expectation, AbstractRule rule) {
		RuleCall ruleCall = XtextFactory.eINSTANCE.createRuleCall();
		ruleCall.setRule(rule);
		List<AbstractElement> firstSet = AntlrGrammarGenUtil.getFirstSet(ruleCall);
		StringBuilder actual = new StringBuilder();
		GrammarElementTitleSwitch stringifier = new GrammarElementTitleSwitch();
		for(int i = 0; i < firstSet.size(); i++) {
			if (i != 0)
				actual.append(", ");
			actual.append(stringifier.apply(firstSet.get(i)));
		}
		assertEquals(expectation, actual.toString());
	}
	
	@Test public void testGrammar() throws Exception {
		assertFirstSet("'grammar'", grammarAccess.getGrammarRule());
	}
	@Test public void testAbstractMetamodelDeclaration() throws Exception {
		assertFirstSet("'generate', 'import'", grammarAccess.getAbstractMetamodelDeclarationRule());
	}
	@Test public void testAbstractRule() throws Exception {
		assertFirstSet("'fragment', 'true', 'false', 'terminal', 'enum', ID", grammarAccess.getAbstractRuleRule());
	}
	@Test public void testAlternatives() throws Exception {
		assertFirstSet("'=>', '->', 'true', 'false', '(', '{', '<', ID, STRING", grammarAccess.getAlternativesRule());
	}
	@Test public void testTerminalAlternatives() throws Exception {
		assertFirstSet("'true', 'false', '(', '!', '->', '.', 'EOF', STRING, ID", grammarAccess.getTerminalAlternativesRule());
	}
	
}
