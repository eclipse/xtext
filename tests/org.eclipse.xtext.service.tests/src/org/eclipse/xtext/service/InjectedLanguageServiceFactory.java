package org.eclipse.xtext.service;

public class InjectedLanguageServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        return new InjectedLanguageService();
    }

    public Class<? extends ILanguageService> getServiceClass() {
        return InjectedLanguageService.class;
    }

}
