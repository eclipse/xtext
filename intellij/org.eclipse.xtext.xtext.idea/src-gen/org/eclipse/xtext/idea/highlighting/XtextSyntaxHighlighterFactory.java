package org.eclipse.xtext.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.idea.lang.XtextLanguage;

public class XtextSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return XtextLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
