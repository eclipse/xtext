package org.eclipse.xtext.resource.idea;

import org.eclipse.xtext.resource.LocationProviderTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class LocationProviderTestLanguageStandaloneSetupIdea extends LocationProviderTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.resource.LocationProviderTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.resource.idea.LocationProviderTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
