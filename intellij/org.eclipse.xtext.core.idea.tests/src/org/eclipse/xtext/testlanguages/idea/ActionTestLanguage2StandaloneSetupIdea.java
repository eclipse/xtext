package org.eclipse.xtext.testlanguages.idea;

import org.eclipse.xtext.testlanguages.ActionTestLanguage2StandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ActionTestLanguage2StandaloneSetupIdea extends ActionTestLanguage2StandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.testlanguages.ActionTestLanguage2RuntimeModule();
        Module ideaModule = new org.eclipse.xtext.testlanguages.idea.ActionTestLanguage2IdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
