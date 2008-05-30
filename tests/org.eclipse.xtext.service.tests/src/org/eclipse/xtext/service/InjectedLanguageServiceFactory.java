package org.eclipse.xtext.service;

public class InjectedLanguageServiceFactory implements ILanguageServiceFactory<InjectedLanguageService>{

    public InjectedLanguageService createLanguageService() {
        return new InjectedLanguageService();
    }

    public Class<? extends InjectedLanguageService> getServiceClass() {
        return InjectedLanguageService.class;
    }
    
}
