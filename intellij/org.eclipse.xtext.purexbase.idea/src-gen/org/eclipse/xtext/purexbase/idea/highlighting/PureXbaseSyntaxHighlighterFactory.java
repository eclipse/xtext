package org.eclipse.xtext.purexbase.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;

public class PureXbaseSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return PureXbaseLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
