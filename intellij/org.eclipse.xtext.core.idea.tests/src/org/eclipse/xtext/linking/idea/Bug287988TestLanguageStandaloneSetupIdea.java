package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.linking.Bug287988TestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug287988TestLanguageStandaloneSetupIdea extends Bug287988TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.Bug287988TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.idea.Bug287988TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
