package org.eclipse.xtext.parsetree.reconstr.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SimpleReconstrTestLanguageStandaloneSetupIdea extends SimpleReconstrTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parsetree.reconstr.idea.SimpleReconstrTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
