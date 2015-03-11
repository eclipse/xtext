package org.eclipse.xtext.parsetree.impl.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parsetree.impl.Bug305397StandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug305397StandaloneSetupIdea extends Bug305397StandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parsetree.impl.Bug305397RuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parsetree.impl.idea.Bug305397IdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
