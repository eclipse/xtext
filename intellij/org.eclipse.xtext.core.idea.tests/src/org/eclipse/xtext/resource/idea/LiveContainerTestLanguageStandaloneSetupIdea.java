package org.eclipse.xtext.resource.idea;

import org.eclipse.xtext.resource.LiveContainerTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class LiveContainerTestLanguageStandaloneSetupIdea extends LiveContainerTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.resource.LiveContainerTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.resource.idea.LiveContainerTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
