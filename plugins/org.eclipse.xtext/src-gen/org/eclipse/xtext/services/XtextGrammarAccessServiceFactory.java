package org.eclipse.xtext.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess;

public class XtextGrammarAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IGrammarAccess serviceObject = new XtextGrammarAccess();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IGrammarAccess.class;
	}
}
