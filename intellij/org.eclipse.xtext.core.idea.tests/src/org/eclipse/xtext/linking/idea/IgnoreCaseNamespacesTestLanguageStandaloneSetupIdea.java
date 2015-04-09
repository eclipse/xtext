package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.IgnoreCaseNamespacesTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class IgnoreCaseNamespacesTestLanguageStandaloneSetupIdea extends IgnoreCaseNamespacesTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.IgnoreCaseNamespacesTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.idea.IgnoreCaseNamespacesTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
