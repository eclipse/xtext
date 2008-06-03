package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.GenericEcoreElementFactory;

public class ComplexReconstrTestASTFactoryServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IElementFactory serviceObject = new GenericEcoreElementFactory();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IElementFactory.class;
	}
}
