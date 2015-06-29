package org.eclipse.xtext.purexbase.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.purexbase.PureXbaseStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class PureXbaseStandaloneSetupIdea extends PureXbaseStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.purexbase.PureXbaseRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.purexbase.idea.PureXbaseIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
