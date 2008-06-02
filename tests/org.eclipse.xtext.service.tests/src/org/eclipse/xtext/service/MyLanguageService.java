package org.eclipse.xtext.service;


public class MyLanguageService implements ILanguageService {

    InjectedLanguageService injectedService = null;
    
    public ILanguageDescriptor getLanguageDescriptor() {
        // TODO Auto-generated method stub
        return null;
    }

    public void setLanguageDescriptor(ILanguageDescriptor languageDescriptor) {
        // TODO Auto-generated method stub

    }

    public InjectedLanguageService getInjectedService() {
        return injectedService;
    }

    @InjectedService
    public void setInjectedService(InjectedLanguageService injectedService) {
        this.injectedService = injectedService;
    }

}
