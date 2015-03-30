package org.eclipse.xtext.linking.idea;

import org.eclipse.xtext.linking.ImportUriTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ImportUriTestLanguageStandaloneSetupIdea extends ImportUriTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.ImportUriTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.idea.ImportUriTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
