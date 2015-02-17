package org.eclipse.xtext.serializer.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class HiddenTokenSequencerTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return HiddenTokenSequencerTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
