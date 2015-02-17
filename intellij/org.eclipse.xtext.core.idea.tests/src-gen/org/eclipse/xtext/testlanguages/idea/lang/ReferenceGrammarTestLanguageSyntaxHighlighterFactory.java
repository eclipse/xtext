package org.eclipse.xtext.testlanguages.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class ReferenceGrammarTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return ReferenceGrammarTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
