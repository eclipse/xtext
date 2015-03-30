package org.eclipse.xtext.grammarinheritance.idea;

import org.eclipse.xtext.grammarinheritance.BaseInheritanceTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class BaseInheritanceTestLanguageStandaloneSetupIdea extends BaseInheritanceTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.grammarinheritance.BaseInheritanceTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.grammarinheritance.idea.BaseInheritanceTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
