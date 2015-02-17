package org.eclipse.xtext.parsetree.unassignedtext.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class UnassignedTextTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return UnassignedTextTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
