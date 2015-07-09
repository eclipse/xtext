package org.eclipse.xtext.dummy.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;

public class DummyTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return DummyTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
