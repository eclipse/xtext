package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.parser.*;

public class SimpleReconstrTestParseTreeConstructorServiceFactory implements ILanguageServiceFactory {
	private org.eclipse.xtext.parsetree.IParseTreeConstructor serviceObject = null;

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        if (serviceObject == null) {
            serviceObject = new SimpleReconstrTestParseTreeConstructor();
        }
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == SimpleReconstrTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parsetree.IParseTreeConstructor.class.equals(serviceClass);
    }
}
