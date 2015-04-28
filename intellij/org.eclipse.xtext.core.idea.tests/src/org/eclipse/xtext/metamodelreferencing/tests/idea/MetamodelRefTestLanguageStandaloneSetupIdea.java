package org.eclipse.xtext.metamodelreferencing.tests.idea;

import org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestLanguageStandaloneSetupGenerated;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class MetamodelRefTestLanguageStandaloneSetupIdea extends MetamodelRefTestLanguageStandaloneSetupGenerated {

    @Override
    public Injector createInjector() {
        Module runtimeModule = new org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestLanguageRuntimeModule();
        Module ideaModule = new org.eclipse.xtext.metamodelreferencing.tests.idea.MetamodelRefTestLanguageIdeaModule();
        Module mergedModule = Modules2.mixin(runtimeModule, ideaModule);
        return Guice.createInjector(mergedModule);
    }

}
