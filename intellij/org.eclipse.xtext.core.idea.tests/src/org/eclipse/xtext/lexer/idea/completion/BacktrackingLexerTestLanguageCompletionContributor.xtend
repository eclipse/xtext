package org.eclipse.xtext.lexer.idea.completion

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;

class BacktrackingLexerTestLanguageCompletionContributor extends AbstractBacktrackingLexerTestLanguageCompletionContributor {
	new() {
		this(BacktrackingLexerTestLanguageLanguage.INSTANCE)
	}
	
	new(AbstractXtextLanguage lang) {
		super(lang)
		//custom rules here
	}
}


