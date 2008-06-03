package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.service.ILanguageServiceFactory;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestMetamodelAccess;

public class SimpleReconstrTestMetamodelAccessServiceFactory implements ILanguageServiceFactory {

    public ILanguageService createLanguageService() {
        IMetamodelAccess serviceObject = new SimpleReconstrTestMetamodelAccess();
        return serviceObject;
    }

	public Class<? extends ILanguageService> getServiceClass() {
		return IMetamodelAccess.class;
	}
}
