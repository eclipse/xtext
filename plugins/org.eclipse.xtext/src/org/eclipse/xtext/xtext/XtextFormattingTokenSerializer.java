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
import org.eclipse.xtext.services.XtextGrammarAccess.AbstractTokenElements;
import org.eclipse.xtext.services.XtextGrammarAccess.ActionElements;
import org.eclipse.xtext.services.XtextGrammarAccess.AlternativesElements;
import org.eclipse.xtext.services.XtextGrammarAccess.AssignmentElements;
import org.eclipse.xtext.services.XtextGrammarAccess.CrossReferenceElements;
import org.eclipse.xtext.services.XtextGrammarAccess.GrammarElements;
import org.eclipse.xtext.services.XtextGrammarAccess.LexerRuleElements;
import org.eclipse.xtext.services.XtextGrammarAccess.ParenthesizedElementElements;
import org.eclipse.xtext.services.XtextGrammarAccess.ParserRuleElements;

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
		cfg.setLinewrap(2).after(gr.ele00Group());
		cfg.setLinewrap(2).after(gr.ele01AssignmentMetamodelDeclarations());
		cfg.setLinewrap(2).after(gr.ele1AssignmentRules());

		// ParserRule
		ParserRuleElements pr = g.prParserRule();
		cfg.setLinewrap().after(pr.ele001KeywordColon());
		cfg.setIndentation(pr.ele001KeywordColon(), pr.ele1KeywordSemicolon());
		cfg.setNoSpace().before(pr.ele001KeywordColon());
		cfg.setNoSpace().before(pr.ele1KeywordSemicolon());

		// LexerRule
		LexerRuleElements lr = g.prLexerRule();
		cfg.setLinewrap().after(lr.ele001KeywordColon());
		cfg.setIndentation(lr.ele001KeywordColon(), lr.ele1KeywordSemicolon());
		cfg.setNoSpace().before(lr.ele001KeywordColon());
		cfg.setNoSpace().before(lr.ele1KeywordSemicolon());

		// Assignment
		AssignmentElements as = g.prAssignment();
		cfg.setNoSpace().around(as.ele01AssignmentOperator());

		// AbstractToken
		AbstractTokenElements at = g.prAbstractToken();
		cfg.setNoSpace().before(at.ele1AssignmentCardinality());

		// ParenthesizedElement
		ParenthesizedElementElements pe = g.prParenthesizedElement();
		cfg.setNoSpace().after(pe.ele00KeywordLeftParenthesis());
		cfg.setNoSpace().before(pe.ele1KeywordRightParenthesis());

		// CrossReference
		CrossReferenceElements cr = g.prCrossReference();
		cfg.setNoSpace().after(cr.ele000KeywordLeftSquareBracket());
		cfg.setNoSpace().before(cr.ele1KeywordRightSquareBracket());
		cfg.setNoSpace().around(cr.ele010KeywordVerticalLine());

		// Alternatives
		AlternativesElements al = g.prAlternatives();
		cfg.setNoSpace().around(al.ele101KeywordVerticalLine());

		// Action
		ActionElements ac = g.prAction();
		cfg.setNoSpace().around(ac.ele001AssignmentOperator());
		cfg.setNoSpace().around(ac.ele00001KeywordFullStop());
		cfg.setNoSpace().after(ac.ele0000000KeywordLeftCurlyBracket());
		cfg.setNoSpace().before(ac.ele1KeywordRightCurlyBracket());
		cfg.setNoSpace().around(ac.ele00000011KeywordEqualsSign());
	}

}
