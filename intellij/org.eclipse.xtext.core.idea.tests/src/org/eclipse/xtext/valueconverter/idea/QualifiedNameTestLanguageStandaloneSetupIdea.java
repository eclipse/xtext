package org.eclipse.xtext.valueconverter.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.valueconverter.QualifiedNameTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class QualifiedNameTestLanguageStandaloneSetupIdea extends QualifiedNameTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.valueconverter.QualifiedNameTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.valueconverter.idea.QualifiedNameTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
