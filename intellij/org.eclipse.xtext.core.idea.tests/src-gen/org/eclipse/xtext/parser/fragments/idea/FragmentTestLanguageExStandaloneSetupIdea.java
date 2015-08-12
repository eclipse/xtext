package org.eclipse.xtext.parser.fragments.idea;

import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.parser.fragments.FragmentTestLanguageExStandaloneSetupGenerated;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class FragmentTestLanguageExStandaloneSetupIdea extends FragmentTestLanguageExStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.parser.fragments.FragmentTestLanguageExRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.parser.fragments.idea.FragmentTestLanguageExIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
