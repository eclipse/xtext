package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.metamodelreferencing.tests.parser.MetamodelRefTestParser;

public class MetamodelRefTestParserServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IParser serviceObject = new MetamodelRefTestParser();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IParser.class;
	}
}
