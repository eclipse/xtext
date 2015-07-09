package org.eclipse.xtext.parser.keywords.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;

public class KeywordsTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return KeywordsTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
