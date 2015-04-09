package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.Bug289059TestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug289059TestLanguageStandaloneSetupIdea extends Bug289059TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.Bug289059TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.idea.Bug289059TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
