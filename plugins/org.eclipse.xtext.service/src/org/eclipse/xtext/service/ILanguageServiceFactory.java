package org.eclipse.xtext.service;

public interface ILanguageServiceFactory {

    boolean isFactoryFor(ILanguageDescriptor descriptor, Class<? extends ILanguageService> serviceClass);
    
    ILanguageService createLanguageService(ILanguageDescriptor descriptor, Class<? extends ILanguageService> serviceClass); 
}
