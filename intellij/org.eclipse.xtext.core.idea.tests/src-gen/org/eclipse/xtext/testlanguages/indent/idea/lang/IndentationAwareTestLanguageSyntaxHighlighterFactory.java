package org.eclipse.xtext.testlanguages.indent.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class IndentationAwareTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return IndentationAwareTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
