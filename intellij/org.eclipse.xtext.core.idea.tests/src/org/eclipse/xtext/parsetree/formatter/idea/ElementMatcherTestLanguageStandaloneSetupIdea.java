package org.eclipse.xtext.parsetree.formatter.idea;

import org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class ElementMatcherTestLanguageStandaloneSetupIdea extends ElementMatcherTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parsetree.formatter.ElementMatcherTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parsetree.formatter.idea.ElementMatcherTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
