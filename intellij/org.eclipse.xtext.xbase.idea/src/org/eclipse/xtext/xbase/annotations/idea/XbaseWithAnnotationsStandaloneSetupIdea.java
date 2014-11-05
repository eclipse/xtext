package org.eclipse.xtext.xbase.annotations.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class XbaseWithAnnotationsStandaloneSetupIdea extends XbaseWithAnnotationsStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.xbase.annotations.XbaseWithAnnotationsRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.xbase.annotations.idea.XbaseWithAnnotationsIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
