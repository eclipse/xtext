package org.eclipse.xtext.parser.terminalrules.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.terminalrules.UnicodeTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class UnicodeTestLanguageStandaloneSetupIdea extends UnicodeTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.terminalrules.UnicodeTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.terminalrules.idea.UnicodeTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
