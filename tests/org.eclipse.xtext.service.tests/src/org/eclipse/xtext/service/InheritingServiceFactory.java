package org.eclipse.xtext.service;

public class InheritingServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        return new InheritingService();
    }

    public Class<? extends ILanguageService> getServiceClass() {
        return InheritingService.class;
    }
   
   
}
