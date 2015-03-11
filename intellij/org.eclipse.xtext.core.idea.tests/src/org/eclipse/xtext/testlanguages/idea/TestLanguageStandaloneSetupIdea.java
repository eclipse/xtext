package org.eclipse.xtext.testlanguages.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.testlanguages.TestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class TestLanguageStandaloneSetupIdea extends TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.testlanguages.TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.testlanguages.idea.TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
