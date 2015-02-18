package org.eclipse.xtext.parser.unorderedGroups.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class SimpleUnorderedGroupsTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
