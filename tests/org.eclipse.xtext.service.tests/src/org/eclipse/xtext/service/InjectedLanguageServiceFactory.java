package org.eclipse.xtext.service;

public class InjectedLanguageServiceFactory implements ILanguageServiceFactory{

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        return new InjectedLanguageService();
    }
    
    public boolean isFactoryFor(ILanguageDescriptor descriptor, Class<? extends ILanguageService> serviceClass) {
        return InjectedLanguageService.class.equals(serviceClass);
    }
   
    
}
