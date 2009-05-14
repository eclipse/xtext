package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractFormattingTokenSerializer;
import org.eclipse.xtext.parsetree.reconstr.impl.FormattingConfig;

public class FormattingTokenSerializerTestImpl extends AbstractFormattingTokenSerializer {

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
	}
}
