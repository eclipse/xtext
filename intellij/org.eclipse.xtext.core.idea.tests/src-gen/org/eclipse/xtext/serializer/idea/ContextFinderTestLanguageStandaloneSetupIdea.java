package org.eclipse.xtext.serializer.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.serializer.ContextFinderTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ContextFinderTestLanguageStandaloneSetupIdea extends ContextFinderTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.serializer.ContextFinderTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.serializer.idea.ContextFinderTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
