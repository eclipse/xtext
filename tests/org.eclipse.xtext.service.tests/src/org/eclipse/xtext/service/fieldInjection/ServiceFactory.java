package org.eclipse.xtext.service.fieldInjection;

import org.eclipse.xtext.service.IServiceFactory;

public class ServiceFactory implements IServiceFactory {

	public Object createService() {
		return new IService(){};
	}

	public Class<? extends Object> getServiceInterface() {
		return IService.class;
	}

}
