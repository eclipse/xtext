package org.eclipse.xtext.testlanguages.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SimpleExpressionsTestLanguageStandaloneSetupIdea extends SimpleExpressionsTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.testlanguages.idea.SimpleExpressionsTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
