package org.eclipse.xtext.parser.encoding.idea;

import org.eclipse.xtext.parser.encoding.EncodingTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class EncodingTestLanguageStandaloneSetupIdea extends EncodingTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.encoding.EncodingTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.encoding.idea.EncodingTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
