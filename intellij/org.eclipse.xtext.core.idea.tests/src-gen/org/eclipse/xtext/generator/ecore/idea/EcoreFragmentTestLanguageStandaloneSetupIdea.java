package org.eclipse.xtext.generator.ecore.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.generator.ecore.EcoreFragmentTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class EcoreFragmentTestLanguageStandaloneSetupIdea extends EcoreFragmentTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.generator.ecore.EcoreFragmentTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.generator.ecore.idea.EcoreFragmentTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
