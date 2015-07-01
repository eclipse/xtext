package org.eclipse.xtext.parsetree.reconstr.idea;

import org.eclipse.xtext.parsetree.reconstr.SerializationBug269362TestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SerializationBug269362TestLanguageStandaloneSetupIdea extends SerializationBug269362TestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parsetree.reconstr.SerializationBug269362TestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parsetree.reconstr.idea.SerializationBug269362TestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
