package org.eclipse.xtext.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.XtextParseTreeConstructor;

public class XtextParseTreeConstructorServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IParseTreeConstructor serviceObject = new XtextParseTreeConstructor();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IParseTreeConstructor.class;
	}
}
