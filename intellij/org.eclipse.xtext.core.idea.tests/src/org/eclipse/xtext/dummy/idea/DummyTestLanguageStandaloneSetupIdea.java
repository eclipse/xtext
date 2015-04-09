package org.eclipse.xtext.dummy.idea;

import org.eclipse.xtext.dummy.DummyTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class DummyTestLanguageStandaloneSetupIdea extends DummyTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.dummy.DummyTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.dummy.idea.DummyTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
