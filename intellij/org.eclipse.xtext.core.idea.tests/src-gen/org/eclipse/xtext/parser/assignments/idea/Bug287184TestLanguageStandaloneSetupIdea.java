package org.eclipse.xtext.parser.assignments.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.assignments.Bug287184TestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug287184TestLanguageStandaloneSetupIdea extends Bug287184TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.assignments.Bug287184TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.assignments.idea.Bug287184TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
