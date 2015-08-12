package org.eclipse.xtext.parsetree.reconstr.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parsetree.reconstr.Bug299395TestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class Bug299395TestLanguageStandaloneSetupIdea extends Bug299395TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parsetree.reconstr.Bug299395TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parsetree.reconstr.idea.Bug299395TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
