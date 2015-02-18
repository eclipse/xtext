package org.eclipse.xtext.parser.unorderedGroups.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.unorderedGroups.SimpleUnorderedGroupsTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SimpleUnorderedGroupsTestLanguageStandaloneSetupIdea extends SimpleUnorderedGroupsTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.unorderedGroups.SimpleUnorderedGroupsTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.unorderedGroups.idea.SimpleUnorderedGroupsTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
