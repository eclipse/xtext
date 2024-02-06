/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.contentassist.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class ContentAssistNoTerminalExtensionTestLanguageGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class PolygonBasedShapeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistNoTerminalExtensionTestLanguage.PolygonBasedShape");
		private final Assignment cShapeAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cShapePolygonBasedNodeShapeEnumRuleCall_0 = (RuleCall)cShapeAssignment.eContents().get(0);
		
		//PolygonBasedShape:
		//    shape += PolygonBasedNodeShape+;
		@Override public ParserRule getRule() { return rule; }
		
		//shape += PolygonBasedNodeShape+
		public Assignment getShapeAssignment() { return cShapeAssignment; }
		
		//PolygonBasedNodeShape
		public RuleCall getShapePolygonBasedNodeShapeEnumRuleCall_0() { return cShapePolygonBasedNodeShapeEnumRuleCall_0; }
	}
	
	public class PolygonBasedNodeShapeElements extends AbstractElementFinder.AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistNoTerminalExtensionTestLanguage.PolygonBasedNodeShape");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final EnumLiteralDeclaration cOctagonEnumLiteralDeclaration_0 = (EnumLiteralDeclaration)cAlternatives.eContents().get(0);
		private final Keyword cOctagonOctagonKeyword_0_0 = (Keyword)cOctagonEnumLiteralDeclaration_0.eContents().get(0);
		private final EnumLiteralDeclaration cOvalEnumLiteralDeclaration_1 = (EnumLiteralDeclaration)cAlternatives.eContents().get(1);
		private final Keyword cOvalOvalKeyword_1_0 = (Keyword)cOvalEnumLiteralDeclaration_1.eContents().get(0);
		private final EnumLiteralDeclaration cParallelogramEnumLiteralDeclaration_2 = (EnumLiteralDeclaration)cAlternatives.eContents().get(2);
		private final Keyword cParallelogramParallelogramKeyword_2_0 = (Keyword)cParallelogramEnumLiteralDeclaration_2.eContents().get(0);
		private final EnumLiteralDeclaration cPentagonEnumLiteralDeclaration_3 = (EnumLiteralDeclaration)cAlternatives.eContents().get(3);
		private final Keyword cPentagonPentagonKeyword_3_0 = (Keyword)cPentagonEnumLiteralDeclaration_3.eContents().get(0);
		private final EnumLiteralDeclaration cPlainEnumLiteralDeclaration_4 = (EnumLiteralDeclaration)cAlternatives.eContents().get(4);
		private final Keyword cPlainPlainKeyword_4_0 = (Keyword)cPlainEnumLiteralDeclaration_4.eContents().get(0);
		private final EnumLiteralDeclaration cPlaintextEnumLiteralDeclaration_5 = (EnumLiteralDeclaration)cAlternatives.eContents().get(5);
		private final Keyword cPlaintextPlaintextKeyword_5_0 = (Keyword)cPlaintextEnumLiteralDeclaration_5.eContents().get(0);
		private final EnumLiteralDeclaration cPointEnumLiteralDeclaration_6 = (EnumLiteralDeclaration)cAlternatives.eContents().get(6);
		private final Keyword cPointPointKeyword_6_0 = (Keyword)cPointEnumLiteralDeclaration_6.eContents().get(0);
		private final EnumLiteralDeclaration cPolygonEnumLiteralDeclaration_7 = (EnumLiteralDeclaration)cAlternatives.eContents().get(7);
		private final Keyword cPolygonPolygonKeyword_7_0 = (Keyword)cPolygonEnumLiteralDeclaration_7.eContents().get(0);
		private final EnumLiteralDeclaration cPrimersiteEnumLiteralDeclaration_8 = (EnumLiteralDeclaration)cAlternatives.eContents().get(8);
		private final Keyword cPrimersitePrimersiteKeyword_8_0 = (Keyword)cPrimersiteEnumLiteralDeclaration_8.eContents().get(0);
		private final EnumLiteralDeclaration cPromoterEnumLiteralDeclaration_9 = (EnumLiteralDeclaration)cAlternatives.eContents().get(9);
		private final Keyword cPromoterPromoterKeyword_9_0 = (Keyword)cPromoterEnumLiteralDeclaration_9.eContents().get(0);
		private final EnumLiteralDeclaration cProteasesiteEnumLiteralDeclaration_10 = (EnumLiteralDeclaration)cAlternatives.eContents().get(10);
		private final Keyword cProteasesiteProteasesiteKeyword_10_0 = (Keyword)cProteasesiteEnumLiteralDeclaration_10.eContents().get(0);
		private final EnumLiteralDeclaration cProteinstabEnumLiteralDeclaration_11 = (EnumLiteralDeclaration)cAlternatives.eContents().get(11);
		private final Keyword cProteinstabProteinstabKeyword_11_0 = (Keyword)cProteinstabEnumLiteralDeclaration_11.eContents().get(0);
		private final EnumLiteralDeclaration cRarrowEnumLiteralDeclaration_12 = (EnumLiteralDeclaration)cAlternatives.eContents().get(12);
		private final Keyword cRarrowRarrowKeyword_12_0 = (Keyword)cRarrowEnumLiteralDeclaration_12.eContents().get(0);
		private final EnumLiteralDeclaration cRecordEnumLiteralDeclaration_13 = (EnumLiteralDeclaration)cAlternatives.eContents().get(13);
		private final Keyword cRecordRecordKeyword_13_0 = (Keyword)cRecordEnumLiteralDeclaration_13.eContents().get(0);
		private final EnumLiteralDeclaration cRectEnumLiteralDeclaration_14 = (EnumLiteralDeclaration)cAlternatives.eContents().get(14);
		private final Keyword cRectRectKeyword_14_0 = (Keyword)cRectEnumLiteralDeclaration_14.eContents().get(0);
		private final EnumLiteralDeclaration cRectangleEnumLiteralDeclaration_15 = (EnumLiteralDeclaration)cAlternatives.eContents().get(15);
		private final Keyword cRectangleRectangleKeyword_15_0 = (Keyword)cRectangleEnumLiteralDeclaration_15.eContents().get(0);
		private final EnumLiteralDeclaration cRestrictionsiteEnumLiteralDeclaration_16 = (EnumLiteralDeclaration)cAlternatives.eContents().get(16);
		private final Keyword cRestrictionsiteRestrictionsiteKeyword_16_0 = (Keyword)cRestrictionsiteEnumLiteralDeclaration_16.eContents().get(0);
		private final EnumLiteralDeclaration cRibositeEnumLiteralDeclaration_17 = (EnumLiteralDeclaration)cAlternatives.eContents().get(17);
		private final Keyword cRibositeRibositeKeyword_17_0 = (Keyword)cRibositeEnumLiteralDeclaration_17.eContents().get(0);
		private final EnumLiteralDeclaration cRnastabEnumLiteralDeclaration_18 = (EnumLiteralDeclaration)cAlternatives.eContents().get(18);
		private final Keyword cRnastabRnastabKeyword_18_0 = (Keyword)cRnastabEnumLiteralDeclaration_18.eContents().get(0);
		private final EnumLiteralDeclaration cRpromoterEnumLiteralDeclaration_19 = (EnumLiteralDeclaration)cAlternatives.eContents().get(19);
		private final Keyword cRpromoterRpromoterKeyword_19_0 = (Keyword)cRpromoterEnumLiteralDeclaration_19.eContents().get(0);
		
		//enum PolygonBasedNodeShape:
		//    octagon | oval |
		//    parallelogram | pentagon | plain | plaintext | point | polygon | primersite | promoter | proteasesite | proteinstab |
		//    rarrow | record | rect | rectangle | restrictionsite | ribosite | rnastab | rpromoter;
		public EnumRule getRule() { return rule; }
		
		//octagon | oval |
		//parallelogram | pentagon | plain | plaintext | point | polygon | primersite | promoter | proteasesite | proteinstab |
		//rarrow | record | rect | rectangle | restrictionsite | ribosite | rnastab | rpromoter
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//octagon
		public EnumLiteralDeclaration getOctagonEnumLiteralDeclaration_0() { return cOctagonEnumLiteralDeclaration_0; }
		
		public Keyword getOctagonOctagonKeyword_0_0() { return cOctagonOctagonKeyword_0_0; }
		
		//oval
		public EnumLiteralDeclaration getOvalEnumLiteralDeclaration_1() { return cOvalEnumLiteralDeclaration_1; }
		
		public Keyword getOvalOvalKeyword_1_0() { return cOvalOvalKeyword_1_0; }
		
		//parallelogram
		public EnumLiteralDeclaration getParallelogramEnumLiteralDeclaration_2() { return cParallelogramEnumLiteralDeclaration_2; }
		
		public Keyword getParallelogramParallelogramKeyword_2_0() { return cParallelogramParallelogramKeyword_2_0; }
		
		//pentagon
		public EnumLiteralDeclaration getPentagonEnumLiteralDeclaration_3() { return cPentagonEnumLiteralDeclaration_3; }
		
		public Keyword getPentagonPentagonKeyword_3_0() { return cPentagonPentagonKeyword_3_0; }
		
		//plain
		public EnumLiteralDeclaration getPlainEnumLiteralDeclaration_4() { return cPlainEnumLiteralDeclaration_4; }
		
		public Keyword getPlainPlainKeyword_4_0() { return cPlainPlainKeyword_4_0; }
		
		//plaintext
		public EnumLiteralDeclaration getPlaintextEnumLiteralDeclaration_5() { return cPlaintextEnumLiteralDeclaration_5; }
		
		public Keyword getPlaintextPlaintextKeyword_5_0() { return cPlaintextPlaintextKeyword_5_0; }
		
		//point
		public EnumLiteralDeclaration getPointEnumLiteralDeclaration_6() { return cPointEnumLiteralDeclaration_6; }
		
		public Keyword getPointPointKeyword_6_0() { return cPointPointKeyword_6_0; }
		
		//polygon
		public EnumLiteralDeclaration getPolygonEnumLiteralDeclaration_7() { return cPolygonEnumLiteralDeclaration_7; }
		
		public Keyword getPolygonPolygonKeyword_7_0() { return cPolygonPolygonKeyword_7_0; }
		
		//primersite
		public EnumLiteralDeclaration getPrimersiteEnumLiteralDeclaration_8() { return cPrimersiteEnumLiteralDeclaration_8; }
		
		public Keyword getPrimersitePrimersiteKeyword_8_0() { return cPrimersitePrimersiteKeyword_8_0; }
		
		//promoter
		public EnumLiteralDeclaration getPromoterEnumLiteralDeclaration_9() { return cPromoterEnumLiteralDeclaration_9; }
		
		public Keyword getPromoterPromoterKeyword_9_0() { return cPromoterPromoterKeyword_9_0; }
		
		//proteasesite
		public EnumLiteralDeclaration getProteasesiteEnumLiteralDeclaration_10() { return cProteasesiteEnumLiteralDeclaration_10; }
		
		public Keyword getProteasesiteProteasesiteKeyword_10_0() { return cProteasesiteProteasesiteKeyword_10_0; }
		
		//proteinstab
		public EnumLiteralDeclaration getProteinstabEnumLiteralDeclaration_11() { return cProteinstabEnumLiteralDeclaration_11; }
		
		public Keyword getProteinstabProteinstabKeyword_11_0() { return cProteinstabProteinstabKeyword_11_0; }
		
		//rarrow
		public EnumLiteralDeclaration getRarrowEnumLiteralDeclaration_12() { return cRarrowEnumLiteralDeclaration_12; }
		
		public Keyword getRarrowRarrowKeyword_12_0() { return cRarrowRarrowKeyword_12_0; }
		
		//record
		public EnumLiteralDeclaration getRecordEnumLiteralDeclaration_13() { return cRecordEnumLiteralDeclaration_13; }
		
		public Keyword getRecordRecordKeyword_13_0() { return cRecordRecordKeyword_13_0; }
		
		//rect
		public EnumLiteralDeclaration getRectEnumLiteralDeclaration_14() { return cRectEnumLiteralDeclaration_14; }
		
		public Keyword getRectRectKeyword_14_0() { return cRectRectKeyword_14_0; }
		
		//rectangle
		public EnumLiteralDeclaration getRectangleEnumLiteralDeclaration_15() { return cRectangleEnumLiteralDeclaration_15; }
		
		public Keyword getRectangleRectangleKeyword_15_0() { return cRectangleRectangleKeyword_15_0; }
		
		//restrictionsite
		public EnumLiteralDeclaration getRestrictionsiteEnumLiteralDeclaration_16() { return cRestrictionsiteEnumLiteralDeclaration_16; }
		
		public Keyword getRestrictionsiteRestrictionsiteKeyword_16_0() { return cRestrictionsiteRestrictionsiteKeyword_16_0; }
		
		//ribosite
		public EnumLiteralDeclaration getRibositeEnumLiteralDeclaration_17() { return cRibositeEnumLiteralDeclaration_17; }
		
		public Keyword getRibositeRibositeKeyword_17_0() { return cRibositeRibositeKeyword_17_0; }
		
		//rnastab
		public EnumLiteralDeclaration getRnastabEnumLiteralDeclaration_18() { return cRnastabEnumLiteralDeclaration_18; }
		
		public Keyword getRnastabRnastabKeyword_18_0() { return cRnastabRnastabKeyword_18_0; }
		
		//rpromoter
		public EnumLiteralDeclaration getRpromoterEnumLiteralDeclaration_19() { return cRpromoterEnumLiteralDeclaration_19; }
		
		public Keyword getRpromoterRpromoterKeyword_19_0() { return cRpromoterRpromoterKeyword_19_0; }
	}
	
	private final PolygonBasedShapeElements pPolygonBasedShape;
	private final PolygonBasedNodeShapeElements ePolygonBasedNodeShape;
	private final TerminalRule tWS;
	
	private final Grammar grammar;

	@Inject
	public ContentAssistNoTerminalExtensionTestLanguageGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pPolygonBasedShape = new PolygonBasedShapeElements();
		this.ePolygonBasedNodeShape = new PolygonBasedNodeShapeElements();
		this.tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistNoTerminalExtensionTestLanguage.WS");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.ui.tests.editor.contentassist.ContentAssistNoTerminalExtensionTestLanguage".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	

	
	//PolygonBasedShape:
	//    shape += PolygonBasedNodeShape+;
	public PolygonBasedShapeElements getPolygonBasedShapeAccess() {
		return pPolygonBasedShape;
	}
	
	public ParserRule getPolygonBasedShapeRule() {
		return getPolygonBasedShapeAccess().getRule();
	}
	
	//enum PolygonBasedNodeShape:
	//    octagon | oval |
	//    parallelogram | pentagon | plain | plaintext | point | polygon | primersite | promoter | proteasesite | proteinstab |
	//    rarrow | record | rect | rectangle | restrictionsite | ribosite | rnastab | rpromoter;
	public PolygonBasedNodeShapeElements getPolygonBasedNodeShapeAccess() {
		return ePolygonBasedNodeShape;
	}
	
	public EnumRule getPolygonBasedNodeShapeRule() {
		return getPolygonBasedNodeShapeAccess().getRule();
	}
	
	//terminal WS: (' ')+;
	public TerminalRule getWSRule() {
		return tWS;
	}
}
