package org.eclipse.xtext.service;

public class MyLanguageServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        return new MyLanguageService();
    }
   
    public Class<? extends ILanguageService> getServiceClass() {
        return MyLanguageService.class;
    }
   
}
