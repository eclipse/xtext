package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class UnorderedGroupsTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return UnorderedGroupsTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
