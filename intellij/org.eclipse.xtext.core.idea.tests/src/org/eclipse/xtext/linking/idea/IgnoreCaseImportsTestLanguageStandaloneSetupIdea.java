package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.IgnoreCaseImportsTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class IgnoreCaseImportsTestLanguageStandaloneSetupIdea extends IgnoreCaseImportsTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.IgnoreCaseImportsTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.idea.IgnoreCaseImportsTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
