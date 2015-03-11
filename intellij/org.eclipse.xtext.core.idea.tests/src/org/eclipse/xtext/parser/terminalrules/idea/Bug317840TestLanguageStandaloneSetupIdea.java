package org.eclipse.xtext.parser.terminalrules.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug317840TestLanguageStandaloneSetupIdea extends Bug317840TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.terminalrules.Bug317840TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.terminalrules.idea.Bug317840TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
