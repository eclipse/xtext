package org.eclipse.xtext.parser.antlr.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.antlr.Bug299237TestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug299237TestLanguageStandaloneSetupIdea extends Bug299237TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.antlr.Bug299237TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.antlr.idea.Bug299237TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
