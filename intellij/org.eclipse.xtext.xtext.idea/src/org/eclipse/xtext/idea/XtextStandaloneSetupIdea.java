package org.eclipse.xtext.idea;

import org.eclipse.xtext.XtextStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class XtextStandaloneSetupIdea extends XtextStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.XtextRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.idea.XtextIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
