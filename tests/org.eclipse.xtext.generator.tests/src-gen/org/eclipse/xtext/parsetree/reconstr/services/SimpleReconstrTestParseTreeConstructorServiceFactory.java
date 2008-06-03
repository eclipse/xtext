package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestParseTreeConstructor;

public class SimpleReconstrTestParseTreeConstructorServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IParseTreeConstructor serviceObject = new SimpleReconstrTestParseTreeConstructor();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IParseTreeConstructor.class;
	}
}
