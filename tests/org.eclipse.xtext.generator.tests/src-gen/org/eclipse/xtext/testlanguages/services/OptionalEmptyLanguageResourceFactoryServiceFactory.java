package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyLanguageResourceFactory;

public class OptionalEmptyLanguageResourceFactoryServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IResourceFactory serviceObject = new OptionalEmptyLanguageResourceFactory();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IResourceFactory.class;
	}
}
