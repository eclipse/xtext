package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;

public class FormattingTokenSerializerTestImpl extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		FormatterTestLanguageGrammarAccess f = (FormatterTestLanguageGrammarAccess) getGrammarAccess();
		
		c.setAutoLinewrap(30);

		// TestLinewrap
		c.setLinewrap().after(f.getTestLinewrapAccess().getLinewrapKeyword_0());
		
		// Line
		c.setLinewrap().after(f.getLineAccess().getSemicolonKeyword_1());
		c.setNoSpace().before(f.getLineAccess().getSemicolonKeyword_1());
		
		// TestIndentation
		c.setIndentation(f.getTestIndentationAccess().getLeftCurlyBracketKeyword_1(),
				f.getTestIndentationAccess().getRightCurlyBracketKeyword_3());
		c.setLinewrap().after(f.getTestIndentationAccess().getLeftCurlyBracketKeyword_1());
		c.setLinewrap().after(f.getTestIndentationAccess().getRightCurlyBracketKeyword_3());
		c.setLinewrap().after(f.getTestIndentationAccess().getSemiAssignment_4());
		c.setNoLinewrap().between(f.getTestIndentationAccess().getRightCurlyBracketKeyword_3(), 
				                  f.getTestIndentationAccess().getSemiAssignment_4());
		c.setNoSpace().before(f.getTestIndentationAccess().getSemiAssignment_4());
		
		// Assign
		c.setNoSpace().around(f.getAssignAccess().getOpAssignment_1());
		c.setNoSpace().before(f.getAssignAccess().getCommaKeyword_3_1_0());
		
		// Meth
		c.setNoSpace().around(f.getMethAccess().getLeftParenthesisKeyword_2());
		c.setNoSpace().before(f.getMethAccess().getRightParenthesisKeyword_4());
		c.setNoSpace().before(f.getMethAccess().getCommaKeyword_3_1_0());
		c.setNoLinewrap().before(f.getMethAccess().getCommaKeyword_3_1_0());
		c.setIndentation(f.getMethAccess().getLeftParenthesisKeyword_2(), 
						 f.getMethAccess().getRightParenthesisKeyword_4());
		
		// Param
		c.setNoLinewrap().around(f.getParamAccess().getColonKeyword_1());
		c.setNoSpace().around(f.getParamAccess().getColonKeyword_1());
		
		// FqnRef
		c.setLinewrap().before(f.getFqnRefAccess().getFqnFQNParserRuleCall_1_0());
		
		// comments
		c.setNoLinewrap().before(f.getSL_COMMENTRule());
	}
}
