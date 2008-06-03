package org.eclipse.xtext.service;


public class MyLanguageService implements ILanguageService {

    InjectedLanguageService injectedService = null;

    public InjectedLanguageService getInjectedService() {
        return injectedService;
    }

    @InjectedService
    public void setInjectedService(InjectedLanguageService injectedService) {
        this.injectedService = injectedService;
    }

}
