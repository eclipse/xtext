package org.eclipse.xtext.parsetree.unassignedtext.idea;

import org.eclipse.xtext.parsetree.unassignedtext.UnassignedTextTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class UnassignedTextTestLanguageStandaloneSetupIdea extends UnassignedTextTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parsetree.unassignedtext.UnassignedTextTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parsetree.unassignedtext.idea.UnassignedTextTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
