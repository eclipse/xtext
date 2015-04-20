package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class SimpleBacktrackingBug325745TestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
