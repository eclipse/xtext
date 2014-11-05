package org.eclipse.xtext.xbase.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class XtypeSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return XtypeLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
