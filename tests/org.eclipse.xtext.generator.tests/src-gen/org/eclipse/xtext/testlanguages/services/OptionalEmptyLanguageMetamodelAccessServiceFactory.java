package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.testlanguages.services.OptionalEmptyLanguageMetamodelAccess;

public class OptionalEmptyLanguageMetamodelAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IMetamodelAccess serviceObject = new OptionalEmptyLanguageMetamodelAccess();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IMetamodelAccess.class;
	}
}
