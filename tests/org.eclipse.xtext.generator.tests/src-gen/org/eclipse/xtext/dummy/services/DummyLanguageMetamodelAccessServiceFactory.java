package org.eclipse.xtext.dummy.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.dummy.*;
import org.eclipse.xtext.dummy.parser.*;

public class DummyLanguageMetamodelAccessServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.IMetamodelAccess serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new DummyLanguageMetamodelAccess();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == DummyLanguageStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.IMetamodelAccess.class.equals(serviceClass);
    }
}
