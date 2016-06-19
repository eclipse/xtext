/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.analysis.GrammarElementDeclarationOrder;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.assignmentFinderTest.ContainmentRef;
import org.eclipse.xtext.serializer.assignmentFinderTest.CrossRef;
import org.eclipse.xtext.serializer.assignmentFinderTest.EnumBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.EnumVal;
import org.eclipse.xtext.serializer.assignmentFinderTest.KeywordBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.KeywordVal;
import org.eclipse.xtext.serializer.assignmentFinderTest.MixedBool;
import org.eclipse.xtext.serializer.assignmentFinderTest.MixedValue;
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
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.MixedValueElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.TerminalBoolElements;
import org.eclipse.xtext.serializer.services.AssignmentFinderTestLanguageGrammarAccess.TerminalValElements;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AssignmentFinderTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
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
		AbstractElement element = (AbstractElement) NodeModelUtils.getNode(obj).getGrammarElement();
		ISerializationContext ctx = SerializationContext.forChild(null, element, obj);
		Multimap<AbstractElement, ISerializationContext> ass = ArrayListMultimap.create();
		for (AbstractElement e : assignments)
			ass.put(e, ctx);
		List<AbstractElement> found = Lists.newArrayList(finder.findAssignmentsByValue(obj, ass, value, null));
		Collections.sort(found, GrammarElementDeclarationOrder.get(GrammarUtil.getGrammar(assignments[0])));
		return Joiner.on(", ").join(Iterables.transform(found, new GrammarElementTitleSwitch().showAssignments()));
	}

	@Test
	public void testKeywordVal1() throws Exception {
		KeywordValElements g = grammar.getKeywordValAccess();
		KeywordVal model = parser.parse("#00 kw1").getKeywordVal();
		String ass = findAssignments(model, model.getKw(), g.getKwKw1Keyword_0_0(), g.getKwKw2Keyword_1_0());
		assertEquals("kw='kw1'", ass);
	}

	@Test
	public void testKeywordVal2() throws Exception {
		KeywordValElements g = grammar.getKeywordValAccess();
		KeywordVal model = parser.parse("#00 kw2").getKeywordVal();
		String ass = findAssignments(model, model.getKw(), g.getKwKw1Keyword_0_0(), g.getKwKw2Keyword_1_0());
		assertEquals("kw='kw2'", ass);
	}

	@Test
	public void testTerminalVal1() throws Exception {
		TerminalValElements g = grammar.getTerminalValAccess();
		TerminalVal model = parser.parse("#01 %BAR").getTerminalVal();
		String ass = findAssignments(model, model.getTerm(), g.getTermTerminal1TerminalRuleCall_0_0(),
				g.getTermTerminal2TerminalRuleCall_1_0(), g.getTermFooKeyword_2_0());
		assertEquals("term=Terminal1", ass);
	}

	@Test
	public void testTerminalVal2() throws Exception {
		TerminalValElements g = grammar.getTerminalValAccess();
		TerminalVal model = parser.parse("#01 %bar").getTerminalVal();
		String ass = findAssignments(model, model.getTerm(), g.getTermTerminal1TerminalRuleCall_0_0(),
				g.getTermTerminal2TerminalRuleCall_1_0(), g.getTermFooKeyword_2_0());
		assertEquals("term=Terminal2", ass);
	}

	@Test
	public void testTerminalVal3() throws Exception {
		TerminalValElements g = grammar.getTerminalValAccess();
		TerminalVal model = parser.parse("#01 %foo").getTerminalVal();
		String ass = findAssignments(model, model.getTerm(), g.getTermTerminal1TerminalRuleCall_0_0(),
				g.getTermTerminal2TerminalRuleCall_1_0(), g.getTermFooKeyword_2_0());
		assertEquals("term='%foo'", ass);
	}

	@Test
	public void testEnumVal1() throws Exception {
		EnumValElements g = grammar.getEnumValAccess();
		EnumVal model = parser.parse("#02 lit1").getEnumVal();
		String ass = findAssignments(model, model.getEn(), g.getEnEnum1EnumRuleCall_0_0(),
				g.getEnEnum2EnumRuleCall_1_0());
		assertEquals("en=Enum1", ass);
	}

	@Test
	public void testEnumVal2() throws Exception {
		EnumValElements g = grammar.getEnumValAccess();
		EnumVal model = parser.parse("#02 lit2").getEnumVal();
		String ass = findAssignments(model, model.getEn(), g.getEnEnum1EnumRuleCall_0_0(),
				g.getEnEnum2EnumRuleCall_1_0());
		assertEquals("en=Enum2", ass);
	}

	@Test
	public void testKeywordBool() throws Exception {
		KeywordBoolElements g = grammar.getKeywordBoolAccess();
		KeywordBool model = parser.parse("#03 kw1").getKeywordBool();
		String ass = findAssignments(model, model.isKw(), g.getKwKw1Keyword_0_0(), g.getKwKw2Keyword_1_0());
		assertEquals("kw?='kw1', kw?='kw2'", ass);
	}

	@Test
	public void testTerminalBool() throws Exception {
		TerminalBoolElements g = grammar.getTerminalBoolAccess();
		TerminalBool model = parser.parse("#04 %BAR").getTerminalBool();
		String ass = findAssignments(model, model.isTerm(), g.getTermTerminal1TerminalRuleCall_0_0(),
				g.getTermTerminal2TerminalRuleCall_1_0(), g.getTermFooKeyword_2_0());
		assertEquals("term?=Terminal1, term?=Terminal2, term?='%foo'", ass);
	}

	@Test
	public void testEnumBool() throws Exception {
		EnumBoolElements g = grammar.getEnumBoolAccess();
		EnumBool model = parser.parse("#05 lit1").getEnumBool();
		String ass = findAssignments(model, model.isEn(), g.getEnEnum1EnumRuleCall_0_0(),
				g.getEnEnum2EnumRuleCall_1_0());
		assertEquals("en?=Enum1, en?=Enum2", ass);
	}

	@Test
	public void testMixedBool1() throws Exception {
		MixedBoolElements g = grammar.getMixedBoolAccess();
		MixedBool model = parser.parse("#06 true").getMixedBool();
		String ass = findAssignments(model, model.isVal(), g.getValKw1Keyword_0_0(),
				g.getValBooleanParserRuleCall_1_0());
		assertEquals("val?='kw1', val=Boolean", ass);
	}

	@Test
	public void testMixedBool2() throws Exception {
		MixedBoolElements g = grammar.getMixedBoolAccess();
		MixedBool model = parser.parse("#06 false").getMixedBool();
		String ass = findAssignments(model, model.isVal(), g.getValKw1Keyword_0_0(),
				g.getValBooleanParserRuleCall_1_0());
		assertEquals("val=Boolean", ass);
	}

	@Test
	public void testMixedValue1() throws Exception {
		MixedValueElements g = grammar.getMixedValueAccess();
		MixedValue model = parser.parse("#07 lit1").getMixedValue();
		String ass = findAssignments(model, model.getVal(), g.getValDatEnumParserRuleCall_1_0(),
				g.getValEnum1EnumRuleCall_0_0());
		assertEquals("val=Enum1", ass);
	}

	@Test
	public void testMixedValue2() throws Exception {
		MixedValueElements g = grammar.getMixedValueAccess();
		MixedValue model = parser.parse("#07 lit3").getMixedValue();
		String ass = findAssignments(model, model.getVal(), g.getValDatEnumParserRuleCall_1_0(),
				g.getValEnum1EnumRuleCall_0_0());
		assertEquals("val=DatEnum", ass);
	}

	@Test
	public void testContainmentRef1() throws Exception {
		ContainmentRefElements g = grammar.getContainmentRefAccess();
		ContainmentRef model = parser.parse("#08 kw1 foo").getContainmentRef();
		String ass = findAssignments(model, model.getCtx(), g.getCtxContainmentRef1ParserRuleCall_0_0(),
				g.getCtxContainmentRef2ParserRuleCall_1_0());
		assertEquals("ctx=ContainmentRef1", ass);
	}

	@Test
	public void testContainmentRef2() throws Exception {
		ContainmentRefElements g = grammar.getContainmentRefAccess();
		ContainmentRef model = parser.parse("#08 kw2 foo").getContainmentRef();
		String ass = findAssignments(model, model.getCtx(), g.getCtxContainmentRef1ParserRuleCall_0_0(),
				g.getCtxContainmentRef2ParserRuleCall_1_0());
		assertEquals("ctx=ContainmentRef2", ass);
	}

	@Test
	public void testCrossRef1() throws Exception {
		CrossRefElements g = grammar.getCrossRefAccess();
		CrossRef model = parser.parse("#09 %BAR %BAR").getCrossRef();
		String ass = findAssignments(model, model.getCrossRef(),
				g.getCrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1(),
				g.getCrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1());
		assertEquals("crossRef=[CrossRef|Terminal1]", ass);
	}

	@Test
	public void testCrossRef2() throws Exception {
		CrossRefElements g = grammar.getCrossRefAccess();
		CrossRef model = parser.parse("#09 %bar %bar").getCrossRef();
		String ass = findAssignments(model, model.getCrossRef(),
				g.getCrossRefCrossRefTerminal1TerminalRuleCall_1_0_0_1(),
				g.getCrossRefCrossRefTerminal2TerminalRuleCall_1_1_0_1());
		assertEquals("crossRef=[CrossRef|Terminal2]", ass);
	}
}
