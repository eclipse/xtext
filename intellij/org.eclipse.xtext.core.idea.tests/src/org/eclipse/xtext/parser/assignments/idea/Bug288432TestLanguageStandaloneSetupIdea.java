package org.eclipse.xtext.parser.assignments.idea;

import org.eclipse.xtext.parser.assignments.Bug288432TestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug288432TestLanguageStandaloneSetupIdea extends Bug288432TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.assignments.Bug288432TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.assignments.idea.Bug288432TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
