package org.eclipse.xtext.parser.fragments.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;

public class FragmentTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return FragmentTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
