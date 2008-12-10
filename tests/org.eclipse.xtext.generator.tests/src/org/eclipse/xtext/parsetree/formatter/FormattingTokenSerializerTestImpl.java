package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.impl.FormattingConfig;
import org.eclipse.xtext.parsetree.reconstr.impl.FormattingTokenSerializer;

public class FormattingTokenSerializerTestImpl extends
		FormattingTokenSerializer {

	protected void configureFormatting(FormattingConfig c) {
		FormatterTestLanguageGrammarAccess f = FormatterTestLanguageGrammarAccess.INSTANCE;

		c.setLinewrap().after(f.prTestLinewrap().ele0KeywordLinewrap());
		c.setLinewrap().after(f.prLine().ele1KeywordSemicolon());
		c.setNoSpace().before(f.prLine().ele1KeywordSemicolon());

		c.setIndentation(f.prTestIndentation().ele001KeywordLeftCurlyBracket(),
				f.prTestIndentation().ele1KeywordRightCurlyBracket());
		c.setLinewrap().after(
				f.prTestIndentation().ele001KeywordLeftCurlyBracket());
		c.setLinewrap().after(
				f.prTestIndentation().ele1KeywordRightCurlyBracket());

	}
}
