package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.grammargen.tests.*;
import org.eclipse.xtext.grammargen.tests.parser.*;

public class SimpleTestASTFactoryServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        org.eclipse.xtext.parser.IElementFactory serviceObject = new org.eclipse.xtext.parser.GenericEcoreElementFactory();
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == SimpleTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parser.IElementFactory.class.equals(serviceClass);
    }
}
