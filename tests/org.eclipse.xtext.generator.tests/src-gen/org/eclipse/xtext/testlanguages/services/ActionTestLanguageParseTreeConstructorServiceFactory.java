package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.ActionTestLanguageParseTreeConstructor;

public class ActionTestLanguageParseTreeConstructorServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IParseTreeConstructor serviceObject = new ActionTestLanguageParseTreeConstructor();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IParseTreeConstructor.class;
	}
}
