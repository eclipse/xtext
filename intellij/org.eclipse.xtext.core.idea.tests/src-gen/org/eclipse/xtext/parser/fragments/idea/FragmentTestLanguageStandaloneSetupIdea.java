package org.eclipse.xtext.parser.fragments.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.fragments.FragmentTestLanguageStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class FragmentTestLanguageStandaloneSetupIdea extends FragmentTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.fragments.FragmentTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.fragments.idea.FragmentTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
