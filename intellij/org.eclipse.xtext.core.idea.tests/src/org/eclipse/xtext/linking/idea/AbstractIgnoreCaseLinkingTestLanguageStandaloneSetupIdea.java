package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.AbstractIgnoreCaseLinkingTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class AbstractIgnoreCaseLinkingTestLanguageStandaloneSetupIdea extends AbstractIgnoreCaseLinkingTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.AbstractIgnoreCaseLinkingTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.idea.AbstractIgnoreCaseLinkingTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
