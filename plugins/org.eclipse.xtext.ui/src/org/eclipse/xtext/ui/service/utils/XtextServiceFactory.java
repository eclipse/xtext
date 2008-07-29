package org.eclipse.xtext.ui.service.utils;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.IServiceFactory;

public class XtextServiceFactory implements IServiceFactory {
	
	private Logger log = Logger.getLogger(XtextServiceFactory.class);

	private static final String CLASS = "class";

	private IConfigurationElement configurationElement;
	private Class<? extends ILanguageService> serviceInterface;

	public XtextServiceFactory(Class<? extends ILanguageService> serviceInterface, IConfigurationElement configurationElement) {
		this.serviceInterface = serviceInterface;
		this.configurationElement = configurationElement;
	}

	public ILanguageService createService() {
		try {
				return (ILanguageService) configurationElement.createExecutableExtension(CLASS);
		}
		catch (CoreException e) {
			log.error("Could not create service.", e);
		}
		return null;
	}

	public Class<? extends ILanguageService> getServiceInterface() {
		return serviceInterface;
	}

}
