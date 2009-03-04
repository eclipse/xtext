/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.parsetree.reconstr.impl.FormattingConfig;
import org.eclipse.xtext.parsetree.reconstr.impl.FormattingTokenSerializer;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.AbstractTokenWithCardinalityElements;
import org.eclipse.xtext.services.XtextGrammarAccess.ActionElements;
import org.eclipse.xtext.services.XtextGrammarAccess.AlternativesElements;
import org.eclipse.xtext.services.XtextGrammarAccess.AssignmentElements;
import org.eclipse.xtext.services.XtextGrammarAccess.CrossReferenceElements;
import org.eclipse.xtext.services.XtextGrammarAccess.GrammarElements;
import org.eclipse.xtext.services.XtextGrammarAccess.ParenthesizedElementElements;
import org.eclipse.xtext.services.XtextGrammarAccess.ParserRuleElements;
import org.eclipse.xtext.services.XtextGrammarAccess.TerminalRuleElements;
import org.eclipse.xtext.services.XtextGrammarAccess.TypeRefElements;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextFormattingTokenSerializer extends FormattingTokenSerializer {

	@Inject
	public XtextFormattingTokenSerializer(XtextGrammarAccess grammarAccess) {
		super(grammarAccess);
	}

	@Override
	protected void configureFormatting(FormattingConfig cfg) {
		XtextGrammarAccess g = (XtextGrammarAccess) getGrammarAccess();

		// Grammar
		GrammarElements gr = g.prGrammar();
		cfg.setLinewrap(2).after(gr.ele2Group());
		cfg.setLinewrap(2).after(gr.ele4AssignmentMetamodelDeclarations());
		cfg.setLinewrap(2).after(gr.ele5AssignmentRules());

		// ParserRule
		ParserRuleElements pr = g.prParserRule();
		cfg.setLinewrap().after(pr.ele3KeywordColon());
		cfg.setIndentation(pr.ele3KeywordColon(), pr.ele5KeywordSemicolon());
		cfg.setNoSpace().before(pr.ele3KeywordColon());
		cfg.setNoSpace().before(pr.ele5KeywordSemicolon());

		// TerminalRule
		TerminalRuleElements tr = g.prTerminalRule();
		cfg.setLinewrap().after(tr.ele3KeywordColon());
		cfg.setIndentation(tr.ele3KeywordColon(), tr.ele5KeywordSemicolon());
		cfg.setNoSpace().before(tr.ele3KeywordColon());
		cfg.setNoSpace().before(tr.ele5KeywordSemicolon());

		// Assignment
		AssignmentElements as = g.prAssignment();
		cfg.setNoSpace().around(as.ele1AssignmentOperator());

		// AbstractToken
		AbstractTokenWithCardinalityElements at = g.prAbstractTokenWithCardinality();
		cfg.setNoSpace().before(at.ele1AssignmentCardinality());

		// ParenthesizedElement
		ParenthesizedElementElements pe = g.prParenthesizedElement();
		cfg.setNoSpace().after(pe.ele0KeywordLeftParenthesis());
		cfg.setNoSpace().before(pe.ele2KeywordRightParenthesis());

		// CrossReference
		CrossReferenceElements cr = g.prCrossReference();
		cfg.setNoSpace().after(cr.ele0KeywordLeftSquareBracket());
		cfg.setNoSpace().before(cr.ele3KeywordRightSquareBracket());
		cfg.setNoSpace().around(cr.ele20KeywordVerticalLine());

		// Alternatives
		AlternativesElements al = g.prAlternatives();
		cfg.setNoSpace().around(al.ele110KeywordVerticalLine());

		// Action
		ActionElements ac = g.prAction();
		cfg.setNoSpace().around(ac.ele22AssignmentOperator());
		cfg.setNoSpace().around(ac.ele20KeywordFullStop());
		cfg.setNoSpace().after(ac.ele0KeywordLeftCurlyBracket());
		cfg.setNoSpace().before(ac.ele3KeywordRightCurlyBracket());
		cfg.setNoSpace().around(ac.ele2200KeywordEqualsSign());
		cfg.setNoSpace().around(ac.ele2201KeywordPlusSignEqualsSign());

		TypeRefElements typeRef = g.prTypeRef();
		cfg.setNoSpace().around(typeRef.ele01KeywordColonColon());
	}

}
