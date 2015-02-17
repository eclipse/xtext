package org.eclipse.xtext.valueconverter.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class Bug250313SyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return Bug250313Language.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
