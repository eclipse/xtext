package org.eclipse.xtext.parser.terminalrules.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class TerminalRulesTestLanguageStandaloneSetupIdea extends TerminalRulesTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.terminalrules.idea.TerminalRulesTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
