package org.eclipse.xtext.parser.unorderedGroups.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class BacktrackingBug325745TestLanguageStandaloneSetupIdea extends BacktrackingBug325745TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.unorderedGroups.BacktrackingBug325745TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.unorderedGroups.idea.BacktrackingBug325745TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
