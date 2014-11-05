package org.eclipse.xtext.xbase.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.XtypeStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class XtypeStandaloneSetupIdea extends XtypeStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.xbase.XtypeRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.xbase.idea.XtypeIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
