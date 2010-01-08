/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.ecore2xtext;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * @author koehnlein - Initial contribution and API
 */
public class GrammarTest extends AbstractXtextTests {

	public void testExampleGrammar() throws Exception {
		with(Ecore2XtextTestStandaloneSetup.class);
		Grammar grammar = getGrammarAccess().getGrammar();
		EList<AbstractMetamodelDeclaration> metamodelDeclarations = grammar.getMetamodelDeclarations();
		assertEquals(2, metamodelDeclarations.size());
		AbstractRule intDatatypeRule = GrammarUtil.findRuleForName(grammar, "INT0");
		assertNotNull(intDatatypeRule);
		
		AbstractRule abstractRule = GrammarUtil.findRuleForName(grammar, "Abstract");
		AbstractElement alternatives = abstractRule.getAlternatives();
		assertTrue(alternatives instanceof Alternatives);
		assertEquals(2, ((Alternatives) alternatives).getGroups().size());
		assertTrue(GrammarUtil.containedAssignments(abstractRule).isEmpty());
		
		checkConcreteRule(grammar, "Concrete0");
		checkConcreteRule(grammar, "Concrete1");
		
		ParserRule rootRule = (ParserRule) grammar.getRules().get(0);
		assertEquals("Root", rootRule.getName());
		List<Assignment> assignments = GrammarUtil.containedAssignments(rootRule);
		assertEquals(3, assignments.size());
		assertEquals("name", assignments.get(0).getFeature());
		assertEquals("classes", assignments.get(1).getFeature());
		assertEquals("+=", assignments.get(1).getOperator());
		assertEquals("classes", assignments.get(2).getFeature());
		assertEquals("+=", assignments.get(2).getOperator());
	}

	private AbstractRule checkConcreteRule(Grammar grammar, String ruleName) {
		AbstractRule concreteRule = GrammarUtil.findRuleForName(grammar, ruleName);
		assertNotNull(concreteRule);
		List<Assignment> assignments = GrammarUtil.containedAssignments(concreteRule);
		assertEquals(1, assignments.size());
		assertEquals("name", assignments.get(0).getFeature());
		assertEquals("=", assignments.get(0).getOperator());
		return concreteRule;
	}
}
