package org.eclipse.xtext.idea.common.types.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.idea.common.types.RefactoringTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class RefactoringTestLanguageStandaloneSetupIdea extends RefactoringTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.idea.common.types.RefactoringTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.idea.common.types.idea.RefactoringTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
