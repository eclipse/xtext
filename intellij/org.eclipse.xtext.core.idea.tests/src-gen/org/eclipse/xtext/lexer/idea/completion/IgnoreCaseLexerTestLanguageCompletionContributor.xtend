package org.eclipse.xtext.lexer.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage;

class IgnoreCaseLexerTestLanguageCompletionContributor extends AbstractIgnoreCaseLexerTestLanguageCompletionContributor {
	new() {
		this(IgnoreCaseLexerTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}
