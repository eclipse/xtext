package org.eclipse.xtext.lexer.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.lexer.BacktrackingLexerTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class BacktrackingLexerTestLanguageStandaloneSetupIdea extends BacktrackingLexerTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.lexer.BacktrackingLexerTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.lexer.idea.BacktrackingLexerTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
