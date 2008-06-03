package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.metamodelreferencing.tests.services.MetamodelRefTestResourceFactory;

public class MetamodelRefTestResourceFactoryServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IResourceFactory serviceObject = new MetamodelRefTestResourceFactory();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IResourceFactory.class;
	}
}
