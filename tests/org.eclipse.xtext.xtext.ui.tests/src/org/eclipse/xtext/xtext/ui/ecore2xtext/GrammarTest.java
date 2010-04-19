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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
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

		AbstractRule concrete0Rule = GrammarUtil.findRuleForName(grammar, "Concrete0");
		assertNotNull(concrete0Rule);
		
		AbstractRule abstractRule = GrammarUtil.findRuleForName(grammar, "Abstract");
		AbstractElement alternatives = abstractRule.getAlternatives();
		assertTrue(alternatives instanceof Alternatives);
		assertEquals(3, ((Alternatives) alternatives).getElements().size());
		assertTrue(GrammarUtil.containedAssignments(abstractRule).isEmpty());
		
		checkConcreteImplRule(grammar, "Concrete0_Impl");
		checkConcreteImplRule(grammar, "Concrete1_Impl");
		
		ParserRule rootRule = (ParserRule) grammar.getRules().get(0);
		assertEquals("Root", rootRule.getName());
		List<Assignment> assignments = GrammarUtil.containedAssignments(rootRule);
		assertEquals(4, assignments.size());
		assertEquals("name", assignments.get(0).getFeature());
		assertEquals("classes", assignments.get(1).getFeature());
		assertEquals("+=", assignments.get(1).getOperator());
		assertEquals("classes", assignments.get(2).getFeature());
		assertEquals("+=", assignments.get(2).getOperator());
		assertEquals("concrete0", assignments.get(3).getFeature());
		assertEquals("=", assignments.get(3).getOperator());
	}

	private AbstractRule checkConcreteImplRule(Grammar grammar, String ruleName) {
		AbstractRule concreteRule = GrammarUtil.findRuleForName(grammar, ruleName);
		assertNotNull(concreteRule);
		EClassifier returnType = ((ParserRule)concreteRule).getType().getClassifier();
		String returnTypeName = getClassifierName(returnType);
		assertEquals(ruleName, returnTypeName + "_Impl");
		List<Assignment> assignments = GrammarUtil.containedAssignments(concreteRule);
		assertEquals(1, assignments.size());
		assertEquals("name", assignments.get(0).getFeature());
		assertEquals("=", assignments.get(0).getOperator());
		List<Action> containedActions = GrammarUtil.containedActions(concreteRule);
		assertEquals(1, containedActions.size());
		assertEquals(returnTypeName, getClassifierName(containedActions.get(0).getType().getClassifier()));
		List<Keyword> containedKeywords = GrammarUtil.containedKeywords(concreteRule);
		assertEquals(1, containedKeywords.size());
		assertEquals(returnTypeName, containedKeywords.get(0).getValue());
		return concreteRule;
	}

	protected String getClassifierName(EClassifier returnType) {
		return (returnType.eIsProxy()) ? ((InternalEObject)returnType).eProxyURI().fragment().replaceAll("/", "") : returnType.getName();
	}
}
