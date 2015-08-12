package org.eclipse.xtext.parser.fragments.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExLanguage;

public class FragmentTestLanguageExSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return FragmentTestLanguageExLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
