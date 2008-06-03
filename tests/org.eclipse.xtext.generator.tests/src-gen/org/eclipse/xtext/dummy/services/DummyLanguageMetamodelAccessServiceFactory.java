package org.eclipse.xtext.dummy.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.dummy.services.DummyLanguageMetamodelAccess;

public class DummyLanguageMetamodelAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IMetamodelAccess serviceObject = new DummyLanguageMetamodelAccess();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IMetamodelAccess.class;
	}
}
