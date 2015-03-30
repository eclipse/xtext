package org.eclipse.xtext.metamodelreferencing.tests.idea;

import org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class MultiGenMMTestLanguageStandaloneSetupIdea extends MultiGenMMTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.metamodelreferencing.tests.idea.MultiGenMMTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
