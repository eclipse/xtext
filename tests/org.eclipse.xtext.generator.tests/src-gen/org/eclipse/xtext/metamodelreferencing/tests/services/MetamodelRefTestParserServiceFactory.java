package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.metamodelreferencing.tests.*;
import org.eclipse.xtext.metamodelreferencing.tests.parser.*;

public class MetamodelRefTestParserServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.parser.IParser serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new MetamodelRefTestParser();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == MetamodelRefTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parser.IParser.class.equals(serviceClass);
    }
}
