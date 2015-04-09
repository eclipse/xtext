package org.eclipse.xtext.serializer.idea;

import org.eclipse.xtext.serializer.SequencerTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class SequencerTestLanguageStandaloneSetupIdea extends SequencerTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.serializer.SequencerTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.serializer.idea.SequencerTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
