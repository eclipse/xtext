package org.eclipse.xtext.parser.parameters.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExLanguage;

public class ParametersTestLanguageExSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return ParametersTestLanguageExLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
