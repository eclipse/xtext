/*******************************************************************************
 * Copyright (c) 2008, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.AbstractTokenWithCardinalityElements;
import org.eclipse.xtext.services.XtextGrammarAccess.ActionElements;
import org.eclipse.xtext.services.XtextGrammarAccess.AnnotationElements;
import org.eclipse.xtext.services.XtextGrammarAccess.AssignmentElements;
import org.eclipse.xtext.services.XtextGrammarAccess.CharacterRangeElements;
import org.eclipse.xtext.services.XtextGrammarAccess.CrossReferenceElements;
import org.eclipse.xtext.services.XtextGrammarAccess.EnumLiteralDeclarationElements;
import org.eclipse.xtext.services.XtextGrammarAccess.GrammarElements;
import org.eclipse.xtext.services.XtextGrammarAccess.NamedArgumentElements;
import org.eclipse.xtext.services.XtextGrammarAccess.NegatedTokenElements;
import org.eclipse.xtext.services.XtextGrammarAccess.NegationElements;
import org.eclipse.xtext.services.XtextGrammarAccess.ParserRuleElements;
import org.eclipse.xtext.services.XtextGrammarAccess.RuleCallElements;
import org.eclipse.xtext.services.XtextGrammarAccess.TerminalTokenElements;
import org.eclipse.xtext.services.XtextGrammarAccess.TypeRefElements;
import org.eclipse.xtext.services.XtextGrammarAccess.UnorderedGroupElements;
import org.eclipse.xtext.services.XtextGrammarAccess.UntilTokenElements;
import org.eclipse.xtext.util.Pair;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig cfg) {
		XtextGrammarAccess g = (XtextGrammarAccess) getGrammarAccess();

		cfg.setAutoLinewrap(120);

		// Comments 
		cfg.setLinewrap(0, 1, 2).before(g.getSL_COMMENTRule());
		cfg.setLinewrap(0, 1, 2).before(g.getML_COMMENTRule());
		cfg.setLinewrap(0, 1, 1).after(g.getML_COMMENTRule());

		// general keywords
		for (Pair<Keyword, Keyword> pair : g.findKeywordPairs("(", ")")) {
			cfg.setNoSpace().after(pair.getFirst());
			cfg.setNoSpace().before(pair.getSecond());
		}
		for (Pair<Keyword, Keyword> pair : g.findKeywordPairs("[", "]")) {
			cfg.setNoSpace().after(pair.getFirst());
			cfg.setNoSpace().before(pair.getSecond());
		}
		for (Pair<Keyword, Keyword> pair : g.findKeywordPairs("<", ">")) {
			cfg.setNoSpace().after(pair.getFirst());
			cfg.setNoSpace().before(pair.getSecond());
		}
		for (Keyword comma : g.findKeywords(",")) {
			cfg.setNoSpace().before(comma);
		}
		for (Pair<Keyword, Keyword> pair : g.findKeywordPairs(":", ";")) {
			cfg.setNoSpace().before(pair.getFirst());
			cfg.setNoSpace().before(pair.getSecond());
			cfg.setLinewrap().after(pair.getFirst());
			cfg.setLinewrap().after(pair.getSecond());
			cfg.setIndentation(pair.getFirst(), pair.getSecond());
			cfg.setLinewrap(0, 0, 1).range(pair.getFirst(), pair.getSecond());
		}

		// Grammar
		GrammarElements gr = g.getGrammarAccess();
		cfg.setNoLinewrap().between(gr.getWithKeyword_2_0(), gr.getUsedGrammarsAssignment_2_1());
		cfg.setNoSpace().between(gr.getDefinesHiddenTokensAssignment_3_0(), gr.getLeftParenthesisKeyword_3_1());
		cfg.setLinewrap(2).between(gr.getNameAssignment_1(), gr.getMetamodelDeclarationsAssignment_4());
		cfg.setLinewrap(2).between(gr.getGroup_2(), gr.getMetamodelDeclarationsAssignment_4());
		cfg.setLinewrap(2).between(gr.getGroup_3(), gr.getMetamodelDeclarationsAssignment_4());
		cfg.setLinewrap().after(gr.getMetamodelDeclarationsAssignment_4());
		cfg.setLinewrap(2).between(gr.getMetamodelDeclarationsAssignment_4(), gr.getRulesAssignment_5());
		cfg.setLinewrap(2).before(gr.getRulesAssignment_5());

		// ParserRule
		ParserRuleElements pr = g.getParserRuleAccess();
		cfg.setNoSpace().before(pr.getLeftParenthesisKeyword_2_1());

		// TypeRef
		TypeRefElements typeRef = g.getTypeRefAccess();
		cfg.setNoSpace().around(typeRef.getColonColonKeyword_0_1());

		// UnorderedGroup
		UnorderedGroupElements uge = g.getUnorderedGroupAccess();
		cfg.setNoSpace().around(uge.getUnorderedGroupElementsAction_1_0());

		// AbstractToken
		AbstractTokenWithCardinalityElements at = g.getAbstractTokenWithCardinalityAccess();
		cfg.setNoSpace().before(at.getCardinalityAsteriskKeyword_1_0_1());
		cfg.setNoSpace().before(at.getCardinalityPlusSignKeyword_1_0_2());
		cfg.setNoSpace().before(at.getCardinalityQuestionMarkKeyword_1_0_0());

		// Action
		ActionElements ac = g.getActionAccess();
		cfg.setNoSpace().around(ac.getOperatorAssignment_2_2());
		cfg.setNoSpace().around(ac.getFullStopKeyword_2_0());
		cfg.setNoSpace().after(ac.getLeftCurlyBracketKeyword_0());
		cfg.setNoSpace().before(ac.getRightCurlyBracketKeyword_3());

		// Assignment
		AssignmentElements as = g.getAssignmentAccess();
		cfg.setNoSpace().around(as.getOperatorAssignment_2());

		// CrossReference
		CrossReferenceElements cr = g.getCrossReferenceAccess();
		cfg.setNoSpace().around(cr.getVerticalLineKeyword_2_0());

		// TerminalToken
		TerminalTokenElements tt = g.getTerminalTokenAccess();
		cfg.setNoSpace().before(tt.getCardinalityAssignment_1());

		// NegatedToken
		NegatedTokenElements ne = g.getNegatedTokenAccess();
		cfg.setNoSpace().after(ne.getExclamationMarkKeyword_0());

		// UntilToken
		UntilTokenElements ut = g.getUntilTokenAccess();
		cfg.setNoSpace().around(ut.getHyphenMinusGreaterThanSignKeyword_0());

		// CharacterRange
		CharacterRangeElements cre = g.getCharacterRangeAccess();
		cfg.setNoSpace().around(cre.getFullStopFullStopKeyword_1_1());

		// EnumLiteralDeclaration
		EnumLiteralDeclarationElements eld = g.getEnumLiteralDeclarationAccess();
		cfg.setNoSpace().around(eld.getEqualsSignKeyword_1_0());
		
		// GuardCondition
		NegationElements na = g.getNegationAccess();
		cfg.setNoSpace().after(na.getExclamationMarkKeyword_1_1());
		
		// RuleCall
		RuleCallElements rca = g.getRuleCallAccess();
		cfg.setNoSpace().before(rca.getLessThanSignKeyword_1_0());
		
		// NamedArgument
		NamedArgumentElements naa = g.getNamedArgumentAccess();
		cfg.setNoSpace().around(naa.getCalledByNameAssignment_0_1());
		cfg.setNoSpace().around(naa.getValueAssignment_1());
		cfg.setNoSpace().around(naa.getParameterAssignment_0_0());
		
		// @Override
		AnnotationElements a = g.getAnnotationAccess();
		cfg.setNoSpace().between(a.getCommercialAtKeyword_0(), a.getNameAssignment_1());
		cfg.setLinewrap().after(g.getAnnotationRule());
		cfg.setLinewrap(2).before(g.getAnnotationRule());

		//saveDebugGraphvizDiagram("XtextFormatting.dot");
	}

}
