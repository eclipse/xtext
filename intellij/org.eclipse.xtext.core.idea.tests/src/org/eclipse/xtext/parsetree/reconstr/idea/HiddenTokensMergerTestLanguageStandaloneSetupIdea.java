package org.eclipse.xtext.parsetree.reconstr.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class HiddenTokensMergerTestLanguageStandaloneSetupIdea extends HiddenTokensMergerTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parsetree.reconstr.HiddenTokensMergerTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parsetree.reconstr.idea.HiddenTokensMergerTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
