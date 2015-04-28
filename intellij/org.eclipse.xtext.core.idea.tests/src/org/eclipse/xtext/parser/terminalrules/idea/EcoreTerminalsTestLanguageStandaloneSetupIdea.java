package org.eclipse.xtext.parser.terminalrules.idea;

import org.eclipse.xtext.parser.terminalrules.EcoreTerminalsTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class EcoreTerminalsTestLanguageStandaloneSetupIdea extends EcoreTerminalsTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.terminalrules.EcoreTerminalsTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.terminalrules.idea.EcoreTerminalsTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
