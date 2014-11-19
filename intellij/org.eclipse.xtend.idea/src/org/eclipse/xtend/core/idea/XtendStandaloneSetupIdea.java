package org.eclipse.xtend.core.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtend.core.XtendStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class XtendStandaloneSetupIdea extends XtendStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtend.core.XtendRuntimeModule();
        Module ideaModule = new org.eclipse.xtend.core.idea.XtendIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
