package org.eclipse.xtext.xtext.ecoreInference.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xtext.ecoreInference.UnassignedRuleCallTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class UnassignedRuleCallTestLanguageStandaloneSetupIdea extends UnassignedRuleCallTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.xtext.ecoreInference.UnassignedRuleCallTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.xtext.ecoreInference.idea.UnassignedRuleCallTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
