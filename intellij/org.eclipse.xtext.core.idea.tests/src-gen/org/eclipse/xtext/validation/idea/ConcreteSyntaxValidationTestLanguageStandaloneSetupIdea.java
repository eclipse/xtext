package org.eclipse.xtext.validation.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ConcreteSyntaxValidationTestLanguageStandaloneSetupIdea extends ConcreteSyntaxValidationTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.validation.ConcreteSyntaxValidationTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.validation.idea.ConcreteSyntaxValidationTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
