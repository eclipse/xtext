package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.Bug313089TestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug313089TestLanguageStandaloneSetupIdea extends Bug313089TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.Bug313089TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.idea.Bug313089TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
