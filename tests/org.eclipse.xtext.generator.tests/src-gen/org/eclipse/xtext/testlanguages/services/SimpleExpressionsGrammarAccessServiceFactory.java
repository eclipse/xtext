package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsGrammarAccess;

public class SimpleExpressionsGrammarAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IGrammarAccess serviceObject = new SimpleExpressionsGrammarAccess();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IGrammarAccess.class;
	}
}
