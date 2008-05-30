package org.eclipse.xtext.dummy.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.dummy.*;
import org.eclipse.xtext.dummy.parser.*;

public class DummyLanguageGrammarAccessServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.IGrammarAccess serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new DummyLanguageGrammarAccess();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == DummyLanguageStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.IGrammarAccess.class.equals(serviceClass);
    }
}
