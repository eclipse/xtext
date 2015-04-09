package org.eclipse.xtext.parser.antlr.idea;

import org.eclipse.xtext.parser.antlr.Bug289515TestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug289515TestLanguageStandaloneSetupIdea extends Bug289515TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.antlr.Bug289515TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.antlr.idea.Bug289515TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
