package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.grammargen.tests.*;
import org.eclipse.xtext.grammargen.tests.parser.*;

public class SimpleTestMetamodelAccessServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.IMetamodelAccess serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new SimpleTestMetamodelAccess();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == SimpleTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.IMetamodelAccess.class.equals(serviceClass);
    }
}
