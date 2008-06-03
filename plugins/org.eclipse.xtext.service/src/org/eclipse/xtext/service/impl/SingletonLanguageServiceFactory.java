package org.eclipse.xtext.service.impl;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;

public class SingletonLanguageServiceFactory implements ILanguageServiceFactory{
	
	private ILanguageService service;
	
	public SingletonLanguageServiceFactory(ILanguageService service) {
		super();
		this.service = service;
	}

	public ILanguageService createLanguageService() {
		return service;
	}

    public Class<? extends ILanguageService> getServiceClass() {
        return service.getClass();
    }

}
