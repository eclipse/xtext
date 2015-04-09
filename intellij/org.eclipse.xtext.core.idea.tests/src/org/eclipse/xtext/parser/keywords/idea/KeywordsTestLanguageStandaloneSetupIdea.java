package org.eclipse.xtext.parser.keywords.idea;

import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class KeywordsTestLanguageStandaloneSetupIdea extends KeywordsTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.keywords.KeywordsTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.keywords.idea.KeywordsTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
