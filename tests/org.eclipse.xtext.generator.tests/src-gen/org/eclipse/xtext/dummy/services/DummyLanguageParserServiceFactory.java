package org.eclipse.xtext.dummy.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.dummy.*;
import org.eclipse.xtext.dummy.parser.*;

public class DummyLanguageParserServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        org.eclipse.xtext.parser.IParser serviceObject = new DummyLanguageParser();
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == DummyLanguageStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parser.IParser.class.equals(serviceClass);
    }
}
