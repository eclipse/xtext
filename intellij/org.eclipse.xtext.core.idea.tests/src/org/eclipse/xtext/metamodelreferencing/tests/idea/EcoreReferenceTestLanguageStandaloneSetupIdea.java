package org.eclipse.xtext.metamodelreferencing.tests.idea;

import org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class EcoreReferenceTestLanguageStandaloneSetupIdea extends EcoreReferenceTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.metamodelreferencing.tests.EcoreReferenceTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.metamodelreferencing.tests.idea.EcoreReferenceTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
