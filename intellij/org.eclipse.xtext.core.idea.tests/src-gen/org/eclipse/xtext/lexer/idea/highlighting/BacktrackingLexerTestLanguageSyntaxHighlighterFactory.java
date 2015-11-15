package org.eclipse.xtext.lexer.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;

public class BacktrackingLexerTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return BacktrackingLexerTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
