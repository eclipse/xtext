package org.eclipse.xtext.index.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.index.IndexTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class IndexTestLanguageStandaloneSetupIdea extends IndexTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.index.IndexTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.index.idea.IndexTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
