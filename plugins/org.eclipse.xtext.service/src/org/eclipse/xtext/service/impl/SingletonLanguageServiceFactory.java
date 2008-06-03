package org.eclipse.xtext.service.impl;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;

public class SingletonLanguageServiceFactory implements ILanguageServiceFactory{
	
	private ILanguageService service;
	private ILanguageDescriptor desc;
	

	private SingletonLanguageServiceFactory(ILanguageService service, ILanguageDescriptor desc) {
		super();
		this.service = service;
		this.desc = desc;
	}

	public ILanguageService createLanguageService(ILanguageDescriptor descriptor,
			Class<? extends ILanguageService> serviceClass) {
		return isFactoryFor(descriptor, serviceClass) ? service : null;
	}

	public boolean isFactoryFor(ILanguageDescriptor descriptor, Class<? extends ILanguageService> serviceClass) {
		return desc==descriptor && serviceClass.isInstance(service);
	}

}
