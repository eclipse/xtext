package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.grammargen.tests.services.SimpleTest2ResourceFactory;

public class SimpleTest2ResourceFactoryServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IResourceFactory serviceObject = new SimpleTest2ResourceFactory();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IResourceFactory.class;
	}
}
