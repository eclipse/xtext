package org.eclipse.xtext.generator.ecore.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.generator.ecore.SuperTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SuperTestLanguageStandaloneSetupIdea extends SuperTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.generator.ecore.SuperTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.generator.ecore.idea.SuperTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
