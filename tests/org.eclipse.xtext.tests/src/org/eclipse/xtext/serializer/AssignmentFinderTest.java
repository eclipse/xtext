/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef;
import org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef;
import org.eclipse.xtext.serializer.assignmentFinderTest.EnumBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal;
import org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.KeywordVal;
import org.eclipse.xtext.serializer.assignmentFinderTest.MixedBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.Model;
import org.eclipse.xtext.serializer.assignmentFinderTest.TerminalBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.TerminalVal;
import org.eclipse.xtext.serializer.sequencer.IAssignmentFinder;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.ContainmentRefElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.CrossRefElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.EnumBoolElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.EnumValElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.KeywordBoolElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.KeywordValElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.MixedBoolElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.TerminalBoolElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.TerminalValElements;

import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AssignmentFinderTest extends AbstractXtextTests {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(AssignmentFinderTestLanguageStandaloneSetup.class);
		getInjector().injectMembers(this);
	}

	@Inject
	private ParseHelper<Model> parser;

	@Inject
	private IAssignmentFinder finder;

	@Inject
	private AssignmentFinderTestLanguageGrammarAccess grammar;

	private String findAssignments(EObject obj, Object value, AbstractElement... assignments) {
		List<AbstractElement> ass = Lists.newArrayList(assignments);
		Iterable<AbstractElement> found = finder.findAssignmentsByValue(obj, ass, value, null);
		return Joiner.on(", ").join(Iterables.transform(found, new GrammarElementTitleSwitch().showAssignments()));
	}

	public void testKeywordVal1() throws Exception {
		KeywordValElements g = grammar.getKeywordValAccess();
		KeywordVal model = parser.parse("#0 kw1").getKeywordVal();
		String ass = findAssignments(model, model.getKw(), g.getKwKw1Keyword_0_0(), g.getKwKw2Keyword_1_0());
		assertEquals("kw='kw1'", ass);
	}

	public void testKeywordVal2() throws Exception {
		KeywordValElements g = grammar.getKeywordValAccess();
		KeywordVal model = parser.parse("#0 kw2").getKeywordVal();
		String ass = findAssignments(model, model.getKw(), g.getKwKw1Keyword_0_0(), g.getKwKw2Keyword_1_0());
		assertEquals("kw='kw2'", ass);
	}

	public void testTerminalVal1() throws Exception {
		TerminalValElements g = grammar.getTerminalValAccess();
		TerminalVal model = parser.parse("#1 %BAR").getTerminalVal();
		String ass = findAssignments(model, model.getTerm(), g.getTermTerminal1TerminalRuleCall_0_0(),
				g.getTermTerminal2TerminalRuleCall_1_0(), g.getTermFooKeyword_2_0());
		assertEquals("term=Terminal1", ass);
	}

	public void testTerminalVal2() throws Exception {
		TerminalValElements g = grammar.getTerminalValAccess();
		TerminalVal model = parser.parse("#1 %bar").getTerminalVal();
		String ass = findAssignments(model, model.getTerm(), g.getTermTerminal1TerminalRuleCall_0_0(),
				g.getTermTerminal2TerminalRuleCall_1_0(), g.getTermFooKeyword_2_0());
		assertEquals("term=Terminal2", ass);
	}

	public void testTerminalVal3() throws Exception {
		TerminalValElements g = grammar.getTerminalValAccess();
		TerminalVal model = parser.parse("#1 %foo").getTerminalVal();
		String ass = findAssignments(model, model.getTerm(), g.getTermTerminal1TerminalRuleCall_0_0(),
				g.getTermTerminal2TerminalRuleCall_1_0(), g.getTermFooKeyword_2_0());
		assertEquals("term='%foo'", ass);
	}

	public void testEnumVal1() throws Exception {
		EnumValElements g = grammar.getEnumValAccess();
		EnumVal model = parser.parse("#2 lit1").getEnumVal();
		String ass = findAssignments(model, model.getEn(), g.getEnEnum1EnumRuleCall_0_0(),
				g.getEnEnum2EnumRuleCall_1_0());
		assertEquals("en=Enum1", ass);
	}

	public void testEnumVal2() throws Exception {
		EnumValElements g = grammar.getEnumValAccess();
		EnumVal model = parser.parse("#2 lit2").getEnumVal();
		String ass = findAssignments(model, model.getEn(), g.getEnEnum1EnumRuleCall_0_0(),
				g.getEnEnum2EnumRuleCall_1_0());
		assertEquals("en=Enum2", ass);
	}

	public void testKeywordBool() throws Exception {
		KeywordBoolElements g = grammar.getKeywordBoolAccess();
		KeywordBool model = parser.parse("#3 kw1").getKeywordBool();
		String ass = findAssignments(model, model.isKw(), g.getKwKw1Keyword_0_0(), g.getKwKw2Keyword_1_0());
		assertEquals("kw?='kw1', kw?='kw2'", ass);
	}

	public void testTerminalBool() throws Exception {
		TerminalBoolElements g = grammar.getTerminalBoolAccess();
		TerminalBool model = parser.parse("#4 %BAR").getTerminalBool();
		String ass = findAssignments(model, model.isTerm(), g.getTermTerminal1TerminalRuleCall_0_0(),
				g.getTermTerminal2TerminalRuleCall_1_0(), g.getTermFooKeyword_2_0());
		assertEquals("term?=Terminal1, term?=Terminal2, term?='%foo'", ass);
	}

	public void testEnumBool() throws Exception {
		EnumBoolElements g = grammar.getEnumBoolAccess();
		EnumBool model = parser.parse("#5 lit1").getEnumBool();
		String ass = findAssignments(model, model.isEn(), g.getEnEnum1EnumRuleCall_0_0(),
				g.getEnEnum2EnumRuleCall_1_0());
		assertEquals("en?=Enum1, en?=Enum2", ass);
	}

	public void testMixedBool1() throws Exception {
		MixedBoolElements g = grammar.getMixedBoolAccess();
		MixedBool model = parser.parse("#6 true").getMixedBool();
		String ass = findAssignments(model, model.isVal(), g.getValKw1Keyword_0_0(),
				g.getValBooleanParserRuleCall_1_0());
		assertEquals("val?='kw1', val=Boolean", ass);
	}

	public void testMixedBool2() throws Exception {
		MixedBoolElements g = grammar.getMixedBoolAccess();
		MixedBool model = parser.parse("#6 false").getMixedBool();
		String ass = findAssignments(model, model.isVal(), g.getValKw1Keyword_0_0(),
				g.getValBooleanParserRuleCall_1_0());
		assertEquals("val=Boolean", ass);
	}

	public void testContainmentRef1() throws Exception {
		ContainmentRefElements g = grammar.getContainmentRefAccess();
		ContainmentRef model = parser.parse("#7 kw1 foo").getContainmentRef();
		String ass = findAssignments(model, model.getCtx(), g.getCtxContainmentRef1ParserRuleCall_0_0(),
				g.getCtxContainmentRef2ParserRuleCall_1_0());
		assertEquals("ctx=ContainmentRef1", ass);
	}

	public void testContainmentRef2() throws Exception {
		ContainmentRefElements g = grammar.getContainmentRefAccess();
		ContainmentRef model = parser.parse("#7 kw2 foo").getContainmentRef();
		String ass = findAssignments(model, model.getCtx(), g.getCtxContainmentRef1ParserRuleCall_0_0(),
				g.getCtxContainmentRef2ParserRuleCall_1_0());
		assertEquals("ctx=ContainmentRef2", ass);
	}

	public void testCrossRef1() throws Exception {
		CrossRefElements g = grammar.getCrossRefAccess();
		CrossRef model = parser.parse("#8 %BAR %BAR").getCrossRef();
		String ass = findAssignments(model, model.getCrossRef(),
				g.getCrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1(),
				g.getCrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1());
		assertEquals("crossRef=[CrossRef|Terminal1]", ass);
	}

	public void testCrossRef2() throws Exception {
		CrossRefElements g = grammar.getCrossRefAccess();
		CrossRef model = parser.parse("#8 %bar %bar").getCrossRef();
		String ass = findAssignments(model, model.getCrossRef(),
				g.getCrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1(),
				g.getCrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1());
		assertEquals("crossRef=[CrossRef|Terminal2]", ass);
	}
}
