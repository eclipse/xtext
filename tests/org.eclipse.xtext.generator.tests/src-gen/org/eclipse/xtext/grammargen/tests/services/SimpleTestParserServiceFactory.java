package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.grammargen.tests.parser.SimpleTestParser;

public class SimpleTestParserServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IParser serviceObject = new SimpleTestParser();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IParser.class;
	}
}
