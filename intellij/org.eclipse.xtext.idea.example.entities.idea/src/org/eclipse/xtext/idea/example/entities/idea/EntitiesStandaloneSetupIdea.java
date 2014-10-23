package org.eclipse.xtext.idea.example.entities.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.idea.example.entities.EntitiesStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class EntitiesStandaloneSetupIdea extends EntitiesStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.idea.example.entities.EntitiesRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.idea.example.entities.idea.EntitiesIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
