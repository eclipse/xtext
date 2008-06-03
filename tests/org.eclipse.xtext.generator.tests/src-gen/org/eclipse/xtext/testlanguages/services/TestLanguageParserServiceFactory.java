package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.testlanguages.parser.TestLanguageParser;

public class TestLanguageParserServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IParser serviceObject = new TestLanguageParser();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IParser.class;
	}
}
