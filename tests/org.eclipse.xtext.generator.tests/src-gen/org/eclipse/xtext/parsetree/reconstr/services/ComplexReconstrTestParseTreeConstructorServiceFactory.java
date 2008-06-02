package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parsetree.reconstr.*;
import org.eclipse.xtext.parsetree.reconstr.parser.*;

public class ComplexReconstrTestParseTreeConstructorServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        org.eclipse.xtext.parsetree.IParseTreeConstructor serviceObject = new ComplexReconstrTestParseTreeConstructor();
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == ComplexReconstrTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.parsetree.IParseTreeConstructor.class.equals(serviceClass);
    }
}
