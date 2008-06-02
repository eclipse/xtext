package org.eclipse.xtext.service;

public class InheritingServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        return new InheritingService();
    }
   
    public boolean isFactoryFor(ILanguageDescriptor descriptor, Class<? extends ILanguageService> serviceClass) {
        return InheritingService.class.equals(serviceClass);
    }
   
}
