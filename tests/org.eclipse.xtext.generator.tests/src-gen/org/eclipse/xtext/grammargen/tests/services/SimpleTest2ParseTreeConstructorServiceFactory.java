package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.grammargen.tests.*;
import org.eclipse.xtext.grammargen.tests.parser.*;

public class SimpleTest2ParseTreeConstructorServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.parsetree.IParseTreeConstructor serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new SimpleTest2ParseTreeConstructor();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == SimpleTest2StandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parsetree.IParseTreeConstructor.class.equals(serviceClass);
    }
}
