package org.eclipse.xtext.lexer.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.lexer.IgnoreCaseLexerTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class IgnoreCaseLexerTestLanguageStandaloneSetupIdea extends IgnoreCaseLexerTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.lexer.IgnoreCaseLexerTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.lexer.idea.IgnoreCaseLexerTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
