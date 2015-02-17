package org.eclipse.xtext.parser.datatyperules.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class DatatypeRulesTestLanguageStandaloneSetupIdea extends DatatypeRulesTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.datatyperules.idea.DatatypeRulesTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
