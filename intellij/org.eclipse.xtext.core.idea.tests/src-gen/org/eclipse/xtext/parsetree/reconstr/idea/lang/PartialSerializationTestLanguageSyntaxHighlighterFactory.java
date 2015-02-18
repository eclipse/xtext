package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class PartialSerializationTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return PartialSerializationTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
