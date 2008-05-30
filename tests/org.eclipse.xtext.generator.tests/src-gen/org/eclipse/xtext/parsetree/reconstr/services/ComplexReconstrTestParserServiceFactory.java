package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.parser.*;

public class ComplexReconstrTestParserServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.parser.IParser serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new ComplexReconstrTestParser();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == ComplexReconstrTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parser.IParser.class.equals(serviceClass);
    }
}
