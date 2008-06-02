package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.metamodelreferencing.tests.*;
import org.eclipse.xtext.metamodelreferencing.tests.parser.*;

public class MetamodelRefTestMetamodelAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        org.eclipse.xtext.IMetamodelAccess serviceObject = new MetamodelRefTestMetamodelAccess();
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == MetamodelRefTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.IMetamodelAccess.class.equals(serviceClass);
    }
}
