package org.eclipse.xtext.resource.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class LiveContainerBuilderIntegerationTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
