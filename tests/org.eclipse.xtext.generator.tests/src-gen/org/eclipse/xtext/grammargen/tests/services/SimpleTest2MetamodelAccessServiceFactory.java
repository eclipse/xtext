package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.grammargen.tests.services.SimpleTest2MetamodelAccess;

public class SimpleTest2MetamodelAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IMetamodelAccess serviceObject = new SimpleTest2MetamodelAccess();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IMetamodelAccess.class;
	}
}
