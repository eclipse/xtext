package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.metamodelreferencing.tests.*;
import org.eclipse.xtext.metamodelreferencing.tests.parser.*;

public class MetamodelRefTestResourceFactoryServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        org.eclipse.xtext.resource.IResourceFactory serviceObject = new org.eclipse.xtext.resource.XtextResourceFactory();
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == MetamodelRefTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.resource.IResourceFactory.class.equals(serviceClass);
    }
}
