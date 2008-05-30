package org.eclipse.xtext.service;

public class MyLanguageServiceFactory implements ILanguageServiceFactory<MyLanguageService>{

    public MyLanguageService createLanguageService() {
        return new MyLanguageService();
    }

    public Class<? extends MyLanguageService> getServiceClass() {
        return MyLanguageService.class;
    }
    
}
