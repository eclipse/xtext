package org.eclipse.xtext.testlanguages.backtracking.idea;

import org.eclipse.xtext.testlanguages.backtracking.ExBeeLangTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ExBeeLangTestLanguageStandaloneSetupIdea extends ExBeeLangTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.testlanguages.backtracking.ExBeeLangTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.testlanguages.backtracking.idea.ExBeeLangTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
