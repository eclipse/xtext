package org.eclipse.xtext.service;

public class CompoundLanguageServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if(InjectedLanguageService.class.equals(serviceClass)) {
            return new InjectedLanguageService();
        } else if(MyLanguageService.class.equals(serviceClass)) {
            return new MyLanguageService();
        }
        return null;
    }

    public boolean isFactoryFor(ILanguageDescriptor descriptor, Class<? extends ILanguageService> serviceClass) {
        return MyLanguageService.class.equals(serviceClass) || InjectedLanguageService.class.equals(serviceClass);
    }
   
}
