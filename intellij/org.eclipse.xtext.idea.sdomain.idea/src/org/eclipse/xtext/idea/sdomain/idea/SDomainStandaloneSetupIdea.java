package org.eclipse.xtext.idea.sdomain.idea;

import org.eclipse.xtext.idea.sdomain.SDomainStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SDomainStandaloneSetupIdea extends SDomainStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.idea.sdomain.SDomainRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.idea.sdomain.idea.SDomainIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
