package org.eclipse.xtext.parser.antlr.idea;

import org.eclipse.xtext.parser.antlr.Bug301935ExTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug301935ExTestLanguageStandaloneSetupIdea extends Bug301935ExTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.antlr.Bug301935ExTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.antlr.idea.Bug301935ExTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
