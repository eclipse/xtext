package org.eclipse.xtext.parser.assignments.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage;

public class Bug288432TestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return Bug288432TestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
