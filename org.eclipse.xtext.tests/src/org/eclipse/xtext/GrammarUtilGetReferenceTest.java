/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarUtilGetReferenceTest extends AbstractXtextTests {
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}
	
	@Test public void testGetReference_01() throws Exception {
		String grammarAsString = "grammar foo.bar with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: model=[Model];";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		AbstractRule ruleModel = grammar.getRules().get(0);
		CrossReference crossRef = (CrossReference) ((Assignment) ruleModel.getAlternatives()).getTerminal();
		EReference reference = GrammarUtil.getReference(crossRef);
		assertEquals("model", reference.getName());
		assertEquals("Model", reference.getEContainingClass().getName());
	}
	
	@Test public void testGetReference_02() throws Exception {
		String grammarAsString = "grammar foo.bar with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: {SubModel} model=[Model];";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		AbstractRule ruleModel = grammar.getRules().get(0);
		Group group = (Group) ruleModel.getAlternatives();
		Assignment assignment = (Assignment) group.getElements().get(1);
		CrossReference crossRef = (CrossReference) assignment.getTerminal();
		EReference reference = GrammarUtil.getReference(crossRef);
		assertEquals("model", reference.getName());
		assertEquals("SubModel", reference.getEContainingClass().getName());
	}
	
	@Test public void testGetReference_03() throws Exception {
		String grammarAsString = "grammar foo.bar with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: {SubModel1} model=[Model] | {SubModel2} model=[Model];";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		AbstractRule ruleModel = grammar.getRules().get(0);
		Alternatives alternatives = (Alternatives) ruleModel.getAlternatives();
		Group group = (Group) alternatives.getElements().get(0);
		Assignment assignment = (Assignment) group.getElements().get(1);
		CrossReference crossRef = (CrossReference) assignment.getTerminal();
		EReference reference = GrammarUtil.getReference(crossRef);
		assertEquals("model", reference.getName());
		assertEquals("Model", reference.getEContainingClass().getName());
	}
	
	@Test public void testGetReference_04() throws Exception {
		String grammarAsString = "grammar foo.bar with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: {SubModel1} model=[Model] | {SubModel2} model=[Model];";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		AbstractRule ruleModel = grammar.getRules().get(0);
		Alternatives alternatives = (Alternatives) ruleModel.getAlternatives();
		Group group = (Group) alternatives.getElements().get(1);
		Assignment assignment = (Assignment) group.getElements().get(1);
		CrossReference crossRef = (CrossReference) assignment.getTerminal();
		EReference reference = GrammarUtil.getReference(crossRef);
		assertEquals("model", reference.getName());
		assertEquals("Model", reference.getEContainingClass().getName());
	}
	
	@Test public void testGetReference_05() throws Exception {
		String grammarAsString = "grammar foo.bar with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: {SubModel1} model1=[Model] | {SubModel2} model2=[Model];";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		AbstractRule ruleModel = grammar.getRules().get(0);
		Alternatives alternatives = (Alternatives) ruleModel.getAlternatives();
		Group group = (Group) alternatives.getElements().get(0);
		Assignment assignment = (Assignment) group.getElements().get(1);
		CrossReference crossRef = (CrossReference) assignment.getTerminal();
		EReference reference = GrammarUtil.getReference(crossRef);
		assertEquals("model1", reference.getName());
		assertEquals("SubModel1", reference.getEContainingClass().getName());
	}

	@Test public void testGetReference_06() throws Exception {
		String grammarAsString = "grammar foo.bar with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: {SubModel1} model1=[Model] | {SubModel2} model2=[Model];";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		AbstractRule ruleModel = grammar.getRules().get(0);
		Alternatives alternatives = (Alternatives) ruleModel.getAlternatives();
		Group group = (Group) alternatives.getElements().get(1);
		Assignment assignment = (Assignment) group.getElements().get(1);
		CrossReference crossRef = (CrossReference) assignment.getTerminal();
		EReference reference = GrammarUtil.getReference(crossRef);
		assertEquals("model2", reference.getName());
		assertEquals("SubModel2", reference.getEContainingClass().getName());
	}
	
	@Test public void testGetReference_07() throws Exception {
		String grammarAsString = "grammar foo.bar with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: model1=[Model] & model2=[Model|STRING];";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		AbstractRule ruleModel = grammar.getRules().get(0);
		UnorderedGroup group = (UnorderedGroup) ruleModel.getAlternatives();
		Assignment assignment = (Assignment) group.getElements().get(0);
		CrossReference crossRef = (CrossReference) assignment.getTerminal();
		EReference reference = GrammarUtil.getReference(crossRef);
		assertEquals("model1", reference.getName());
		assertEquals("Model", reference.getEContainingClass().getName());
	}

	@Test public void testGetReference_08() throws Exception {
		String grammarAsString = "grammar foo.bar with org.eclipse.xtext.common.Terminals\n" +
			"generate test 'http://test'\n" +
			"Model: {SubModel} (model1=[Model] & model2=[Model|STRING]);";
		Grammar grammar = (Grammar) getModel(grammarAsString);
		AbstractRule ruleModel = grammar.getRules().get(0);
		Group group = (Group) ruleModel.getAlternatives();
		UnorderedGroup unorderedGroup = (UnorderedGroup) group.getElements().get(1);
		Assignment assignment = (Assignment) unorderedGroup.getElements().get(1);
		CrossReference crossRef = (CrossReference) assignment.getTerminal();
		EReference reference = GrammarUtil.getReference(crossRef);
		assertEquals("model2", reference.getName());
		assertEquals("SubModel", reference.getEContainingClass().getName());
	}

}
