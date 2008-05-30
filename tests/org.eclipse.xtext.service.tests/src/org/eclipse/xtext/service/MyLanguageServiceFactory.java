package org.eclipse.xtext.service;

public class MyLanguageServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        return new MyLanguageService();
    }
   
    public boolean isFactoryFor(ILanguageDescriptor descriptor, Class<? extends ILanguageService> serviceClass) {
        return MyLanguageService.class.equals(serviceClass);
    }
   
}
