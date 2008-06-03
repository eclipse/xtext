package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.grammargen.tests.services.SimpleTestGrammarAccess;

public class SimpleTestGrammarAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IGrammarAccess serviceObject = new SimpleTestGrammarAccess();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IGrammarAccess.class;
	}
}
