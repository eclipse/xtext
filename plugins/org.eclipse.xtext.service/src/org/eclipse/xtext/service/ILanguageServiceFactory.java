package org.eclipse.xtext.service;

public interface ILanguageServiceFactory {

    Class<? extends ILanguageService> getServiceClass();
    
    ILanguageService createLanguageService(); 
}
