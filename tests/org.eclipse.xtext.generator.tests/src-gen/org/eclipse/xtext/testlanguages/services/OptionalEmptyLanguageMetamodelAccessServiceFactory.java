package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.testlanguages.*;
import org.eclipse.xtext.testlanguages.parser.*;

public class OptionalEmptyLanguageMetamodelAccessServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.IMetamodelAccess serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new OptionalEmptyLanguageMetamodelAccess();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == OptionalEmptyLanguageStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.IMetamodelAccess.class.equals(serviceClass);
    }
}
