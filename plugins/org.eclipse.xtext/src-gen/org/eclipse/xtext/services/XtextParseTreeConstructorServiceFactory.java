package org.eclipse.xtext.services;

import org.eclipse.xtext.XtextParseTreeConstructor;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;

public class XtextParseTreeConstructorServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        org.eclipse.xtext.parsetree.IParseTreeConstructor serviceObject = new XtextParseTreeConstructor();
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == XtextStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parsetree.IParseTreeConstructor.class.equals(serviceClass);
    }

    public ILanguageService createLanguageService() {
        org.eclipse.xtext.parsetree.IParseTreeConstructor serviceObject = new XtextParseTreeConstructor();
        return serviceObject;
    }

    public Class<? extends ILanguageService> getServiceClass() {
       return org.eclipse.xtext.parsetree.IParseTreeConstructor.class;
    }
}
