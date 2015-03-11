package org.eclipse.xtext.xbase.annotations.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class XbaseWithAnnotationsSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return XbaseWithAnnotationsLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
