package org.eclipse.xtext.generator.grammarAccess.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.generator.grammarAccess.GrammarAccessTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GrammarAccessTestLanguageStandaloneSetupIdea extends GrammarAccessTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.generator.grammarAccess.GrammarAccessTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.generator.grammarAccess.idea.GrammarAccessTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
