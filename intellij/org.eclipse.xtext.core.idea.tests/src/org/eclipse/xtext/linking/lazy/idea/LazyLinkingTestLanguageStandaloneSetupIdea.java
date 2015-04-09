package org.eclipse.xtext.linking.lazy.idea;

import org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class LazyLinkingTestLanguageStandaloneSetupIdea extends LazyLinkingTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.linking.lazy.idea.LazyLinkingTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
