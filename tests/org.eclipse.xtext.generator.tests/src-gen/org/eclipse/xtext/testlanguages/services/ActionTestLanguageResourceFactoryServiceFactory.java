package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguageResourceFactory;

public class ActionTestLanguageResourceFactoryServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IResourceFactory serviceObject = new ActionTestLanguageResourceFactory();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IResourceFactory.class;
	}
}
