package org.eclipse.xtext.parser.unorderedGroups.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.unorderedGroups.SimpleBacktrackingBug325745TestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SimpleBacktrackingBug325745TestLanguageStandaloneSetupIdea extends SimpleBacktrackingBug325745TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.unorderedGroups.SimpleBacktrackingBug325745TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.unorderedGroups.idea.SimpleBacktrackingBug325745TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
