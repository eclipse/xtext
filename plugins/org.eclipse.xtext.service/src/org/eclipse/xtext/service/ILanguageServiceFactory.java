package org.eclipse.xtext.service;

public interface ILanguageServiceFactory<T extends ILanguageService> {

    Class<? extends T> getServiceClass();
    
    T createLanguageService(); 
}
