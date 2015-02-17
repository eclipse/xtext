package org.eclipse.xtext.parsetree.transientvalues.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class TransientValuesTestSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return TransientValuesTestLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
