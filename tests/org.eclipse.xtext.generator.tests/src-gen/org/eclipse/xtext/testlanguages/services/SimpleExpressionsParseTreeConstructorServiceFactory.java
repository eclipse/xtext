package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.SimpleExpressionsParseTreeConstructor;

public class SimpleExpressionsParseTreeConstructorServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IParseTreeConstructor serviceObject = new SimpleExpressionsParseTreeConstructor();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IParseTreeConstructor.class;
	}
}
