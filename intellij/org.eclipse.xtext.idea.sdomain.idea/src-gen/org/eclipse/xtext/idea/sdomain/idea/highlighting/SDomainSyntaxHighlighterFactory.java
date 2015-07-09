package org.eclipse.xtext.idea.sdomain.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;

public class SDomainSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return SDomainLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
