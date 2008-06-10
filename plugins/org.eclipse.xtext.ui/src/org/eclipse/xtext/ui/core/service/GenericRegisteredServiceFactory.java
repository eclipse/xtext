package org.eclipse.xtext.ui.core.service;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.ui.core.internal.Activator;
import org.eclipse.xtext.ui.core.internal.CoreLog;

public class GenericRegisteredServiceFactory implements ILanguageServiceFactory {

    private static final String LANGUAGE_ID = "languageId";
    private static final String CLASS = "class";

    private IConfigurationElement configurationElement;
    private Class<? extends ILanguageService> serviceInterface;
    private ILanguageService service;

    public GenericRegisteredServiceFactory(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceInterface,
            IConfigurationElement configurationElement) throws CoreException {
        this.serviceInterface = serviceInterface;
        this.configurationElement = configurationElement;
        try {
            Class.forName(configurationElement.getAttribute(CLASS));
        } catch (Exception e) {
            throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error finding class", e));
        }
    }

    public ILanguageService createLanguageService() {
        try {
            if(service == null) {
                service = (ILanguageService) configurationElement.createExecutableExtension(CLASS);
            }
            return service;
        } catch (CoreException e) {
            CoreLog.logError(e);
        }
        return null;
    }

    public static IConfigurationElement getConfigurationElement(String serviceName, ILanguageDescriptor languageDescriptor) {
        IExtensionPoint extensionPoint = Platform.getExtensionRegistry().getExtensionPoint(Activator.PLUGIN_ID, serviceName);
        if (extensionPoint == null) {
            return null;
        }
        IConfigurationElement[] configurationElements = extensionPoint.getConfigurationElements();
        for (IConfigurationElement configurationElement : configurationElements) {
            String languageId = configurationElement.getAttribute(LANGUAGE_ID);
            if (languageDescriptor.getId().equals(languageId)) {
                return configurationElement;
            }
        }
        return null;
    }

    public Class<? extends ILanguageService> getServiceInterface() {
        return serviceInterface;
    }

}
