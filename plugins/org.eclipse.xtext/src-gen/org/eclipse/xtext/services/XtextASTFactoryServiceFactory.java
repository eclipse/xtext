package org.eclipse.xtext.services;

import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;

public class XtextASTFactoryServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        org.eclipse.xtext.parser.IElementFactory serviceObject = new org.eclipse.xtext.parser.GenericEcoreElementFactory();
        return serviceObject;
    }

    public Class<? extends ILanguageService> getServiceClass() {
        return IElementFactory.class;
    }

}
