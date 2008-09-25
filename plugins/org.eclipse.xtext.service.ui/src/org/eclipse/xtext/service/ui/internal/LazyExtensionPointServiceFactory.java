package org.eclipse.xtext.service.ui.internal;


import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.xtext.service.IServiceFactory;
import org.eclipse.xtext.service.IServiceScope;

public class LazyExtensionPointServiceFactory implements IServiceFactory {
	
	private static final Logger log = Logger.getLogger(LazyExtensionPointServiceFactory.class);

	private static final String CLASS = "class";

	private IConfigurationElement configurationElement;
	
	private IServiceFactory serviceFactory;

	public LazyExtensionPointServiceFactory(IServiceScope languageDescriptor, IConfigurationElement configurationElement) {
		this.configurationElement = configurationElement;
	}

	public Object createService() {
		return getFactory().createService();
	}

	private synchronized IServiceFactory getFactory() {
		if (serviceFactory==null)
			try {
				serviceFactory = (IServiceFactory) configurationElement.createExecutableExtension(CLASS);
			} catch (CoreException e) {
				log.error("Couldn't activate registered service factory : "+configurationElement.getAttribute(CLASS),e);
			}
		return serviceFactory;
	}

	public Class<?> getServiceInterface() {
		return getFactory().getServiceInterface();
	}

}
