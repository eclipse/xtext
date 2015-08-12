package org.eclipse.xtext.parser.parameters.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.parameters.ParametersTestLanguageExStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ParametersTestLanguageExStandaloneSetupIdea extends ParametersTestLanguageExStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.parameters.ParametersTestLanguageExRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.parameters.idea.ParametersTestLanguageExIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
