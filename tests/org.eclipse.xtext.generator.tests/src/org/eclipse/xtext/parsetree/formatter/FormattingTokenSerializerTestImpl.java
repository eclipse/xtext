package org.eclipse.xtext.parsetree.formatter;

import org.eclipse.xtext.parsetree.formatter.services.FormatterTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.impl.FormattingConfig;
import org.eclipse.xtext.parsetree.reconstr.impl.FormattingTokenSerializer;

import com.google.inject.Inject;

public class FormattingTokenSerializerTestImpl extends FormattingTokenSerializer {

	@Inject
	public FormattingTokenSerializerTestImpl(FormatterTestLanguageGrammarAccess grammarAccess) {
		super(grammarAccess);
	}

	@Override
	protected void configureFormatting(FormattingConfig c) {
		FormatterTestLanguageGrammarAccess f = (FormatterTestLanguageGrammarAccess) getGrammarAccess();

		c.setLinewrap().after(f.prTestLinewrap().ele0KeywordLinewrap());
		c.setLinewrap().after(f.prLine().ele2KeywordSemicolon());
		c.setNoSpace().before(f.prLine().ele2KeywordSemicolon());
		c.setIndentation(f.prTestIndentation().ele1KeywordLeftCurlyBracket(),
				f.prTestIndentation().ele3KeywordRightCurlyBracket());
		c.setLinewrap().after(f.prTestIndentation().ele1KeywordLeftCurlyBracket());
		c.setLinewrap().after(f.prTestIndentation().ele3KeywordRightCurlyBracket());
	}
}
