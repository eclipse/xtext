package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.testlanguages.parser.LexerLanguageParser;

public class LexerLanguageParserServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IParser serviceObject = new LexerLanguageParser();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IParser.class;
	}
}
