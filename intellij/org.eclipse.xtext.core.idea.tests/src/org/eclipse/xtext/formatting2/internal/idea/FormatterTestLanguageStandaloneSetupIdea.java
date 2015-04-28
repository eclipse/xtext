package org.eclipse.xtext.formatting2.internal.idea;

import org.eclipse.xtext.formatting2.internal.FormatterTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class FormatterTestLanguageStandaloneSetupIdea extends FormatterTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.formatting2.internal.FormatterTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.formatting2.internal.idea.FormatterTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
