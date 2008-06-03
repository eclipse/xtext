package org.eclipse.xtext.ui.services;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.ui.core.internal.Activator;
import org.eclipse.xtext.ui.core.internal.CoreLog;

public class GenericRegisteredServiceFactory implements ILanguageServiceFactory {

    private static final String LANGUAGE_ID = "languageId";
    private static final String CLASS = "class";

    private ILanguageDescriptor languageDescriptor;
    private String serviceName;
    private Class<? extends ILanguageService> serviceClass;

    public GenericRegisteredServiceFactory(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass, String serviceName) {
        this.languageDescriptor = languageDescriptor;
        this.serviceClass = serviceClass;
        this.serviceName = serviceName;
    }
    
    public ILanguageService createLanguageService() {
        return createServiceExtension();
    }

    private ILanguageService createServiceExtension() {
        IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(Activator.PLUGIN_ID,
                serviceName);
        if (extensionPoint == null) {
            return null;
        }
        IConfigurationElement[] configurationElements = extensionPoint.getConfigurationElements();
        for (IConfigurationElement configurationElement : configurationElements) {
            try {
                String languageId = configurationElement.getAttribute(LANGUAGE_ID);
                if (languageDescriptor.getId().equals(languageId)) {
                    ILanguageService service = (ILanguageService) configurationElement
                            .createExecutableExtension(CLASS);
                    return service;
                }
            }
            catch (CoreException e) {
                CoreLog.log(e.getStatus());
            }
        }
        return null;
    }
    
    public Class<? extends ILanguageService> getServiceClass() {
        return serviceClass;
    }

}
