package org.eclipse.xtext.idea.common.types.idea.highlighting;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;

public class RefactoringTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return RefactoringTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
