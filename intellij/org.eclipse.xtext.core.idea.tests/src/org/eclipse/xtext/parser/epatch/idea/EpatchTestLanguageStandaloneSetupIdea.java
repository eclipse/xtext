package org.eclipse.xtext.parser.epatch.idea;

import org.eclipse.xtext.parser.epatch.EpatchTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class EpatchTestLanguageStandaloneSetupIdea extends EpatchTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.epatch.EpatchTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.epatch.idea.EpatchTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
