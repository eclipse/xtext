package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class SimpleReconstrTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return SimpleReconstrTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
