package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import org.jetbrains.annotations.NotNull;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;

public class MetamodelRefTestLanguageSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
	
	@Override
    @NotNull
    protected SyntaxHighlighter createHighlighter() {
        return MetamodelRefTestLanguageLanguage.INSTANCE.getInstance(SyntaxHighlighter.class);
    }

}
