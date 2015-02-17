package org.eclipse.xtext.lexer.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class IgnoreCaseLexerTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return IgnoreCaseLexerTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
