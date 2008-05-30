package org.eclipse.xtext.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;

public class XtextGrammarTestParserServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.parser.IParser serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new XtextGrammarTestParser();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == XtextGrammarTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parser.IParser.class.equals(serviceClass);
    }
}
