package org.eclipse.xtext.service.fieldInjection;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;

public class ServiceFactory implements ILanguageServiceFactory {

	public ILanguageService createLanguageService() {
		return new IService(){};
	}

	public Class<? extends ILanguageService> getServiceInterface() {
		return IService.class;
	}

}
