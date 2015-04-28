package org.eclipse.xtext.parser.terminalrules.idea;

import org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class HiddenTerminalsTestLanguageStandaloneSetupIdea extends HiddenTerminalsTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.terminalrules.idea.HiddenTerminalsTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
