package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class SimpleBeeLangTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return SimpleBeeLangTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
