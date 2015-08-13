package org.eclipse.xtext.grammarinheritance.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.grammarinheritance.InheritanceTest3LanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class InheritanceTest3LanguageStandaloneSetupIdea extends InheritanceTest3LanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.grammarinheritance.InheritanceTest3LanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.grammarinheritance.idea.InheritanceTest3LanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
