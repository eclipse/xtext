package org.eclipse.xtext.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.XtextParser;

public class XtextParserServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IParser serviceObject = new XtextParser();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IParser.class;
	}
}
