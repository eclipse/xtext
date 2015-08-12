package org.eclipse.xtext.parsetree.reconstr.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SerializationErrorTestLanguageStandaloneSetupIdea extends SerializationErrorTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parsetree.reconstr.SerializationErrorTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parsetree.reconstr.idea.SerializationErrorTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
