package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class UnassignedRuleCallTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return UnassignedRuleCallTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
