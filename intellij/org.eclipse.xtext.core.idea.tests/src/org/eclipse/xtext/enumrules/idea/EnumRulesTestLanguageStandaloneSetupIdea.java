package org.eclipse.xtext.enumrules.idea;

import org.eclipse.xtext.enumrules.EnumRulesTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class EnumRulesTestLanguageStandaloneSetupIdea extends EnumRulesTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.enumrules.EnumRulesTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.enumrules.idea.EnumRulesTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
