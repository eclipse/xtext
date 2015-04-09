package org.eclipse.xtext.parser.antlr.idea;

import org.eclipse.xtext.parser.antlr.Bug443221TestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug443221TestLanguageStandaloneSetupIdea extends Bug443221TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.antlr.Bug443221TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.antlr.idea.Bug443221TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
