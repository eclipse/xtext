package org.eclipse.xtext.testlanguages.idea;

import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ReferenceGrammarTestLanguageStandaloneSetupIdea extends ReferenceGrammarTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.testlanguages.idea.ReferenceGrammarTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
