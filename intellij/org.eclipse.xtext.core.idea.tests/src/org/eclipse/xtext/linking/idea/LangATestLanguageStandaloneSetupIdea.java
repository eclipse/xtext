package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.LangATestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class LangATestLanguageStandaloneSetupIdea extends LangATestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.LangATestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.idea.LangATestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
