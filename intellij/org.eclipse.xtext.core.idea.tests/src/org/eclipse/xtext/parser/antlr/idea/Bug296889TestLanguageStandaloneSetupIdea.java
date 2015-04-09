package org.eclipse.xtext.parser.antlr.idea;

import org.eclipse.xtext.parser.antlr.Bug296889TestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug296889TestLanguageStandaloneSetupIdea extends Bug296889TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.antlr.Bug296889TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.antlr.idea.Bug296889TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
