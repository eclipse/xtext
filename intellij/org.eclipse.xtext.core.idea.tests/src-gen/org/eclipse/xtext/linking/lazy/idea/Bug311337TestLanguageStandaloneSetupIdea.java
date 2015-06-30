package org.eclipse.xtext.linking.lazy.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.linking.lazy.Bug311337TestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug311337TestLanguageStandaloneSetupIdea extends Bug311337TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.lazy.Bug311337TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.lazy.idea.Bug311337TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
