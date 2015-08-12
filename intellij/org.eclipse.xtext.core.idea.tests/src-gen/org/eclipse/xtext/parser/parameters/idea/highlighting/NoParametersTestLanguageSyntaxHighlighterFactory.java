package org.eclipse.xtext.parser.parameters.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage;

public class NoParametersTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return NoParametersTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
