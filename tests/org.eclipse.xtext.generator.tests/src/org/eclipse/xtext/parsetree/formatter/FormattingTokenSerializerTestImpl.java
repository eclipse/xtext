package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.formatter.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatter.impl.FormattingConfig;
import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;

public class FormattingTokenSerializerTestImpl extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		FormatterTestLanguageGrammarAccess f = (FormatterTestLanguageGrammarAccess) getGrammarAccess();

		c.setLinewrap().after(f.getTestLinewrapAccess().getLinewrapKeyword_0());
		c.setLinewrap().after(f.getLineAccess().getSemicolonKeyword_2());
		c.setNoSpace().before(f.getLineAccess().getSemicolonKeyword_2());
		c.setIndentation(f.getTestIndentationAccess().getLeftCurlyBracketKeyword_1(),
				f.getTestIndentationAccess().getRightCurlyBracketKeyword_3());
		c.setLinewrap().after(f.getTestIndentationAccess().getLeftCurlyBracketKeyword_1());
		c.setLinewrap().after(f.getTestIndentationAccess().getRightCurlyBracketKeyword_3());
		c.setNoLinewrap().before(f.getSL_COMMENTRule());
		c.setNoSpace().after(f.getSL_COMMENTRule());
	}
}
