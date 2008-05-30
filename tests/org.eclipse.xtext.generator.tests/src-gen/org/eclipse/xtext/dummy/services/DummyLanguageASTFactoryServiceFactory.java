package org.eclipse.xtext.dummy.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.dummy.*;
import org.eclipse.xtext.dummy.parser.*;

public class DummyLanguageASTFactoryServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.parser.IElementFactory serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new DummyLanguageASTFactory();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == DummyLanguageStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parser.IElementFactory.class.equals(serviceClass);
    }
}
