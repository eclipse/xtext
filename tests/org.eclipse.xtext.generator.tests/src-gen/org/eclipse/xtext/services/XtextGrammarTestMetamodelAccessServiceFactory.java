package org.eclipse.xtext.services;

import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;

public class XtextGrammarTestMetamodelAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
        org.eclipse.xtext.IMetamodelAccess serviceObject = new XtextGrammarTestMetamodelAccess();
        return serviceObject;
    }

    public boolean isFactoryFor(ILanguageDescriptor languageDescriptor, Class<? extends ILanguageService> serviceClass) {
       return languageDescriptor == XtextGrammarTestStandaloneSetup.getLanguageDescriptor()
           && org.eclipse.xtext.IMetamodelAccess.class.equals(serviceClass);
    }
}
