package org.eclipse.xtext.serializer.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.serializer.SyntacticSequencerTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SyntacticSequencerTestLanguageStandaloneSetupIdea extends SyntacticSequencerTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.serializer.SyntacticSequencerTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.serializer.idea.SyntacticSequencerTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
