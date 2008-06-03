package org.eclipse.xtext.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.services.XtextResourceFactory;

public class XtextResourceFactoryServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IResourceFactory serviceObject = new XtextResourceFactory();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IResourceFactory.class;
	}
}
